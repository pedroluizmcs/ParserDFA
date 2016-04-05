package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, Boolean.toString(isValid(JOptionPane.showInputDialog("Enter the sentence:").toUpperCase())));
    }

    public static boolean isValid(String sentence) {
        return hasPrefix(sentence) && hasSubstring(sentence) && hasSuffix(sentence);
    }

    public static boolean hasPrefix(String sentence) {
        return sentence.startsWith("ABAB") || sentence.startsWith("BABA");
    }

    public static boolean hasSubstring(String sentence) {
        return sentence.contains("ABABA") || sentence.contains("BABAB") || sentence.contains("AABAB");
    }

    public static boolean hasSuffix(String sentence) {
        return sentence.endsWith("ABAB") || sentence.endsWith("BABA");
    }
}
