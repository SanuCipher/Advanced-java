/*4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass
is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by
implementing the event handling mechanism with addActionListener( ).*/


package swings;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClockButtonExample {

    JLabel l1;

    ClockButtonExample() {
        JFrame f = new JFrame("Clock Button Example");

        // Label
        l1 = new JLabel();
        l1.setBounds(50, 50, 700, 100);
        l1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));

        // Load images (make sure they are inside the same package: swings)
        ImageIcon clockIcon = null;
        ImageIcon hourGlassIcon = null;

        try {
            clockIcon = new ImageIcon(getClass().getResource("/images/digital clock.jpg"));
            hourGlassIcon = new ImageIcon(getClass().getResource("/images/Hour glass.jpg"));
        } catch (Exception e) {
            System.out.println("Image not found! Check file path.");
        }

        // Buttons with images
        JButton b1 = new JButton("Digital Clock", clockIcon);
        JButton b2 = new JButton("Hour Glass", hourGlassIcon);

        b1.setBounds(50, 200, 220, 100);
        b2.setBounds(300, 200, 220, 100);

        // Action for Digital Clock button
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Digital Clock is pressed");
            }
        });

        // Action for Hour Glass button
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Hour Glass is pressed");
            }
        });

        // Add components
        f.add(b1);
        f.add(b2);
        f.add(l1);

        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ClockButtonExample();
    }
}
