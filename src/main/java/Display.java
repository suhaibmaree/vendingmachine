import javax.swing.*;



public class Display {

    private static Display display; // good idea but i suggest a static methods instead
    private JFrame frame = new JFrame(); // bad idea


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
       if (value == "") // use equals
           return 0;
       int n = Integer.parseInt(value);
        return n;
    }


}
