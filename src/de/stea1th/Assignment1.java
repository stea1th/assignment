package de.stea1th;

import acm.program.ConsoleProgram;

public class Assignment1 extends ConsoleProgram {

    @Override
    public void run() {
        while(true){
            println(readLine("Enter text: ").replaceAll("[AaEeIiOoUu]", ""));
        }
    }
}
