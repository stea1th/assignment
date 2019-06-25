package de.stea1th;

import java.util.Set;
import java.util.TreeSet;

public class Word {

    private String name;
    private Integer count;
    private Set<Integer> lineNumbers;

    public Word(String name, Integer count, Set<Integer> lineNumbers) {
        this.name = name;
        this.count = count;
        this.lineNumbers = lineNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<Integer> getLineNumbers() {
        return lineNumbers;
    }

    public void setLineNumbers(TreeSet<Integer> pageNumbers) {
        this.lineNumbers = pageNumbers;
    }

    public void addLineNumberAndCount(Integer lineNumber){
        count++;
        lineNumbers.add(lineNumber);
    }
}
