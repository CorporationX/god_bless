package faang.school.godbless.BJS2_4561;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Map<Book, String> bookMap = new HashMap<>();

        Book horror = new Book("Horror", "Tom", 1720);
        Book sleep = new Book("How to sleep?", "Cris", 2024);
        Book future = new Book("Future", "Stranger", 9570);

        bookMap.put(horror, "Третья полка с лева");
        bookMap.put(sleep, "Вторая полка с права");
        bookMap.put(future, "Первая полка центр");

        ActionOnBook.printAllBook(bookMap);
        ActionOnBook.addNewBook("My house", "Anton", 2000, bookMap, "Третья полка с права");
        ActionOnBook.printAllBook(bookMap);
        ActionOnBook.deleteBook(future, bookMap);
        ActionOnBook.printAllBook(bookMap);
        ActionOnBook.searchBook(sleep, bookMap);
        ActionOnBook.printAllBook(bookMap);
    }
}
