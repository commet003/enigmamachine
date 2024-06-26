package com.corie_rhodes;

import java.util.HashMap;
import java.util.Map;

public class Plugboard {
    private final Map<Character, Character> plugboardMap;

    public Plugboard() {
        plugboardMap = new HashMap<>();
    }

    public void addPlug(char c1, char c2) {
        if (plugboardMap.containsKey(c1)){
            plugboardMap.remove(plugboardMap.get(c1));
            plugboardMap.remove(c1);
        }
        plugboardMap.put(c1, c2);
        plugboardMap.put(c2, c1);
        this.print();
    }

    public String encrypt(String message) {
        return transform(message);
    }

    public String decrypt(String secret) {
        return transform(secret);
    }

    private String transform(String original) {
        char[] msg = original.toCharArray();
        for (int i = 0; i <msg.length; i++) {
            if (Character.isUpperCase(msg[i])) {
                if (!plugboardMap.isEmpty())
                    msg[i] = (plugboardMap.get(msg[i]) != null) ? plugboardMap.get(msg[i]) : msg[i];
            }
        }
        return new String(msg);
    }

    public void print() {
        for (Map.Entry<Character, Character> entry : plugboardMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + "\n");
        }
    }

    public void clear() {
        plugboardMap.clear();
        System.out.println("Plugboard Cleared");
    }
}
