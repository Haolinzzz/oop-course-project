import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

class welcomePage extends JPanel {

    JButton play,
            addquestion,
            exit;

    static boolean go = false;

    ;

    welcomePage(JFrame window) {

        setSize(window.getSize().width, window.getSize().height);
        setLayout(null);
        setBackground(Color.BLACK);
        window.setContentPane(this);

        play = new JButton("Play");
        play.setBackground(new Color(255, 255, 255));
        play.setBounds(300, 140, 200, 50);
        add(play);

        addquestion = new JButton("Add Questions");
        addquestion.setBackground(new Color(255, 255, 255));
        addquestion.setBounds(300, 205, 200, 50);
        add(addquestion);

        exit = new JButton("Exit");
        exit.setBackground(new Color(255, 255, 255));
        exit.setBounds(300, 270, 200, 50);
        add(exit);
        
        JButton viewScores = new JButton("View Scores");
        viewScores.setBackground(new Color(255, 255, 255));
        viewScores.setBounds(300, 335, 200, 50);
        add(viewScores);
        viewScores.addActionListener((ActionEvent e) -> {
            JFrame scoreFrame = new JFrame("Previous Scores");
            JTextArea scoreArea = new JTextArea(20, 50);
            scoreArea.setEditable(false);
            try (BufferedReader reader = new BufferedReader(new FileReader("scores.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    scoreArea.append(line + "\n");
                }
            } catch (IOException ex) {
                scoreArea.setText("Failed to load scores.");
            }
            scoreFrame.add(new JScrollPane(scoreArea));
            scoreFrame.pack();
            scoreFrame.setLocationRelativeTo(null);
            scoreFrame.setVisible(true);
        });


        window.setVisible(true);

    }

    void choose(int time) {

        play.addActionListener((ActionEvent e) -> {
            go = true;
            setVisible(false);
        });

        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        addquestion.addActionListener((ActionEvent e) -> {
            AddQus addQ = new AddQus();
            addQ.setVisible(true);
        });

        while (!go) {
            try {
                Thread.sleep(0);
            } catch (Exception ex) {
            }
        }

        go = false;

    }

}
