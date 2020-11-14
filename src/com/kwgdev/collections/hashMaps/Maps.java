package com.kwgdev.collections.hashMaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps{

    // A map is basically like a dictionary or hashtable
    // words and then their definitions
    // keys and their values

    // Maps contain NO DUPLICATES just like Sets/HashSets

    // HashMap, LinkedHashMap, TreeMap

    public static void main(String[] args) {

        HashMap<String, String> dictionary = new HashMap<String, String>();
        // insert <key,value> with put() method
        dictionary.put("Brave", "ready to face and endure danger");
        dictionary.put("Cat", "A Feline Frenzy");
        dictionary.put("Funny", "Makes you  laugh!");
        dictionary.put("Skyscraper", "big building");
        dictionary.put("Lawyer", "Lawyer Joke");

        // have to invoke .keySet() method to iterate over dictionary keys
        for(String word : dictionary.keySet()) {
            System.out.println(word);
        }

        System.out.println("\n\n");

        // A LinkedHashMap keeps the items in order similar to LinkedHashSet
        LinkedHashMap<String, String> dictionary2 = new LinkedHashMap<String, String>();
        dictionary2.put("Brave", "ready to face and endure danger");
        dictionary2.put("Cat", "A Feline Frenzy");
        dictionary2.put("Funny", "Makes you  laugh!");
        dictionary2.put("Skyscraper", "big building");
        dictionary2.put("Lawyer", "Lawyer Joke");

        System.out.println("dictionary in order using LinkedHashMap\n");
        for(String word : dictionary2.keySet()) {
            System.out.println(word);
        }
        System.out.println("\n\n");

        // iterating over the key-value pairs is called an EntrySet
        System.out.println("iterating over the key-value pairs is called an EntrySet...\n");
        for(Map.Entry<String, String> entry: dictionary2.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("\n\n TreeMaps!");

        // TREEMAPS
        // A TreeMap automatically sorts items in their natural order
        TreeMap<String, String> dictionarytree = new TreeMap<String, String>();
        dictionarytree.put("Brave", "ready to face and endure danger");
        dictionarytree.put("Cat", "A Feline Frenzy");
        dictionarytree.put("Funny", "Makes you  laugh!");
        dictionarytree.put("Skyscraper", "big building");
        dictionarytree.put("Lawyer", "Lawyer Joke");

        // iterating over the key-value pairs is called an EntrySet
        System.out.println("iterating over the key-value pairs as a TreeMap...\n");
        for(Map.Entry<String, String> entry: dictionary2.entrySet()) {
            System.out.println(entry);
        }

    }

}
