package de.stea1th;

import acm.program.ConsoleProgram;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Assignment4 extends ConsoleProgram {

    @Override
    public void run() {
        while (true) {
            String word = readLine("Enter word to get translate: ");
            Set<String> set = getDictionaryAsMapWithWords().get(word.toLowerCase());
            println(set == null ? "Here is no translate for this word" : String.join(", ", set));
        }
    }

    private Map<String, Set<String>> getDictionaryAsMapWithWords() {
        Map<String, Set<String>> map = new HashMap<>();
        for (String s : getAllLines()) {
            String[] arr = s.split("=");
            Set<String> set = map.get(arr[0]);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(arr[1]);
            map.put(arr[0], set);
        }
        return map;
    }

    private List<String> getAllLines() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("D:\\JavaProjects\\Libraries\\dictionary_en_de.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}
