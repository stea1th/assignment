package de.stea1th;

import acm.program.ConsoleProgram;

public class Parentheses extends ConsoleProgram {

    @Override
    public void run() {
        while (true) {
            String text;
            println((text = readLine()) + ": " + doParenthesesMatch(text));
        }
    }

    private boolean doParenthesesMatch(String text) {
        int x = 0, y = 0, z = 0;
        for (char c : text.toCharArray()) {
            switch (c) {
                case '(':
                    x++;
                    break;
                case ')':
                    x--;
                    if (x < 0) return false;
                    break;
                case '{':
                    y++;
                    break;
                case '}':
                    y--;
                    if (y < 0) return false;
                    break;
                case '[':
                    z++;
                    break;
                case ']':
                    z--;
                    if(z < 0) return false;
                    break;
            }
        }
        return x == y && y == z && z == 0;
    }
}
