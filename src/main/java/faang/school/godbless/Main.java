package src.main.java.faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book,String> map = new HashMap<>();
    public static void main(String[] args) {
        Book book1 = new Book("GrokaemAlgaritmi","Bhargava",2016);
        Book book2 = new Book("ChistiyCode","Martin",2008);
        map.put(book1,"#1");
        map.put(book2,"#2");
        Book.deleteBook("ChistiyCode", "Martin", 2008);
        Book.addNewBook("Tyrgenev","MyMy",1937);
        Book.SearchAndPrintBook("GrokaemAlgaritmi","Bhargava",2016);
        Book.showSetBookAndMesto();
    }
}
