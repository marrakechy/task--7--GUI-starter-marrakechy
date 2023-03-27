import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class FileReaderPanel extends JPanel {
    private final JTextField fileNameField;
    private final JLabel fileNameLabel;
    private final JButton openButton;
    private final JButton readLineButton;
    private BufferedReader fileReader;
    private String currentLine;

    public FileReaderPanel() {
        super();
        setPreferredSize(new Dimension(400, 100));
        setBackground(Color.WHITE);

        fileNameField = new JTextField(20);
        fileNameLabel = new JLabel("File Name: ");
        openButton = new JButton("Open File");
        readLineButton = new JButton("Read Line");
        readLineButton.setEnabled(false);

        ButtonListener bl = new ButtonListener();
        openButton.addActionListener(bl);
        readLineButton.addActionListener(bl);

        add(fileNameLabel);
        add(fileNameField);
        add(openButton);
        add(readLineButton);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == openButton) {
                try {
                    fileReader = new BufferedReader(new FileReader(fileNameField.getText()));
                    readLineButton.setEnabled(true);
                    openButton.setEnabled(false);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(FileReaderPanel.this, "File not found");
                }
            } else if (e.getSource() == readLineButton) {
                try {
                    currentLine = fileReader.readLine();
                    if (currentLine != null) {
                        JOptionPane.showMessageDialog(FileReaderPanel.this, currentLine);
                    } else {
                        readLineButton.setEnabled(false);
                        JOptionPane.showMessageDialog(FileReaderPanel.this, "End of file reached");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(FileReaderPanel.this, "Error reading file");
                }
            }
        }
    }
}

