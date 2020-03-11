import java.awt.*;

public class MainUI {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UIReac();
            }
        });
    }
}
