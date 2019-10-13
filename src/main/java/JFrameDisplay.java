import javax.swing.*;

public class JFrameDisplay implements DisplayInterface{

    private static JFrameDisplay display ;
    private JFrame frame = new JFrame();

    public static JFrameDisplay getInstance() {
        if (display == null)
            display = new JFrameDisplay();
        return display;
    }

    public void information(String message) {

        JOptionPane.showMessageDialog(frame, message);
    }

    public int Question(String message, String title) {

       String value = JOptionPane.showInputDialog(message, title);

       if (value == null)
       return 0;
       if (value.equals(""))
           return 0;
       int n = Integer.parseInt(value);
        return n;
    }


}
