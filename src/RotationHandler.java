import javax.swing.*;

public class RotationHandler implements RotationListener {
    private JLabel statusLabel;

    public RotationHandler(JLabel statusLabel) {
        this.statusLabel = statusLabel;
    }

    @Override
    public void onRotationStarted() {
        statusLabel.setText("Status: Rotating");
    }

    @Override
    public void onRotationStopped() {
        statusLabel.setText("Status: Stopped");
    }
}
