package std;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class about {
    private JFrame aboutFrame = new JFrame("ABOUT US");

    about() {
        aboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutFrame.setSize(600, 400);  // Increased the width for horizontal scrolling

        // Create a back button and add it to the top left corner
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aboutFrame.dispose();
                try {
                    MainClass.main(null);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(backButton);

        // Create a table with columns: Name, ID numbers, Professions
        String[] columnNames = {"<html><h2>Name</h2></html>", "<html><h2>ID numbers</h2></html>", "<html><h2>Professions</h2></html"};
        Object[][] data = {
            {"<html><h3>eyob</h3></html>", "UGR/25361/14", "CSE student"},
            {"<html><h3>mistre</h3></html>", "Ugr/25559/14", "CSE student"},
            {"<html><h3>feleke</h3></html>", "UGR/25571/14", "CSE student"},
            {"<html><h3>meron</h3></html>", "UGR/25700/14", "CSE student"},
            {"<html><h3>kalkidan</h3></html>", "UGR/25325/14>", "CSE student"},
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Create a JTextArea for "About Projects" text
        String aboutProjectsText = "our java project";
        aboutFrame.add(new JLabel(aboutProjectsText));
		JTextArea aboutProjectsTextArea = new JTextArea(5, 10);
        aboutProjectsTextArea.setText(aboutProjectsText);
        aboutProjectsTextArea.setLineWrap(true);
        aboutProjectsTextArea.setWrapStyleWord(true);

        JScrollPane textScrollPane = new JScrollPane(aboutProjectsTextArea);
        textScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Create a JPanel for the "About Projects" text
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(textScrollPane);

        // Create a container panel for both the table and the "About Projects" text
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(tableScrollPane, BorderLayout.NORTH);
        containerPanel.add(textPanel, BorderLayout.SOUTH);

        aboutFrame.add(buttonPanel, BorderLayout.NORTH);
        aboutFrame.add(containerPanel, BorderLayout.CENTER);
        aboutFrame.setVisible(true);
    }

    protected void aboutInfo(boolean states) throws IOException {
        aboutFrame.setLocationRelativeTo(null);
        aboutFrame.setVisible(states);
    }
}
