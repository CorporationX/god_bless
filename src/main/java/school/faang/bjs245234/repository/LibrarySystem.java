package school.faang.bjs245234.repository;

import school.faang.bjs245234.model.Book;

import java.util.Map;

/**
 * Реализуйте следующие методы в классе LibrarySystem:
 *     addBook(String title, String author, int year, String location) —
 *     добавляет новую книгу с её местонахождением в библиотеке.
 *     removeBook(String title, String author, int year) — удаляет книгу из библиотеки по её названию,
 *     автору и году издания.
 *     findBook(String title, String author, int year) — ищет книгу по названию,
 *     автору и году издания и выводит информацию о её местонахождении в библиотеке.
 *     Если книга не найдена, метод должен сообщить об этом.
 *     printAllBooks() — выводит полный список всех книг в библиотеке и их местонахождение.
 */
public class LibrarySystem {
    private Map<Book, String> map;

    public LibrarySystem(Map<Book, String> map) {
        this.map = map;
    }
}
