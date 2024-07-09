package com.corie_rhodes;

public class EnigmaMachine {
    private final Rotor rotor1;
    private final Rotor rotor2;
    private final Rotor rotor3;
    private final Plugboard plugboard;
    private final Reflector reflector;

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
        String tempMessege = "";
        for (int i = 0; i < input.length(); i++) {
            if (inputErrorCheck(input, i)) continue;
            tempMessege = getPlugboard().encrypt(input);
            tempMessege = getRotor1().encrypt(tempMessege);
            tempMessege = getRotor2().encrypt(tempMessege);
            tempMessege = reflector.reflect(tempMessege);
            tempMessege = getRotor3().encrypt(tempMessege);
        }
        return tempMessege;
    }

    public String decrypt(String input) {
        String tempString = "";
        for (int i = 0; i < input.length(); i++) {
            if (inputErrorCheck(input, i)) continue;
            tempString = getRotor3().decrypt(input);
            tempString = reflector.reflect(tempString);
            tempString = getRotor2().decrypt(tempString);
            tempString = getRotor1().decrypt(tempString);
            tempString = getPlugboard().decrypt(tempString);
        }
        return tempString;
    }

    private boolean inputErrorCheck(String input, int i) {
        if (input.charAt(i) == ' ') {
            return true;
        } else if (input.charAt(i) == '\n') {
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
        getPlugboard().addPlug(c1, c2);
        plugboardActive = true;
    }

    public Plugboard getPlugboard() {
        return plugboard;
    }

    public boolean isPlugboardActive() {
        return plugboardActive;
    }
}
