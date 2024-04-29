package quiz;

import java.util.ArrayList;
import java.util.List;

public class DataDb {

    public static List< Question> list = new ArrayList<Question>() {
        {
            this.add(new Question("Question 1 What is the value of Pi?", "3.14", "2.71", "3", "1", "3.14", "No Hint Available"));
        }
    };
}
