package faang.school.godbless;

import java.util.HashMap;

public class Main {

    public static HashMap<Book, String> bookShelfMap = new HashMap<>();

    static {
        bookShelfMap.put(new Book("Clean code", "Martin", 2020), "Programming");
        bookShelfMap.put(new Book("Microservices", "Richardson", 2022), "Programming");
        bookShelfMap.put(new Book("Apache Kafka", "Krit", 2024), "Programming");
        bookShelfMap.put(new Book("Sherlok", "Doyle", 2023), "Artistic");
    }
}
