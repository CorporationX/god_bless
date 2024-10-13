package school.faang.bjs2_33142;

import java.util.*;

public class Book {


    private String title;
    private String author;
    private int year;

    public  Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

//    Map<String, Integer> mapBook = new HashMap<>();
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null|| getClass()!= o.getClass())return false;
        Book bookOfLibreryVesteros = (Book) o;
        return year == bookOfLibreryVesteros.year &&
                Objects.equals(title,bookOfLibreryVesteros.title) &&
                Objects.equals(author,bookOfLibreryVesteros.author);
}
    @Override
    public  int hashCode(){
        return Objects.hash(title,author,year);
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.title = author;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
}
