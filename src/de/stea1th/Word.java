package de.stea1th;

import java.util.Set;
import java.util.TreeSet;

public class Word {

    private String name;
    private Integer count;
    private Set<Integer> pageNumbers;

    public Word(String name, Integer count, Set<Integer> pageNumbers) {
        this.name = name;
        this.count = count;
        this.pageNumbers = pageNumbers;
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

    public Set<Integer> getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(TreeSet<Integer> pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public void addPageNumberAndCount(Integer pageNumber){
        count++;
        pageNumbers.add(pageNumber);
    }
}
