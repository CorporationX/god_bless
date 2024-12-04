package school.faang.sprint1.task_45309;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("title1", "author1", 1999);
        Book book2 = new Book("title2", "author2", 2006);

        HashMap<Book, String> map = new HashMap<>();
        map.put(book1, "1");
        map.put(book2, "2");
        map.put(book1, "17");
        LibrarySystem ls = new LibrarySystem(map);
        ls.addBook("title3", "author3", 2017, "3");
        ls.printAllBooks();
        ls.addBook("title4", "author4", 1986, "4");
        ls.printAllBooks();
        ls.findBook("title1", "author1", 1999);
    }
}
