import javax.swing.*;

public class Display {

    private static Display display;
    private JFrame frame = new JFrame();

    public static Display getInstance() {
        if (display == null)
            display = new Display();
        return display;
    }

    public void information(String message) {

        JOptionPane.showMessageDialog(frame, message);
    }

    public int Question(String message, String title) {

       String value = JOptionPane.showInputDialog(message, title);

       if (value == null)
       return 0;
       if (value == "")
           return 0;
       int n = Integer.parseInt(value);
        return n;
    }


}
