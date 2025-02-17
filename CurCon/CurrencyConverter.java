import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class CurrencyConverter {
 private JFrame frame;
 private JTextField amountField;
 private JComboBox<String> currencyComboBox;
 private JTextArea resultArea;
 private JButton calculateButton;
 private HashMap<String, Double> exchangeRates;
 public CurrencyConverter() {
 // Initialize exchange rates (you can fetch real-time rates from an API)
 // Add more exchange rates for other currencies
 exchangeRates = new HashMap<>();
 exchangeRates.put("USD", 0.012); // 1 INR to USD
 exchangeRates.put("CANADIAN D", 0.017);
 exchangeRates.put("CHINESE YUAN", 0.087);
 exchangeRates.put("EURO", 0.011);
 exchangeRates.put("YEN", 1.810);
 
 // Create frame and components
 frame = new JFrame("Currency Converter");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setLayout(new BorderLayout());
 // Currency Converter Panel
 JPanel currencyConverterPanel = new JPanel();
 currencyConverterPanel.setLayout(new FlowLayout());
 JLabel amountLabel = new JLabel("Amount:");
 amountField = new JTextField(10);
 currencyConverterPanel.add(amountLabel);
 currencyConverterPanel.add(amountField);

 currencyComboBox = new
JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
 currencyConverterPanel.add(currencyComboBox);
 calculateButton = new JButton("Calculate");
 calculateButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 convertCurrency();
 }
 });
 currencyConverterPanel.add(calculateButton);
 resultArea = new JTextArea(10, 30);
 currencyConverterPanel.add(new JScrollPane(resultArea));
 frame.add(currencyConverterPanel, BorderLayout.CENTER);
 frame.pack();
 frame.setVisible(true);
 }
 private void convertCurrency() {
 try {
 double amount = Double.parseDouble(amountField.getText());
 String selectedCurrency = (String)
currencyComboBox.getSelectedItem();
 double exchangeRate = exchangeRates.get(selectedCurrency);
 double result = amount * exchangeRate;
 resultArea.setText(amount + " INR IS EQUAL TO " + result + " " +
selectedCurrency);
 } catch (NumberFormatException ex) {
 resultArea.setText("Invalid input. Please enter a valid number.");
 }
 }
 public static void main(String[] args) {
 SwingUtilities.invokeLater(new Runnable() {
 public void run() {
 new CurrencyConverter();
 }
 });
 }

}