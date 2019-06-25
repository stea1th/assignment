package de.stea1th;

import acm.program.ConsoleProgram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class BuildIndex2 extends ConsoleProgram {

    @Override
    public void run() {
//        while (true) {
            List<String> bookStrings = readAllLinesFromBook();
            println("===================================================");
            filterAndCountWords(Objects.requireNonNull(bookStrings))
                    .stream()
                    .sorted(Comparator.comparing(Word::getName))
                    .forEach(i -> {
                        String pages = i.getLineNumbers().stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(", "));
                        println(i.getName() + " => repeats: " + i.getCount() + " pages: " + pages);
                    });
//        }
    }

    private List<String> readAllLinesFromBook() {
        try {
//            return Files.readAllLines(Paths.get(readLine("Enter a path to book: ")));
            return Files.readAllLines(Paths.get("D:\\JavaProjects\\Libraries\\TomSawyer.txt"));
        } catch (IOException e) {
            println("Cant read this book");
        } catch (Exception e) {
            println("Something goes wrong");
        }
        return new ArrayList<>();
    }

    private List<Word> filterAndCountWords(List<String> list) {
        Map<String, Word> resultWords = new HashMap<>();
        int lineNumber = 1;
        for (String s : list) {
//            String[] words = s.split("[]\"',;:.!?()〈\\-—•’_“”‘\\[/ \\W]");
            StringTokenizer st = new StringTokenizer(s, "[]\"',;:.!?()〈\\-—•’_“”‘\\[/ \\W]");
//            for(String w : words){
            while(st.hasMoreTokens()){
               String  w = st.nextToken().toLowerCase();
                Word word = resultWords.get(w);
                if (word != null) {
                    word.addLineNumberAndCount(lineNumber);
                } else {
                    Set<Integer> set = new TreeSet<>();
                    set.add(lineNumber);
                    word = new Word(w, 1, set);
                }
                resultWords.put(w, word);
            }
            lineNumber++;
        }
        return new ArrayList<>(resultWords.values());
    }
}
