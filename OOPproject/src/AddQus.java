import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddQus extends JFrame {
    
    private static final long serialVersionUID = -814395576948830678L;
    private JPanel contentPane;
    public int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    public int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    public int windowsWidth = 800;
    public int windowsHeight = 500;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

  
    public AddQus() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Add Questions");
     
        setBounds((width - windowsWidth) / 2,
                (height - windowsHeight) / 2, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.black);

        JLabel lblNewLabel = new JLabel("question");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBackground(Color.WHITE);
        lblNewLabel.setBounds(109, 48, 80, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("op1");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(109, 92, 58, 15);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("op2");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBounds(109, 143, 58, 15);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("op3");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setBounds(109, 193, 58, 15);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("op4");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setBounds(109, 240, 58, 15);
        contentPane.add(lblNewLabel_4);

        textField = new JTextField();
        textField.setBounds(199, 45, 471, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(199, 89, 471, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(199, 140, 471, 21);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(199, 190, 471, 21);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(197, 237, 473, 21);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JButton btnNewButton = new JButton("confirm");

        btnNewButton.setBounds(349, 407, 97, 23);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_5 = new JLabel("answer");
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setBounds(109, 335, 80, 15);
        contentPane.add(lblNewLabel_5);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"op1", "op2", "op3", "op4"}));
        comboBox.setBounds(199, 331, 471, 23);
        contentPane.add(comboBox);

        JLabel lblNewLabel_6 = new JLabel("hint");
        lblNewLabel_6.setForeground(Color.WHITE);
        lblNewLabel_6.setBounds(109, 288, 58, 15);
        contentPane.add(lblNewLabel_6);

        textField_5 = new JTextField();
        textField_5.setBounds(199, 285, 471, 21);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String question = textField.getText().trim();
                String op1 = textField_1.getText().trim();
                String op2 = textField_2.getText().trim();
                String op3 = textField_3.getText().trim();
                String op4 = textField_4.getText().trim();

                String hint = textField_5.getText().trim();
                String answer = comboBox.getSelectedItem().toString();
                String correctAnswer = "";
                if ("op1".equals(answer)) {
                    correctAnswer = op1;
                } else if ("op2".equals(answer)) {
                    correctAnswer = op2;
                } else if ("op3".equals(answer)) {
                    correctAnswer = op3;
                } else if ("op4".equals(answer)) {
                    correctAnswer = op4;
                }

                Question qus = new Question(question, op1, op2, op3, op4, correctAnswer, hint);
                DataDb.list.add(qus);

                AddQus.this.dispose();
            }
        });
    }
}
