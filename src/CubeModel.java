import javax.swing.*;
import java.awt.*;

/**
 * 立方体模型类，负责绘制旋转的立方体并处理旋转逻辑。
 * 继承自 JPanel，用于在窗口中展示立方体的旋转效果。
 */
public class CubeModel extends JPanel {
    private double[][] vertices = {
            {-1, -1, -1}, {1, -1, -1}, {1, 1, -1}, {-1, 1, -1},
            {-1, -1, 1}, {1, -1, 1}, {1, 1, 1}, {-1, 1, 1}
    };
    private int[][] edges = {
            {0, 1}, {1, 2}, {2, 3}, {3, 0},
            {4, 5}, {5, 6}, {6, 7}, {7, 4},
            {0, 4}, {1, 5}, {2, 6}, {3, 7}
    };
    private double angleX = 0, angleY = 0, angleZ = 0;
    double rotationSpeed = 0.01;
    private boolean isRotating = false;
    private RotationListener listener;

    /**
     * 构造函数，初始化立方体模型。
     *
     * @param listener 旋转事件的监听器
     */
    public CubeModel(RotationListener listener) {
        this.listener = listener;
        setPreferredSize(new Dimension(600, 600));
    }

    /**
     * 重写 paintComponent 方法，绘制旋转的立方体。
     *
     * @param g 图形上下文
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        g2d.translate(width / 2, height / 2);

        // 计算旋转后的顶点坐标
        double[][] transformed = new double[8][3];
        for (int i = 0; i < vertices.length; i++) {
            transformed[i] = rotate(vertices[i]);
        }

        // 绘制边
        for (int[] edge : edges) {
            int x1 = (int) (transformed[edge[0]][0] * 100);
            int y1 = (int) (transformed[edge[0]][1] * 100);
            int x2 = (int) (transformed[edge[1]][0] * 100);
            int y2 = (int) (transformed[edge[1]][1] * 100);
            g2d.drawLine(x1, y1, x2, y2);
        }

        // 更新旋转角度
        angleX += rotationSpeed;
        angleY += rotationSpeed;
        angleZ += rotationSpeed;

        // 延迟刷新
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 如果正在旋转，继续重绘
        if (isRotating) {
            repaint();
        }
    }

    /**
     * 对顶点进行旋转变换。
     *
     * @param v 顶点坐标
     * @return 旋转后的顶点坐标
     */
    private double[] rotate(double[] v) {
        double x = v[0], y = v[1], z = v[2];
        double cosX = Math.cos(angleX), sinX = Math.sin(angleX);
        double cosY = Math.cos(angleY), sinY = Math.sin(angleY);
        double cosZ = Math.cos(angleZ), sinZ = Math.sin(angleZ);

        // X、Y、Z 轴的旋转
        double newY = y * cosX - z * sinX;
        double newZ = y * sinX + z * cosX;
        y = newY;
        z = newZ;

        double newX = x * cosY + z * sinY;
        newZ = -x * sinY + z * cosY;
        x = newX;
        z = newZ;

        newX = x * cosZ - y * sinZ;
        newY = x * sinZ + y * cosZ;
        return new double[]{newX, newY, newZ};
    }

    /**
     * 开始旋转立方体。
     */
    public void startRotation() {
        if (!isRotating) {
            isRotating = true;
            listener.onRotationStarted();
            repaint();
        }
    }

    /**
     * 停止旋转立方体。
     */
    public void stopRotation() {
        if (isRotating) {
            isRotating = false;
            listener.onRotationStopped();
        }
    }
}
