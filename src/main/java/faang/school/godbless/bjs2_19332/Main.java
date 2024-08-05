package faang.school.godbless.bjs2_19332;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var book1 = Book.builder().build();
        var book2 = Book.builder().title("1").author("1").year((short) 1).build();
        var book3 = Book.builder().title("1").author("1").year((short) 2).build();
        var book4 = Book.builder().title("1").author("2").year((short) 1).build();
        var book5 = Book.builder().title("2").author("1").year((short) 1).build();

        var library = new HashMap<Book, String>();

        library.put(book1, "shelf1");
        library.put(book2, "shelf2");
        library.put(book3, "shelf3");
        library.put(book4, "shelf4");
        library.put(book5, "shelf5");
        System.out.println("Size 1: " + library.size());

        var bookToDelete = Book.builder().title("1").author("1").year((short) 1).build();
        library.remove(bookToDelete);
        System.out.println("Size 2: " + library.size());

        var bookToFind = Book.builder().title("2").author("1").year((short) 1).build();
        var foundBook = library.get(bookToFind);
        System.out.println("Found book: " + foundBook);

        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey().toString() + " ----> " + entry.getValue());
        }
    }
}
