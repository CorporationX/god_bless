package school.faang.bjs279653;

import java.util.HashMap;

public class LibrarySystem {
    private HashMap<Book, String> hashmap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        hashmap.put(new Book(title, author, year), location);
    }

    ////addBook(String title, String author, int year, String location) — добавляет новую книгу с её местонахождением в библиотеке.

    //removeBook(String title, String author, int year) — удаляет книгу из библиотеки по её названию, автору и году издания.

    //findBook(String title, String author, int year) — ищет книгу по названию, автору и году издания и выводит информацию о её местонахождении в библиотеке. Если книга не найдена, метод должен сообщить об этом.

    //printAllBooks() — выводит полный список всех книг в библиотеке и их местонахождение.
}
