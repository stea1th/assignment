package de.stea1th;

import acm.program.ConsoleProgram;

public class Assignment2 extends ConsoleProgram {

    private static final Character[] VOCALS = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'};

    @Override
    public void run() {
        while(true){
            println(removeVocals(readLine("Enter text: ")));
        }
    }

    private String removeVocals(String text){
        String result = "";
        for (int i = 0; i <text.length() ; i++) {
            if(!isVocal(text.charAt(i))){
                result += text.charAt(i);
            }
        }
        return result;
    }

    private boolean isVocal(Character character){
        for(Character c : VOCALS ){
            if(c == character){
                return true;
            }
        }
        return false;
    }
}
