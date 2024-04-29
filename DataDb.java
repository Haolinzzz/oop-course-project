package quiz;

import java.util.ArrayList;
import java.util.List;

public class DataDb {

    public static List< Question> list = new ArrayList<Question>() {
        {
            this.add(new Question("Question 1 What is the value of Pi?", "3.14", "2.71", "3", "1", "3.14", "No Hint Available"));
            //this.add(new Question("Question 2 What does 'ecstasy' mean ", "Sad", "Great", "Crazy", "Worried", "Crazy", "hint 4"));
            //this.add(new Question("Question 3 What is your name", "Teacher", "Student", "Cat", "Dog", "Person", "Hint"));
            //this.add(new Question("Question 4 How tall is a man", "1m", "2m", "3m", "4m", "1mm", "Consider yourself"));

        }
    };
}
