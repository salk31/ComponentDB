#!/bin/bash

# Copyright (c) UChicago Argonne, LLC. All rights reserved.
# See LICENSE file.

echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"

currentDir=`pwd`
cd `dirname $0`/.. && topDir=`pwd`
binDir=$topDir/bin

echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX before build_python"
$binDir/build_python.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX before setup tools"
$binDir/install_setuptools.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX before click"
$binDir/install_click.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX before python ldap"
$binDir/install_python_ldap.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX before pip"
$binDir/install_pip.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX before sphinx"
$binDir/install_sphinx.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX before twine"
$binDir/install_twine.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX before cherrypy"
$binDir/build_cherrypy.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX after cherrypy"
$binDir/install_routes.sh || exit 1
$binDir/build_sqlalchemy.sh || exit 1
$binDir/build_mysql_python.sh || exit 1
$binDir/build_suds.sh || exit 1
