package faang.school.godbless.BJS2_8474;

//
//        Реализуйте методы для следующих действий:
//вывод списка всех книг и их местонахождения в библиотеке.

import java.util.HashMap;

public class Main {
    private HashMap<Book, String> books = new HashMap<>();

    public Main() {
        addNewBook("Мастер и Маргарита", "Булгаков", 1928, "Драма");
        addNewBook("Маленький принц", "Сент-Экзюпери", 1942, "Сказка");
        addNewBook("Теория всего", "Стивен Хокинг", 2006, "Астрономия");
    }


    public void addNewBook(String title, String author, int year, String placeInLibrary) {
        if (placeInLibrary == null) throw new IllegalArgumentException();
        checkIfBookVariablesIsNull(title, author, year);

        books.put(createBook(title, author, year), placeInLibrary);
    }

    public void deleteBook(String title, String author, int year) {
        checkIfBookVariablesIsNull(title, author, year);

        books.remove(createBook(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        checkIfBookVariablesIsNull(title, author, year);

        String place = books.get(createBook(title, author, year));
        System.out.println("Местонахождение книги " + title + ": " + place);

    }

    public void findAllBooks() {
        books.forEach((key, value) -> System.out.println("Книга: " + key + " " + "Местонахождение: " + value));
    }

    private void checkIfBookVariablesIsNull(String title, String author, int year) {
        if (title == null || title.trim().isEmpty() ||
                author == null || author.trim().isEmpty() ||
                year < 1600)
            throw new IllegalArgumentException();
    }

    private Book createBook(String title, String author, int year) {
        return new Book(title, author, year);
    }

}
