package de.stea1th;

import acm.program.ConsoleProgram;

import java.util.Stack;

public class Palindrom2 extends ConsoleProgram {

    @Override
    public void run() {
        while (true) {
            String text = readLine("Enter a word: ");
            boolean palindrom = isPalindrom(text);
            println("The word is a palindrome: " + palindrom);
        }
    }

    private boolean isPalindrom(String text) {
        char[] chars = text.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            stack.push(c);
        }
        for (char c : chars) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;

    }
}
