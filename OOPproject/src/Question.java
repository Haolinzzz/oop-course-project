import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

/*
 * @author jym03
 */
class Question {

    String question,
            op1,
            op2,
            op3,
            op4,
            correct_answer,
            hint;

    Question(String question, String op1, String op2, String op3, String op4, String correctAnswer, String hint) {
        this.question = question;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.correct_answer = correctAnswer;
        this.hint = hint;
    }

}
