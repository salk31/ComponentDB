#!/bin/bash

# Copyright (c) UChicago Argonne, LLC. All rights reserved.
# See LICENSE file.


currentDir=`pwd`
cd `dirname $0`/.. && topDir=`pwd`
binDir=$topDir/bin

$binDir/install_anaconda.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX before java"
$binDir/install_java_packages.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX after java"
$binDir/install_python_packages.sh || exit 1
