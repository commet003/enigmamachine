package com.corie_rhodes;

public class EnigmaMachine {
    private Rotor rotor1;
    private Rotor rotor2;
    private Rotor rotor3;
    private Plugboard plugboard;
    private Reflector reflector;

    private EncryptDecrypt mode;
    private boolean plugboardActive;

    public EnigmaMachine() {
        rotor1 = new Rotor();
        rotor2 = new Rotor();
        rotor3 = new Rotor();
        plugboard = new Plugboard();
        reflector = new Reflector();
        plugboardActive = false;
        mode = EncryptDecrypt.ENCRYPT;

        new GUI(this);
    }

    public void setMode(String mode) {
        if (mode.equalsIgnoreCase("ENCRYPT")) {
            this.mode = EncryptDecrypt.ENCRYPT;
        } else {
            this.mode = EncryptDecrypt.DECRYPT;
        }
    }

    public String getMode() {
        return mode.toString();
    }

    public String encrypt(String input) {
        StringBuilder output = new StringBuilder();
        char tempChar;
        for (int i = 0; i < input.length(); i++) {
            if (inputErrorCheck(input, output, i)) continue;
            tempChar = this.getPlugboard().encrypt(input.charAt(i));
            tempChar = this.getRotor1().encrypt(tempChar);
            tempChar = this.getRotor2().encrypt(tempChar);
            tempChar = this.getRotor3().encrypt(tempChar);
            output.append(tempChar);
        }

        return output.toString();
    }

    public String decrypt(String input) {
        StringBuilder output = new StringBuilder();
        char tempChar;
        for (int i = 0; i < input.length(); i++) {
            if (inputErrorCheck(input, output, i)) continue;
            tempChar = this.getRotor3().decrypt(input.charAt(i));
            tempChar = this.getRotor2().decrypt(tempChar);
            tempChar = this.getRotor1().decrypt(tempChar);
            output.append(this.getPlugboard().decrypt(tempChar));
        }

        return output.toString();
    }

    private boolean inputErrorCheck(String input, StringBuilder output, int i) {
        if (input.charAt(i) == ' ') {
            output.append(' ');
            return true;
        } else if (input.charAt(i) == '\n') {
            output.append('\n');
            return true;
        } else return !Character.isLetter(input.charAt(i));
    }

    public Rotor getRotor1() {
        return rotor1;
    }

    public Rotor getRotor2() {
        return rotor2;
    }

    public Rotor getRotor3() {
        return rotor3;
    }


    public void mapPlugboard(char c1, char c2) {
        this.getPlugboard().addPlug(c1, c2);
        this.plugboardActive = true;
    }

    public Plugboard getPlugboard() {
        return plugboard;
    }

    public boolean isPlugboardActive() {
        return plugboardActive;
    }

    public void clearPlugboard() {
        plugboard.clear();
        this.plugboardActive = false;
    }
}
