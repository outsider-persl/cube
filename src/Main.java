import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Slow Rotating Cube");

        // 设置布局
        JPanel controlPanel;
        JLabel statusLabel = new JLabel("Status: Idle");
        RotationHandler rotationHandler = new RotationHandler(statusLabel);
        CubeModel cubePanel = new CubeModel(rotationHandler);
        controlPanel = new ControlPanel(cubePanel);

        frame.setLayout(new BorderLayout());
        frame.add(cubePanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setVisible(true);
    }
}
