import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class CurrencyConverter {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel amountLabel = new JLabel("Enter Amount (in INR):");
        amountLabel.setBounds(20, 20, 200, 25);
        panel.add(amountLabel);

        JTextField amountText = new JTextField(20);
        amountText.setBounds(170, 20, 150, 25);
        panel.add(amountText);

        JLabel resultLabel = new JLabel("Converted Amount:");
        resultLabel.setBounds(20, 50, 150, 25);
        panel.add(resultLabel);

        JTextField resultText = new JTextField(20);
        resultText.setBounds(170, 50, 150, 25);
        resultText.setEditable(false);
        panel.add(resultText);

        String[] currencies = {"INR","BTC","USD", "EUR", "EGP", "YEN", "AUD", "BDT", "PUB", "SAR", "SGD", "LKR"};
        JComboBox currencyDropdown = new JComboBox(currencies);
        currencyDropdown.setBounds(20, 100, 80, 25);
        panel.add(currencyDropdown);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(130, 100, 80, 25);
        panel.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountText.getText());
                String selectedCurrency = (String) currencyDropdown.getSelectedItem();
                double convertedAmount = 0;

                switch (selectedCurrency) {
                    case "INR":
                        convertedAmount = amount;
                    break;
                    case "BTC":
                        convertedAmount = amount / 2313238; // Conversion rate from INR to Bitcoin
                    break;
                    case "USD":
                        convertedAmount = amount * 0.012; // Conversion rate from INR to US Dollar
                    break;
                    case "EUR":
                        convertedAmount = amount * 0.01; // Conversion rate from INR to European
                    break;
                    case "EGP":
                        convertedAmount = amount * 0.3; // Conversion rate from INR to Egyptian pound
                    break;
                    case "YEN":
                        convertedAmount = amount * 1.80; // Conversion rate from INR to Japnese
                    break;
                    case "AUD":
                        convertedAmount = amount * 0.019; // Conversion rate from INR to Australian
                    break;
                    case "BDT":
                        convertedAmount = amount * 1.32; // Conversion rate from INR to Bangladesh
                    break;
                    case "PUB":
                        convertedAmount = amount * 1.21; // Conversion rate from INR to Russian
                    break;
                    case "SAR":
                        convertedAmount = amount * 1.21; // Conversion rate from INR to Saudi
                    break;
                    case "SGD":
                        convertedAmount = amount * 0.016; // Conversion rate from INR to Singapore
                    break;
                    case "LKR":
                        convertedAmount = amount * 3.89; // Conversion rate from INR to Sri Lanka
                    break;
                }

                resultText.setText(String.valueOf(convertedAmount));
            }
        });
    }
}
