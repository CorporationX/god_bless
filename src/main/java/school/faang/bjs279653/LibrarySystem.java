package school.faang.bjs279653;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> map = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        map.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        Book findBook = new Book(title, author, year);
        Iterator<Map.Entry<Book, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Book, String> entry = iterator.next();
            if (entry.getKey().equals(findBook)) {
                iterator.remove(); // Безопасное удаление
            }
        }
    }

    public void findBook(String title, String author, int year) {
        Book findBook = new Book(title, author, year);
        String result = "";
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            if (entry.getKey().equals(findBook)) {
                result = entry.getValue();
            }
        }
        if (result.equals("")) {
            result = "Книга не найдена";
        }
        System.out.println(result);
    }


    public void printAllBooks() {
        map.forEach((Book book, String lokal) -> {
            System.out.println(book.toString() + lokal);
        });
    }
}


//addBook(String title, String author, int year, String location) — добавляет новую книгу с её местонахождением в библиотеке.
//
//removeBook(String title, String author, int year) — удаляет книгу из библиотеки по её названию, автору и году издания.
//
//findBook(String title, String author, int year) — ищет книгу по названию, автору и году издания и выводит информацию о её местонахождении в библиотеке. Если книга не найдена, метод должен сообщить об этом.
//
//printAllBooks() — выводит полный список всех книг в библиотеке и их местонахождение.