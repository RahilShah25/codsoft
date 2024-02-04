import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessTheNumberGUI extends JFrame {
    private int randomInt;
    private int attempts = 0;

    public GuessTheNumberGUI() {
        super("Guess the Number Game");
        setResizable(false);
        setSize(getAppropriateSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#00ffff"));
        add(panel);
        placeComponents(panel);

        generateRandomNumber();

        centerFrameOnScreen();

        setVisible(true);
    }

    private Dimension getAppropriateSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.5);
        int height = (int) (screenSize.height * 0.5);
        return new Dimension(width, height);
    }

    private void centerFrameOnScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.width - getWidth()) / 5.0);
        int y = (int) ((screenSize.height - getHeight()) / 5.0);
        setLocation(x, y);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel instructionLabel = new JLabel("I have selected a number. Try and guess it within 5 tries");
        instructionLabel.setForeground(Color.decode("#3399ff"));
        instructionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        instructionLabel.setBounds(10, 10, getWidth() - 20, 20);
        panel.add(instructionLabel);

        JLabel attemptsLabel = new JLabel("Attempts left: 5");
        attemptsLabel.setForeground(Color.decode("#7f00ff"));
        attemptsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        attemptsLabel.setBounds(10, 40, getWidth() - 20, 20);
        panel.add(attemptsLabel);

        JTextField userInput = new JTextField(10);
        userInput.setBounds(10, 70, getWidth() / 3, 25);
        userInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        userInput.setForeground(Color.decode("#9933ff"));
        panel.add(userInput);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(getWidth() / 3 + 20, 70, getWidth() / 6, 25);
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        submitButton.setBackground(Color.decode("#0096c7"));
        submitButton.setForeground(Color.decode("#90e0ef"));
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processGuess(userInput, attemptsLabel);
            }
        });
    }

    private void generateRandomNumber() {
        Random random = new Random();
        randomInt = random.nextInt(101);
    }

    private void processGuess(JTextField userInput, JLabel attemptsLabel) {
        if (attempts < 5) {
            int guess = Integer.parseInt(userInput.getText());

            if (guess == randomInt) {
                JOptionPane.showMessageDialog(this, "Congratulations on guessing the correct number!");
                resetGame();
            } else if (guess > randomInt) {
                JOptionPane.showMessageDialog(this, "Too High");
            } else {
                JOptionPane.showMessageDialog(this, "Too Low");
            }

            attempts++;
            attemptsLabel.setText("Attempts left: " + (5 - attempts));
        } else {
            JOptionPane.showMessageDialog(this, "Sorry, you've run out of attempts. The number was: " + randomInt);
            resetGame();
        }
    }

    private void resetGame() {
        attempts = 0;
        generateRandomNumber();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessTheNumberGUI();
            }
        });
    }
}