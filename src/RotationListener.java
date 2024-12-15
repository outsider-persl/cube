/**
 * 旋转监听器接口
 * 用于通知旋转开始和停止的事件。
 */
public interface RotationListener {

    /**
     * 开始旋转事件
     */
    void onRotationStarted();

    /**
     * 停止旋转事件
     */
    void onRotationStopped();
}
