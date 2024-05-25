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

    public char encrypt(char c) {
        if (!plugboardMap.containsKey(c)) {
            return c;
        }
        return this.plugboardMap.get(c);
    }

    public char decrypt(char c) {
        for (Map.Entry<Character, Character> entry : plugboardMap.entrySet()) {
            if (entry.getValue().equals(c)) {
                return entry.getKey();
            }
        }
        return c;
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
