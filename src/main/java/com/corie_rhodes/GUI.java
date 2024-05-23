package com.corie_rhodes;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GUI {

    private final JFrame frame;
    private final JPanel panel;

    private final JPanel rotorPanel;
    private final JPanel keyboardPanel;
    private final JPanel outputPanel;
    private final JPanel plugboardPanel;

    private final JComboBox<String> encryptDecryptBox;
    private final JComboBox<String> rotor1Box;
    private final JComboBox<String> rotor2Box;
    private final JComboBox<String> rotor3Box;

    private final JLabel inputLabel;
    private final JTextField input;
    private final JLabel mapLetterFromLabel;
    private final JTextField mapLetterFrom;
    private final JLabel mapLetterToLabel;
    private final JTextField mapLetterTo;
    private final JLabel output;
    private final JLabel plugboardError;

    private final int WIDTH = 800;
    private final int HEIGHT = 600;




    public GUI (EnigmaMachine enigmaMachine) {
        frame = new JFrame("Enigma Machine!");

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        rotorPanel = new JPanel();
        rotorPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 4));

        outputPanel = new JPanel();
        outputPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 4));
        output = new JLabel("Encrypted Message: ");

        encryptDecryptBox = new JComboBox<>(new String[]{"Encrypt", "Decrypt"});
        encryptDecryptBox.addActionListener(_ -> {
            enigmaMachine.setMode((String) Objects.requireNonNull(encryptDecryptBox.getSelectedItem()));
            System.out.println("Mode: " + enigmaMachine.getMode());
        });

        rotor1Box = new JComboBox<>(new String[]{"I", "II", "III", "IV", "V"});
        rotor1Box.addActionListener(_ -> {
            enigmaMachine.getRotor1().setRotorPosition((String) Objects.requireNonNull(rotor1Box.getSelectedItem()));
            System.out.println("rotor1: " + enigmaMachine.getRotor1().getRotorPosition() + " rotor2: " + enigmaMachine.getRotor2().getRotorPosition() + " rotor3: " + enigmaMachine.getRotor3().getRotorPosition());
        });

        rotor2Box = new JComboBox<>(new String[]{"I", "II", "III", "IV", "V"});
        rotor2Box.addActionListener(_ -> {
            enigmaMachine.getRotor2().setRotorPosition((String) Objects.requireNonNull(rotor2Box.getSelectedItem()));
            System.out.println("rotor1: " + enigmaMachine.getRotor1().getRotorPosition() + " rotor2: " + enigmaMachine.getRotor2().getRotorPosition() + " rotor3: " + enigmaMachine.getRotor3().getRotorPosition());
        });

        rotor3Box = new JComboBox<>(new String[]{"I", "II", "III", "IV", "V"});
        rotor3Box.addActionListener(_ -> {
            enigmaMachine.getRotor3().setRotorPosition((String) Objects.requireNonNull(rotor3Box.getSelectedItem()));
            System.out.println("rotor1: " + enigmaMachine.getRotor1().getRotorPosition() + " rotor2: " + enigmaMachine.getRotor2().getRotorPosition() + " rotor3: " + enigmaMachine.getRotor3().getRotorPosition());
        });

        keyboardPanel = new JPanel();
        keyboardPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 4));

        inputLabel = new JLabel("Enter Message:");

        input = new JTextField();
        input.setPreferredSize(new Dimension(200, 50));
        input.addActionListener(_ -> {
                String text = input.getText();
                String outputString = "";

                if (enigmaMachine.getMode().equals(EncryptDecrypt.ENCRYPT.toString())) {
                    System.out.println("Input: " + text);
                    outputString = enigmaMachine.encrypt(text.toUpperCase());
                    output.setText("Encrypted Message: " + outputString);
                    System.out.println("Output: " + outputString);
                } else {
                    System.out.println("Input: " + text);
                    outputString = enigmaMachine.decrypt(text.toUpperCase());
                    output.setText("Decrypted Message: " + outputString);
                    System.out.println("Output: " + outputString);
                }
            }
        );

        plugboardPanel = new JPanel();
        plugboardPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 4));

        mapLetterFromLabel = new JLabel("Map Letter From:");
        mapLetterFrom = new JTextField();
        mapLetterFrom.setPreferredSize(new Dimension(50, 50));

        mapLetterToLabel = new JLabel("Map Letter To:");
        mapLetterTo = new JTextField();
        mapLetterTo.setPreferredSize(new Dimension(50, 50));

        plugboardError = new JLabel("");

        JButton mapButton = new JButton("Map");
        mapButton.addActionListener(_ -> {
            if (mapLetterFrom.getText().isEmpty() || mapLetterTo.getText().isEmpty()) {
                plugboardError.setText("Error: Plugboard already contains one of the letters");
                return;
            }
            enigmaMachine.mapPlugboard(mapLetterFrom.getText().toUpperCase().charAt(0), mapLetterTo.getText().toUpperCase().charAt(0));
            System.out.println("Plugboard Active: " + enigmaMachine.isPlugboardActive());
            plugboardError.setText("");
            mapLetterFrom.setText("");
            mapLetterTo.setText("");
        });

        JButton clearButton = new JButton("Clear Plugboard");
        clearButton.addActionListener(_ -> {
            enigmaMachine.getPlugboard().clear();
        });

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
}
