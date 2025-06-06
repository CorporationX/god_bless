package school.faang.bjs279691;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private Map<Book, String> dataBase = new HashMap<>();

    public void addBook(String title, String author, int year, String local) {
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty() || local == null || local.trim().isEmpty()) {
            log.error("Либо пустая строка, либо ничего не введено");
            return;
        }
        Book addB = new Book(title, author, year);
        dataBase.put(addB, local);
        log.info("Книга {} добавлена в базу данных", addB);
    }

    public void removeBook(String title, String author, int year) {
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty()) {
            return;
        }
        Book findBookForRemove = new Book(title, author, year);
        for (Book book : dataBase.keySet()) {
            if (book.equals(findBookForRemove)) {
                dataBase.remove(findBookForRemove);
                log.info("Книга {} удалена с базы данных", findBookForRemove);
                return;
            }
        }
        log.info("Книга {} не найдена в базе данных", findBookForRemove);

    }

    public void findBook(String title, String author, int year) {
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty()) {
            return;
        }
        Book findB = new Book(title, author, year);
        for (Book book : dataBase.keySet()) {
            if (book.equals(findB)) {
                System.out.printf("Книга %s находиться в библеотеки на: %s%n", findB.getTitle(), dataBase.get(findB));
                return;
            }
        }
        log.info("Книга {} не найдена в библиотеке", findB);

    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : dataBase.entrySet()) {
            System.out.print("В библиотеке такой список книг: ");
            System.out.println(entry.getKey() + " в библиотеки находиться:  " +  entry.getValue());
        }
    }
}
