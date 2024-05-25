package com.corie_rhodes;

import java.util.HashMap;
import java.util.Map;

public class Rotor{
    private RotorPosition rotorPosition;
    private final Map<Character, Character> rotorMap;

    public Rotor() {
        rotorPosition = RotorPosition.I;
        rotorMap = new HashMap<>();
        this.setRotorMap(rotorPosition);
    }

    // Internal wiring map for rotor
    // use a map to represent the wiring of the rotor
    // the key is the input character and the value is the output character
    // the rotor position will determine the shift of the map
    private void setRotorMap(RotorPosition rotorPosition) {
        switch (rotorPosition) {
            case I:
                rotorMap.put('A', 'E');
                rotorMap.put('B', 'K');
                rotorMap.put('C', 'M');
                rotorMap.put('D', 'F');
                rotorMap.put('E', 'L');
                rotorMap.put('F', 'G');
                rotorMap.put('G', 'D');
                rotorMap.put('H', 'Q');
                rotorMap.put('I', 'V');
                rotorMap.put('J', 'Z');
                rotorMap.put('K', 'N');
                rotorMap.put('L', 'T');
                rotorMap.put('M', 'O');
                rotorMap.put('N', 'W');
                rotorMap.put('O', 'Y');
                rotorMap.put('P', 'H');
                rotorMap.put('Q', 'X');
                rotorMap.put('R', 'U');
                rotorMap.put('S', 'S');
                rotorMap.put('T', 'P');
                rotorMap.put('U', 'A');
                rotorMap.put('V', 'I');
                rotorMap.put('W', 'B');
                rotorMap.put('X', 'R');
                rotorMap.put('Y', 'C');
                rotorMap.put('Z', 'J');
                break;
            case II:
                rotorMap.put('A', 'A');
                rotorMap.put('B', 'J');
                rotorMap.put('C', 'D');
                rotorMap.put('D', 'K');
                rotorMap.put('E', 'S');
                rotorMap.put('F', 'I');
                rotorMap.put('G', 'R');
                rotorMap.put('H', 'U');
                rotorMap.put('I', 'X');
                rotorMap.put('J', 'B');
                rotorMap.put('K', 'L');
                rotorMap.put('L', 'H');
                rotorMap.put('M', 'W');
                rotorMap.put('N', 'T');
                rotorMap.put('O', 'M');
                rotorMap.put('P', 'C');
                rotorMap.put('Q', 'Q');
                rotorMap.put('R', 'G');
                rotorMap.put('S', 'Z');
                rotorMap.put('T', 'N');
                rotorMap.put('U', 'P');
                rotorMap.put('V', 'Y');
                rotorMap.put('W', 'F');
                rotorMap.put('X', 'V');
                rotorMap.put('Y', 'O');
                rotorMap.put('Z', 'E');
                break;
            case III:
                rotorMap.put('A', 'B');
                rotorMap.put('B', 'D');
                rotorMap.put('C', 'F');
                rotorMap.put('D', 'H');
                rotorMap.put('E', 'J');
                rotorMap.put('F', 'L');
                rotorMap.put('G', 'C');
                rotorMap.put('H', 'P');
                rotorMap.put('I', 'R');
                rotorMap.put('J', 'T');
                rotorMap.put('K', 'X');
                rotorMap.put('L', 'V');
                rotorMap.put('M', 'Z');
                rotorMap.put('N', 'N');
                rotorMap.put('O', 'Y');
                rotorMap.put('P', 'E');
                rotorMap.put('Q', 'I');
                rotorMap.put('R', 'W');
                rotorMap.put('S', 'G');
                rotorMap.put('T', 'A');
                rotorMap.put('U', 'K');
                rotorMap.put('V', 'M');
                rotorMap.put('W', 'U');
                rotorMap.put('X', 'S');
                rotorMap.put('Y', 'Q');
                rotorMap.put('Z', 'O');
                break;
            case IV:
                rotorMap.put('A', 'E');
                rotorMap.put('B', 'S');
                rotorMap.put('C', 'O');
                rotorMap.put('D', 'V');
                rotorMap.put('E', 'P');
                rotorMap.put('F', 'Z');
                rotorMap.put('G', 'J');
                rotorMap.put('H', 'A');
                rotorMap.put('I', 'Y');
                rotorMap.put('J', 'Q');
                rotorMap.put('K', 'U');
                rotorMap.put('L', 'I');
                rotorMap.put('M', 'R');
                rotorMap.put('N', 'H');
                rotorMap.put('O', 'X');
                rotorMap.put('P', 'L');
                rotorMap.put('Q', 'N');
                rotorMap.put('R', 'F');
                rotorMap.put('S', 'T');
                rotorMap.put('T', 'G');
                rotorMap.put('U', 'K');
                rotorMap.put('V', 'D');
                rotorMap.put('W', 'C');
                rotorMap.put('X', 'M');
                rotorMap.put('Y', 'W');
                rotorMap.put('Z', 'B');
                break;
            case V:
                rotorMap.put('A', 'V');
                rotorMap.put('B', 'Z');
                rotorMap.put('C', 'B');
                rotorMap.put('D', 'R');
                rotorMap.put('E', 'G');
                rotorMap.put('F', 'I');
                rotorMap.put('G', 'T');
                rotorMap.put('H', 'Y');
                rotorMap.put('I', 'U');
                rotorMap.put('J', 'P');
                rotorMap.put('K', 'S');
                rotorMap.put('L', 'D');
                rotorMap.put('M', 'N');
                rotorMap.put('N', 'H');
                rotorMap.put('O', 'L');
                rotorMap.put('P', 'X');
                rotorMap.put('Q', 'A');
                rotorMap.put('R', 'W');
                rotorMap.put('S', 'M');
                rotorMap.put('T', 'J');
                rotorMap.put('U', 'Q');
                rotorMap.put('V', 'O');
                rotorMap.put('W', 'F');
                rotorMap.put('X', 'E');
                rotorMap.put('Y', 'C');
                rotorMap.put('Z', 'K');
                break;
        }
    }

    public char encrypt(char c) {
        return this.rotorMap.get(c);
    }

    public char decrypt(char input) {
        for (Map.Entry<Character, Character> entry : rotorMap.entrySet()) {
            if (entry.getValue().equals(input)) {
                return entry.getKey();
            }
        }
        return ' ';
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
}
