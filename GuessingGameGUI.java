import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessingGameGUI extends JFrame {
    private int randomNumber;
    private JTextField guessField;
    private JButton guessButton;
    private JLabel resultLabel;

    public GuessingGameGUI() {
        setTitle("Number Guessing Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel promptLabel = new JLabel("Guess a number between 1 and 100:");
        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        resultLabel = new JLabel("");

        add(promptLabel);
        add(guessField);
        add(guessButton);
        add(resultLabel);

        // Generate random number between 1 and 100
        randomNumber = new Random().nextInt(100) + 1;

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(guessField.getText());
                    if (guess < randomNumber) {
                        resultLabel.setText("Too low! Try again.");
                    } else if (guess > randomNumber) {
                        resultLabel.setText("Too high! Try again.");
                    } else {
                        resultLabel.setText("Correct! You guessed it!");
                        guessButton.setEnabled(false);
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new GuessingGameGUI();
    }
}
