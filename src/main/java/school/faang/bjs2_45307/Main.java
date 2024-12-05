package school.faang.bjs2_45307;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book,String>library = new HashMap<>();

    public static void main(String[] args) {
    
    LibrarySystem.addBook("Дориан Грей", "Оскар Уальд", 1965,"0001");
    LibrarySystem.addBook( "Гарри Потер", "Джоан Ролинг", 1998,"0002");
    LibrarySystem.addBook( "Винни Пух", "Алан Александр Милн", 1978,"0003");
    LibrarySystem.addBook( "Пинокио", "Карло Коллоди", 1971,"0004");
    LibrarySystem.printAllBooks();
    LibrarySystem.removeBook("Винни Пух", "Алан Александр Милн", 1978);
    LibrarySystem.printAllBooks();
    LibrarySystem.findBook("Гарри Потер", "Джоан Ролинг", 1998);
    }
}
