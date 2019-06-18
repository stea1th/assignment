package de.stea1th;

import acm.program.ConsoleProgram;

import java.util.Arrays;
import java.util.List;

public class Assignment2 extends ConsoleProgram {

    private static final List<Integer> ASCII_VOCALS = Arrays.asList(65, 97, 69, 101, 73, 105, 79, 111, 85, 117);

    @Override
    public void run() {
        while(true){
            println(removeVocals(readLine("Enter text: ")));
        }
    }

    private String removeVocals(String text){
        String result = "";
        for (int i = 0; i <text.length() ; i++) {
            if(!ASCII_VOCALS.contains(text.codePointAt(i))){
                result += text.charAt(i);
            }
        }
        return result;
    }
}
