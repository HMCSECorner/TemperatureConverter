package temperatureconverter;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;


public class TemperatureConverter {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(350, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // JLabel for input
        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setBounds(20, 20, 150, 25);
        frame.add(inputLabel);

        // Text field for input
        JTextField tempField = new JTextField();
        tempField.setBounds(150, 20, 150, 25);
        frame.add(tempField);

        // Dropdown for conversion type
        String[] options = { "Celsius to Fahrenheit", "Fahrenheit to Celsius","Celsius to Kelvin","Kelvin to Celsius","Fahrenheit to Kelvin","Kelvin to Fahrenheit" };
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(20, 60, 280, 25);
        comboBox.setEditable(true);
        frame.add(comboBox);

        // Button to convert
        JButton convertBtn = new JButton("Convert");
        convertBtn.setBounds(100, 100, 120, 30);
        frame.add(convertBtn);
        
         // Label for result
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(20, 140, 280, 25);
        frame.add(resultLabel);

        // Button action
        convertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = tempField.getText().trim();
                    if (input.isEmpty()) {
                        resultLabel.setText("Input field is empty!");
                        return;
                    }

                    double inputTemp = Double.parseDouble(input);
                    String selectedOption = (String) comboBox.getSelectedItem();
                    double result;

                    DecimalFormat df = new DecimalFormat("#.##");
                    
                    if (selectedOption.equals("Celsius to Fahrenheit")) {
                        result = (inputTemp * 9 / 5) + 32;
                        resultLabel.setText("Result: " + df.format(result) + " °F");
                    } else if(selectedOption.equals("Fahrenheit to Celsius")) {
                        result = (inputTemp - 32) * 5 / 9;
                        resultLabel.setText("Result: " + df.format(result) + " °C");
                    }
                    else if(selectedOption.equals("Celsius to Kelvin")) {
                        result = (inputTemp + 273.15);
                        resultLabel.setText("Result: " + df.format(result) + " K");
                    }
                    else if(selectedOption.equals("Kelvin to Celsius")) {
                        result = (inputTemp - 273.15);
                        resultLabel.setText("Result: " + df.format(result) + " °C");
                    }
                    else if(selectedOption.equals("Fahrenheit to Kelvin")) {
                        result = 5*(inputTemp - 32) / 9 + 273.15 ;
                        resultLabel.setText("Result: " + df.format(result) + " K");
                    }
                    else {
                        result = 9*(inputTemp - 273.15) / 5 +32 ;
                        resultLabel.setText("Result: " + df.format(result) + " °F");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });
        
        // Button to Clear
        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(190, 140, 65, 30);
        frame.add(clearBtn);
        
        clearBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent c)
            {
                tempField.setText("");
            }
        
        });
        
        // Button to Exit
        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(260, 140, 65, 30);
        frame.add(exitBtn);
        
        exitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        
        });

        // Center and show the frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
