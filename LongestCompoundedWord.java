package Assesment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class TrieNode {             //initailising the TRIE DS
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    } 

    public void insert(String word) {       //inserting the word in the TRIE tree
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {    //here searching in the TRIE tree
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current != null && current.isEndOfWord;
    }
}

public class LongestCompoundedWord {           //Main class
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String inputFileName = "C:\\Users\\akhil\\Documents\\CODE\\Java\\Assesment\\Input_02.txt";

        String longestCompoundedWord = "";
        String secondLongestCompoundedWord = "";
        Trie trie = new Trie();
        List<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
                trie.insert(line);
            }

            for (String word : words) {
                if (isCompoundedWord(word, trie)) {
                    if (word.length() > longestCompoundedWord.length()) {
                        secondLongestCompoundedWord = longestCompoundedWord;
                        longestCompoundedWord = word;
                    } else if (word.length() > secondLongestCompoundedWord.length()) {
                        secondLongestCompoundedWord = word;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Longest Compound Word: " + longestCompoundedWord);
        System.out.println("Second Longest Compound Word: " + secondLongestCompoundedWord);
        System.out.println("Time taken to process file in milliseconds: " + (endTime - startTime) + " milliseconds");
    }

    private static boolean isCompoundedWord(String word, Trie trie) {
        if (word.isEmpty()) {
            return false;
        }

        int n = word.length();
        for (int i = 1; i <= n; i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (trie.search(prefix) && (trie.search(suffix) || isCompoundedWord(suffix, trie))) {
                return true;
            }
        }
        return false;
    }
}

