package com.corie_rhodes;

import java.util.HashMap;
import java.util.Map;

public class Reflector {

    private final Map<Character, Character> reflectorMap;

    public Reflector() {
        reflectorMap = new HashMap<>();
        generateMap();
    }

    public String reflect(String original) {
        char[] msg = original.toCharArray();
        for (int i = 0; i < msg.length; i++) {
            msg[i] = reflectorMap.get(msg[i]);
        }
        return new String(msg);
    }

    private void generateMap() {
        if (reflectorMap != null){
            reflectorMap.put('A', 'L');
            reflectorMap.put('L', 'A');

            reflectorMap.put('S', 'K');
            reflectorMap.put('K', 'S');

            reflectorMap.put('D', 'J');
            reflectorMap.put('J', 'D');

            reflectorMap.put('F', 'H');
            reflectorMap.put('H', 'F');

            reflectorMap.put('Z', 'M');
            reflectorMap.put('M', 'Z');

            reflectorMap.put('X', 'N');
            reflectorMap.put('N', 'X');

            reflectorMap.put('C', 'B');
            reflectorMap.put('B', 'C');

            reflectorMap.put('Q', 'P');
            reflectorMap.put('P', 'Q');

            reflectorMap.put('W', 'O');
            reflectorMap.put('O', 'W');

            reflectorMap.put('E', 'I');
            reflectorMap.put('I', 'E');

            reflectorMap.put('R', 'U');
            reflectorMap.put('U', 'R');

            reflectorMap.put('T', 'Y');
            reflectorMap.put('Y', 'T');

            reflectorMap.put('G', 'V');
            reflectorMap.put('V', 'G');
        }
    }


}
