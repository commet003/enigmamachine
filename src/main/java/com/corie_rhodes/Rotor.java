package com.corie_rhodes;

import java.util.HashMap;
import java.util.Map;

public class Rotor{
    private RotorPosition rotorPosition;
    private final Map<Character, Character> rotorMap;
    private final Map<Character, Character> decryptRotorMap;

    public Rotor() {
        rotorPosition = RotorPosition.I;
        rotorMap = new HashMap<>();
        decryptRotorMap = new HashMap<>();
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
                generateRotorMap(charOffset);
                generateDecryptMap();
                break;
            case II:
                charOffset = 15;
                generateRotorMap(charOffset);
                generateDecryptMap();
                break;
            case III:
                charOffset = 5;
                generateRotorMap(charOffset);
                generateDecryptMap();
                break;
            case IV:
                charOffset = 17;
                generateRotorMap(charOffset);
                generateDecryptMap();
                break;
            case V:
                charOffset = 7;
                generateRotorMap(charOffset);
                generateDecryptMap();
                break;
        }
    }

    public char encrypt(char c) {
        return this.rotorMap.get(c);
    }

    public char decrypt(char c) {
        return this.decryptRotorMap.get(c);
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

    private void generateRotorMap(int charOffset) {
        rotorMap.put('A', shiftChar('A', charOffset));
        rotorMap.put('B', shiftChar('B', charOffset));
        rotorMap.put('C', shiftChar('C', charOffset));
        rotorMap.put('D', shiftChar('D', charOffset));
        rotorMap.put('E', shiftChar('E', charOffset));
        rotorMap.put('F', shiftChar('F', charOffset));
        rotorMap.put('G', shiftChar('G', charOffset));
        rotorMap.put('H', shiftChar('H', charOffset));
        rotorMap.put('I', shiftChar('I', charOffset));
        rotorMap.put('J', shiftChar('J', charOffset));
        rotorMap.put('K', shiftChar('K', charOffset));
        rotorMap.put('L', shiftChar('L', charOffset));
        rotorMap.put('M', shiftChar('M', charOffset));
        rotorMap.put('N', shiftChar('N', charOffset));
        rotorMap.put('O', shiftChar('O', charOffset));
        rotorMap.put('P', shiftChar('P', charOffset));
        rotorMap.put('Q', shiftChar('Q', charOffset));
        rotorMap.put('R', shiftChar('R', charOffset));
        rotorMap.put('S', shiftChar('S', charOffset));
        rotorMap.put('T', shiftChar('T', charOffset));
        rotorMap.put('U', shiftChar('U', charOffset));
        rotorMap.put('V', shiftChar('V', charOffset));
        rotorMap.put('W', shiftChar('W', charOffset));
        rotorMap.put('X', shiftChar('X', charOffset));
        rotorMap.put('Y', shiftChar('Y', charOffset));
        rotorMap.put('Z', shiftChar('Z', charOffset));
    }

    private void generateDecryptMap() {
        for (Map.Entry<Character, Character> entry : rotorMap.entrySet()) {
            decryptRotorMap.put(entry.getValue(), entry.getKey());
        }
    }

    private char shiftChar(char c, int shift) {
        int alphabetLength = 26;
        return (char) ((c - 'A' + shift) % alphabetLength + 'A');
    }
}
