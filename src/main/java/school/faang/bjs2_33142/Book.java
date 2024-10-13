package school.faang.bjs2_33142;
import java.util.*;
public class Book {


    private String title;
    private String author;
    private int year;

    public  void Book(String title,String author,int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }
    Map<String, Integer> mapBook = new HashMap<>();

}
