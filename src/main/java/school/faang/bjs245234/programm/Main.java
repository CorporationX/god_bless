package school.faang.bjs245234.programm;

import school.faang.bjs245234.model.Book;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /**
         * В классе Main, создайте HashMap с ключом типа Book и значением типа String
         * (местонахождение книги в библиотеке, например, номер полки).
         */
        Map<Book, String> map = new HashMap<>();

        /**
         * Добавьте информацию о нескольких книгах в ваш HashMap.
         */
        map.put(new Book("titl1", "autor1", 2001), "table1");
        map.put(new Book("titl2", "autor2", 2001), "table2");
        map.put(new Book("titl3", "autor1", 2001), "table3");
        map.put(new Book("titl4", "autor3", 2001), "table2");
    }
}
