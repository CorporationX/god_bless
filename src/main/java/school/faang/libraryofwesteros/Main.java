package school.faang.libraryofwesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        library.put(new Book("Head First Java", "B.Bates & K.Sierra",
                2005), "Стеллаж К, полка №4");
        library.put(new Book("Harry Potter and the Chamber of Secrets", "J.K.Rowling",
                2014), "Стеллаж Ф, полка №2");
        library.put(new Book("Harry Potter and the Methods of Rational Thinking", "E. Yudkovsky",
                2018), "Стеллаж Х, полка №4");
    }
}