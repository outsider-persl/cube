import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 控制面板
 * 显示位置：south
 */
public class ControlPanel extends JPanel {
    private JButton startButton, stopButton;
    private JSlider speedSlider;
    private JLabel statusLabel;

    /**
     * button有三个:
     * start
     * stop
     * speed slider
     *
     * @param cubePanel
     */
    public ControlPanel(CubeModel cubePanel) {
        startButton = new JButton("Start Rotation");
        stopButton = new JButton("Stop Rotation");
        statusLabel = new JLabel("Status: Idle");
        speedSlider = new JSlider(1, 100, 30);

        setLayout(new FlowLayout());
        add(startButton);
        add(stopButton);
        add(statusLabel);
        add(new JLabel("Rotation Speed"));
        add(speedSlider);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cubePanel.startRotation();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cubePanel.stopRotation();
            }
        });

        speedSlider.addChangeListener(e -> {
            cubePanel.rotationSpeed = speedSlider.getValue() / 1000.0;
        });
    }
}
