package faang.school.godbless.BJS2_542;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("Великий Гэтсби", "Фрэнсис Скотт Фицджеральд", 1925);
        Book book2 = new Book("Убить пересмешника", "Харпер Ли", 1960);
        Book book3 = new Book("1984", "Джордж Оруэлл", 1949);


        library.put(book1, "Shelf A");
        library.put(book2, "Shelf B");
        library.put(book3, "Shelf C");
    }
    public static void addBook (Book book, String location) {
        library.put(book, location);
    }
}
