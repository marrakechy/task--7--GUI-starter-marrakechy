import java.awt.*;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("File Reader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FileReaderPanel panel = new FileReaderPanel();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}