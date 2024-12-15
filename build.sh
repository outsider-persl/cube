#!/bin/bash

# 设置项目的根目录
PROJECT_DIR=$(pwd)

# 设置源代码目录
SRC_DIR="$PROJECT_DIR/src"

# 设置目标目录
TARGET_DIR="$PROJECT_DIR/out"

# 创建目标目录
mkdir -p $TARGET_DIR

# 编译所有 Java 源文件
echo "编译 Java 源文件..."
javac -d $TARGET_DIR $SRC_DIR/*.java

# 打包成一个 JAR 文件
echo "打包为 JAR 文件..."
jar cfe $TARGET_DIR/cube.jar Main -C $TARGET_DIR .

# 输出成功信息
echo "构建成功！JAR 文件已生成: $TARGET_DIR/cube.jar"
