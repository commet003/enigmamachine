package com.corie_rhodes;

import java.util.*;

public class Rotor{
    private RotorPosition rotorPosition;
    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];
    List<Integer> list = new ArrayList<>();


    public Rotor() {
        rotorPosition = RotorPosition.I;
        this.setRotorMap(rotorPosition);
    }

    // Internal wiring map for rotor
    // use a map to represent the wiring of the rotor
    // the key is the input character and the value is the output character
    // the rotor position will determine the shift of the map
    private void setRotorMap(RotorPosition rotorPosition) {
        int charOffset;
        switch (rotorPosition) {
            case I:
                charOffset = 9;
                generateEncoderDecoder(charOffset);
                break;
            case II:
                charOffset = 15;
                generateEncoderDecoder(charOffset);
                break;
            case III:
                charOffset = 5;
                generateEncoderDecoder(charOffset);
                break;
            case IV:
                charOffset = 17;
                generateEncoderDecoder(charOffset);
                break;
            case V:
                charOffset = 7;
                generateEncoderDecoder(charOffset);
                break;
        }
    }

    public String encrypt(String message) {
        return transform(message, encoder);
    }

    public String decrypt(String secret) {
        return transform(secret, decoder);
    }

    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int i = 0; i <msg.length; i++) {
            if (Character.isUpperCase(msg[i])) {
                int j = msg[i] - 'A';
                msg[i] = code[j];
            }
        }
        return new String(msg);
    }

    public void setRotorPosition(String newRotorPosition) {
        switch (newRotorPosition) {
            case "I":
                rotorPosition = RotorPosition.I;
                this.setRotorMap(RotorPosition.I);
                break;
            case "II":
                rotorPosition = RotorPosition.II;
                this.setRotorMap(RotorPosition.II);
                break;
            case "III":
                rotorPosition = RotorPosition.III;
                this.setRotorMap(RotorPosition.III);
                break;
            case "IV":
                rotorPosition = RotorPosition.IV;
                this.setRotorMap(RotorPosition.IV);
                break;
            case "V":
                rotorPosition = RotorPosition.V;
                this.setRotorMap(RotorPosition.V);
                break;
        }
    }

    public RotorPosition getRotorPosition() {
        return rotorPosition;
    }

    private void generateEncoderDecoder(int charOffset) {
        for (int i = 0; i < 26; i++) {
            encoder[i] = (char) ('A' + (i + charOffset) % 26);
            decoder[i] = (char) ('A' + (i - charOffset + 26) % 26);
        }
    }
}
