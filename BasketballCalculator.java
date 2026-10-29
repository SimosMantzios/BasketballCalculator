import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasketballCalculator extends JFrame {
    
    private JTextField nField, kField, resultField;

    public BasketballCalculator() {
        setTitle("Basketball Combinations");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Σύνολο Παικτών (n):"));
        nField = new JTextField();
        add(nField);

        add(new JLabel("Παίκτες ανά ομάδα (k):"));
        kField = new JTextField();
        add(kField);

        add(new JLabel("Συνδυασμοί ομάδων:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        JButton calcButton = new JButton("Υπολογισμός");
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                υπολογισμός();
            }
        });
        add(calcButton);

        JButton clearButton = new JButton("Εκκαθάριση");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nField.setText("");
                kField.setText("");
                resultField.setText("");
            }
        });
        add(clearButton);

        JButton exitButton = new JButton("Έξοδος");
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);
    }

    private void υπολογισμός() {
        try {
            int n = Integer.parseInt(nField.getText());
            int k = Integer.parseInt(kField.getText());

            if (n < 0 || k < 0 || k > n) {
                resultField.setText("Λάθος είσοδοι!");
                return;
            }

            long αριθμητής = 1;
            for (int i = 0; i < k; i++) {
                αριθμητής = αριθμητής * (n - i);
            }
            long αποτέλεσμα = αριθμητής / παραγοντικό(k);
            resultField.setText(String.valueOf(αποτέλεσμα));

        } catch (NumberFormatException e) {
            resultField.setText("Μη έγκυροι αριθμοί!");
        }
    }

    private long παραγοντικό(int αριθμός) {
        if (αριθμός == 0)
            return 1;
        else
            return αριθμός * παραγοντικό(αριθμός - 1);
    }

    public static void main(String[] args) {
        new BasketballCalculator().setVisible(true);
    }
}