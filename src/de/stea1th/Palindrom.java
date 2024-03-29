package de.stea1th;

import acm.program.ConsoleProgram;

public class Palindrom extends ConsoleProgram {

    @Override
    public void run() {
        while(true){
            println("The word is a palindrome: " + isPalindrome(readLine("Enter a word: ")));
        }
    }

    private boolean isPalindrome(String text){
        String toLowerCase = text.toLowerCase();
        return toLowerCase.equals(new StringBuilder(toLowerCase).reverse().toString());
    }
}
