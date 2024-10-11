package vesterosse.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> map = new HashMap<>();
        map.put(new Book("The Mythical Man-Month", "Frederick Brooks", 2020), "1");
        map.put(new Book("A Philosophy Of Software Design", "John Ousterhout", 2015), "3");
        map.put(new Book("Code Complete: A Practical Handbook of Software Construction", "Steve McConnell", 2017), "2");
        map.put(new Book("Working Effectively with Legacy Code", "Michael C. Feathers", 2023), "1");

        Book.addBook(map, new Book("Clean Code", "Robert C. Martin", 2013), "2");
        Book.removeBook(map, "Code Complete: A Practical Handbook of Software Construction", "Steve McConnell", 2017);
        Book.searchBook(map, "A Philosophy Of Software Design", "John Ousterhout", 2015);
        Book.printBook(map);
    }
}
