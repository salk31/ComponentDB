#!/bin/bash

# Copyright (c) UChicago Argonne, LLC. All rights reserved.
# See LICENSE file.


currentDir=`pwd`
cd `dirname $0`/.. && topDir=`pwd`
binDir=$topDir/bin

echo "XXXXXXXXXXXXXXXXXXXXXXX before java2"
$binDir/install_java.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXX before ant"
$binDir/install_ant.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXX before glassfish"
$binDir/install_glassfish.sh || exit 1
echo "XXXXXXXXXXXXXXXXXXXXXXX before after glassfish"
