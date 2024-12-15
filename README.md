# 缓慢旋转的立方体


## 概述

该应用程序由几个 Java 类组成：

- `Main.java`：应用程序的入口点，设置主框架和布局。
- `CubeModel.java`：表示 3D 立方体模型并处理旋转逻辑。
- `ControlPanel.java`：提供用户界面来控制立方体的旋转。
- `RotationHandler.java`：实现`RotationListener`接口来更新UI状态。
- `RotationListener.java`：用于监听旋转开始和停止事件的接口。

## 实施细节

### Main.java

- 使用“JFrame”设置主窗口。
- 初始化`CubeModel`和`ControlPanel`。
- 配置布局以显示多维数据集和控制面板。

### CubeModel.java

- 扩展“JPanel”，为立方体提供自定义绘图区域。
- 定义立方体的顶点和边。
- 使用三角函数实现旋转逻辑。
- 重写`paintComponent`来绘制立方体并处理旋转动画。

### 控制面板.java

- 提供按钮来启动和停止立方体的旋转。
- 包括一个用于调节旋转速度的滑块。
- 监听按钮操作来控制“CubeModel”。

### RotationHandler.java

- 实现“RotationListener”接口，以在旋转开始或停止时更新状态标签。

### RotationListener.java

- 定义旋转事件的接口，允许组件对旋转开始和停止做出反应。


### 最后
- jdk : 17 LTS
- 运行: ./build.sh && java -jar out/cube.jar
- github: git@github.com:outsider-persl/cube.git



