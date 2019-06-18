package de.stea1th;

import acm.program.ConsoleProgram;

import java.util.Arrays;
import java.util.List;

public class Assignment2 extends ConsoleProgram {

    private static final List<Character> VOCALS = Arrays.asList('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u');

    @Override
    public void run() {
        while(true){
            println(removeVocals(readLine("Enter text: ")));
        }
    }

    private String removeVocals(String text){
        String result = "";
        for (int i = 0; i <text.length() ; i++) {
            if(!VOCALS.contains(text.charAt(i))){
                result += text.charAt(i);
            }
        }
        return result;
    }
}
