package school.faang.bjs279691;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private Map<Book, String> dataBase = new HashMap<>();

    protected boolean checkingEmptyDataBase() {
        if (dataBase == null) {
            log.error("Ошибка: база данных не инициализирована");
            return false;
        }
        return true;
    }

    public void addBook(String title, String author, int year, String local) {
        Book addB = new Book(title, author, year);
        dataBase.put(addB, local);
        log.info("Книга {} добавлена в базу данных", addB);
    }

    public void removeBook(String title, String author, int year) {
        Book findBookForRemove = new Book(title, author, year);
        if (dataBase.get(findBookForRemove) == null) {
            log.info("Книга {} не найдена в библиотеке", findBookForRemove);
            return;
        }
        log.info("Книга {} не может быть удалена из библиотеки так как ее там и так нет", findBookForRemove);
        dataBase.remove(findBookForRemove);

    }

    public void findBook(String title, String author, int year) {
        if (checkingEmptyDataBase()) {
            return;
        }
        Book findB = new Book(title, author, year);
        if (dataBase.get(findB) == null) {
            log.info("Книга {} не найдена в библиотеке", findB);
            return;
        }
        System.out.printf("Книга %s находиться в библеотеки на: %s%n", findB.getTitle(), dataBase.get(findB));

    }

    public void printAllBooks() {
        if (dataBase == null) {
            log.error("Ошибка: база данных не инициализирована");
            return;
        }
        for (Map.Entry<Book, String> entry : dataBase.entrySet()) {
            System.out.print("В библиотеке такой список книг: ");
            System.out.printf("%s в библиотеки находиться:  %s\n", entry.getKey(), entry.getValue());
        }
    }
}
