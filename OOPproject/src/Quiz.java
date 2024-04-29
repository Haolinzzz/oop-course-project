import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;


public class Quiz {
	
	private static void saveScore(int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt", true))) {
            writer.write(score + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to score file: " + e.getMessage());
        }
    }


    public static void main(String[] args) throws InterruptedException, Exception {

        JFrame window = new JFrame("Quiz Game");
        window.setSize(800, 550);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        while (true) {

            int a = 0,
                    score = 0,
                    m = 0,
                    s = 0;
            int time = 60;

            welcomePage welcome = new welcomePage(window);
            welcome.choose(time);

            while (a != DataDb.list.size() && s < time) {
                questions quiz = new questions(DataDb.list.get(a), window);
                quiz.getAnswer(time);
                m = quiz.getTime().M;
                s = quiz.getTime().S;
                score = quiz.getScore();
                if (a == DataDb.list.size() - 1 || (s == time)) {
                    quiz.Reset();
                }
                a++;
            }

            int W = DataDb.list.size();
            saveScore(score);
            scorePanel Panel = new scorePanel(window, score, W);
            Panel.choose();

        }

    }

}
