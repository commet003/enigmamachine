package com.corie_rhodes;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class GUI {

    private final JTextField input;
    private final JTextField mapLetterFrom;
    private final JTextField mapLetterTo;
    private final JLabel output;
    private final JLabel plugboardError;

    public GUI (EnigmaMachine enigmaMachine) {
        JFrame frame = new JFrame("Enigma Machine!");

        JPanel panel = new JPanel();
        int WIDTH = 800;
        int HEIGHT = 600;
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        JPanel rotorPanel = new JPanel();
        rotorPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 4));

        JPanel outputPanel = new JPanel();
        outputPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 4));
        output = createOutputLabel();


        String[] modes = {"Encrypt", "Decrypt"};
        JComboBox<String> encryptDecryptBox = createModeBox(modes, enigmaMachine);


        String[] rotorPositions = {"I", "II", "III", "IV", "V"};
        JComboBox<String> rotor1Box = createRotorBox(enigmaMachine.getRotor1(), rotorPositions);
        JComboBox<String> rotor2Box = createRotorBox(enigmaMachine.getRotor2(), rotorPositions);
        JComboBox<String> rotor3Box = createRotorBox(enigmaMachine.getRotor3(), rotorPositions);


        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 4));

        JLabel inputLabel = new JLabel("Enter Message:");

        input = new JTextField();
        input.setPreferredSize(new Dimension(200, 50));
        input.addActionListener(_ -> encryptDecryptSubmit(input.getText(), enigmaMachine));

        JButton submitEncryptDecrypt = new JButton("Submit");
        submitEncryptDecrypt.addActionListener(_ -> encryptDecryptSubmit(input.getText(), enigmaMachine));

        JPanel plugboardPanel = new JPanel();
        plugboardPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 4));

        JLabel mapLetterFromLabel = new JLabel("Map Letter From:");
        mapLetterFrom = new JTextField();
        mapLetterFrom.setPreferredSize(new Dimension(50, 50));

        JLabel mapLetterToLabel = new JLabel("Map Letter To:");
        mapLetterTo = new JTextField();
        mapLetterTo.setPreferredSize(new Dimension(50, 50));

        plugboardError = new JLabel("");

        JButton mapButton = getPlugboardButton(enigmaMachine);

        JButton clearButton = new JButton("Clear Plugboard");
        clearButton.addActionListener(_ -> enigmaMachine.getPlugboard().clear());

        rotorPanel.add(new JLabel("Encrypt/Decrypt:"));
        rotorPanel.add(encryptDecryptBox);
        rotorPanel.add(new JLabel("Rotor 1:"));
        rotorPanel.add(rotor1Box);
        rotorPanel.add(new JLabel("Rotor 2:"));
        rotorPanel.add(rotor2Box);
        rotorPanel.add(new JLabel("Rotor 3:"));
        rotorPanel.add(rotor3Box);

        plugboardPanel.add(mapLetterFromLabel);
        plugboardPanel.add(mapLetterFrom);
        plugboardPanel.add(mapLetterToLabel);
        plugboardPanel.add(mapLetterTo);
        plugboardPanel.add(clearButton);
        plugboardPanel.add(mapButton);

        keyboardPanel.add(inputLabel);
        keyboardPanel.add(input);
        keyboardPanel.add(submitEncryptDecrypt);
        outputPanel.add(output);

        panel.add(rotorPanel);
        panel.add(keyboardPanel);
        panel.add(plugboardPanel);
        panel.add(outputPanel);

        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private JComboBox<String> createModeBox(String[] modes, EnigmaMachine enigmaMachine) {
        JComboBox<String> encryptDecryptBox = new JComboBox<>(modes);
        encryptDecryptBox.addActionListener(_ -> enigmaMachine.setMode((String) Objects.requireNonNull(encryptDecryptBox.getSelectedItem())));
        return encryptDecryptBox;
    }

    private JComboBox<String> createRotorBox(Rotor rotor, String[] rotorPositions) {
        JComboBox<String> rotorBox = new JComboBox<>(rotorPositions);
        rotorBox.addActionListener(_ -> setRotorPosition(rotor, (String) Objects.requireNonNull(rotorBox.getSelectedItem())));
        return rotorBox;
    }

    private void printRotorPosition(EnigmaMachine enigmaMachine) {
        System.out.println("Rotor 1: " + enigmaMachine.getRotor1().getRotorPosition() + " Rotor 2: " + enigmaMachine.getRotor2().getRotorPosition() + " Rotor 3: " + enigmaMachine.getRotor3().getRotorPosition());
    }

    private void setRotorPosition(Rotor rotor, String position) {
        rotor.setRotorPosition(position);
    }

    private JButton getPlugboardButton(EnigmaMachine enigmaMachine) {
        JButton mapButton = new JButton("Map");
        mapButton.addActionListener(_ -> {
            if (mapLetterFrom.getText().isEmpty() || mapLetterTo.getText().isEmpty()) {
                plugboardError.setText("Error: Plugboard already contains one of the letters");
                return;
            }
            enigmaMachine.mapPlugboard(mapLetterFrom.getText().toUpperCase().charAt(0), mapLetterTo.getText().toUpperCase().charAt(0));
            plugboardError.setText("");
            mapLetterFrom.setText("");
            mapLetterTo.setText("");
        });
        return mapButton;
    }

    private void encryptDecryptSubmit(String text, EnigmaMachine enigmaMachine) {
        String outputString;

        if (enigmaMachine.getMode().equals(EncryptDecrypt.ENCRYPT.toString())) {
            //System.out.println("Input: " + text);
            outputString = enigmaMachine.encrypt(text.toUpperCase());
            output.setText("Encrypted Message: " + outputString);
            //System.out.println("Output: " + outputString);
        } else {
            //System.out.println("Input: " + text);
            outputString = enigmaMachine.decrypt(text.toUpperCase());
            output.setText("Decrypted Message: " + outputString);
            //System.out.println("Output: " + outputString);
        }
        printRotorPosition(enigmaMachine);
        removeOutputBorderColor();
    }

    private JLabel createOutputLabel() {
        JLabel output = new JLabel("Output: ");
        output.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                StringSelection stringSelection = new StringSelection(formatClipboardText(output.getText()));
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                changeOutputBorderColor();
            }

        });

        return output;
    }

    private void changeOutputBorderColor() {
        output.setBorder(BorderFactory.createLineBorder(Color.GREEN));
    }

    private void removeOutputBorderColor() {
        output.setBorder(null);
    }

    private static String formatClipboardText(String text) {
        String[] parts = text.split(":");
        if (parts.length == 1) {
            return text; // No colon found, return original string
        }
        return parts[1].strip();
    }
}
