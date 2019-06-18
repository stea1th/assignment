package de.stea1th;

import acm.program.ConsoleProgram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class BuildIndex extends ConsoleProgram {

    private static final List<String> SUFFIX = Arrays.asList("ish", "ive", "less", "y",
            "ious", "ous", "ic", "ical", "ful",
            "esque", "al", "able", "ible", "ize",
            "ise", "ify", "fy", "en", "ate", "sion",
            "tion", "ship", "ness", "ment", "ity", "ty",
            "ist", "ism", "er", "or", "dom", "ance", "ence", "al", "acy");

    private static final List<String> STOP_WORDS = Arrays.asList("ourselves", "hers", "between", "yourself", "but",
            "again", "there", "about", "once", "during", "out", "very", "having",
            "with", "they", "own", "an", "be", "some", "for", "do", "its", "yours",
            "such", "into", "of", "most", "itself", "other", "off", "is", "s", "am",
            "or", "who", "as", "from", "him", "each", "the", "themselves", "until",
            "below", "are", "we", "these", "your", "his", "through", "don", "nor", "me",
            "were", "her", "more", "himself", "this", "down", "should", "our", "their",
            "while", "above", "both", "up", "to", "ours", "had", "she", "all", "no", "when",
            "at", "any", "before", "them", "same", "and", "been", "have", "in", "will", "on",
            "does", "yourselves", "then", "that", "because", "what", "over", "why", "so", "can",
            "did", "not", "now", "under", "he", "you", "herself", "has", "just", "where", "too",
            "only", "myself", "which", "those", "i", "after", "few", "whom", "t", "being", "if",
            "theirs", "my", "against", "a", "by", "doing", "it", "how", "further", "was", "here", "than");

    @Override
    public void run() {
        while (true) {
            List<String> bookStrings = readAllLinesFromBook();
            println("===================================================");
            filterAndCountWords(splitTextIntoPages(Objects.requireNonNull(bookStrings)))
                    .stream()
                    .sorted(Comparator.comparing(Word::getName))
                    .forEach(i -> {
                String pages = i.getPageNumbers().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));
                println(i.getName() + " => repeats: " + i.getCount() + " pages: " + pages);
            });
        }
    }

    private List<String> readAllLinesFromBook() {
        try {
            return Files.readAllLines(Paths.get(readLine("Enter a path to book: ")));
//            return Files.readAllLines(Paths.get("d:\\test\\text.txt"));
        } catch (IOException e) {
            println("Cant read this book");
        } catch (Exception e) {
            println("Something goes wrong");
        }
        return new ArrayList<>();
    }

    private Map<Integer, List<String>> splitTextIntoPages(List<String> bookStrings) {
        Map<Integer, List<String>> stringsAndPages = new HashMap<>();
        List<String> strings = new ArrayList<>();
        int number = 1;
        for (String s : bookStrings) {
            if (s.matches("(.*)\\{\\d+}(.*)")) {
                String[] el = s.split("\\{\\d+}");
                if(el.length>0) {
                    strings.add(el[0]);
                    stringsAndPages.put(number, strings);
                    strings = new ArrayList<>();
                    if (el.length > 1) strings.add(el[1]);
                    stringsAndPages.put(++number, strings);
                }
            } else {
                strings.add(s);
                stringsAndPages.put(number, strings);
            }
        }
        return stringsAndPages;
    }

    private List<Word> filterAndCountWords(Map<Integer, List<String>> stringsAndPages) {
        Map<String, Word> resultWords = new HashMap<>();
        stringsAndPages.forEach((k, v) -> {
            for (String s : v) {
                String[] words = s.split("[]\"',;:.!?()〈\\-—•’_“”‘\\[/ \\W]");
                Arrays.stream(words)
                        .map(String::toLowerCase)
                        .forEach(i -> {
                            if (filter(i)) {
                                Word word = resultWords.get(i);
                                if (word != null) {
                                    word.addPageNumberAndCount(k);
                                } else {
                                    Set<Integer> set = new TreeSet<>();
                                    set.add(k);
                                    word = new Word(i, 1, set);
                                }
                                resultWords.put(i, word);
                            }
                        });
            }
        });
        return new ArrayList<>(resultWords.values());
    }

    private boolean filter(String word) {
        return word.length() > 7 && !STOP_WORDS.contains(word) && SUFFIX.stream().noneMatch(word::endsWith);
    }
}
