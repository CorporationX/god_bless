package school.faang.sprint_1.task_45312;

import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library;

    public LibrarySystem(Map<Book, String> library) {
        this.library = library;
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.remove(book);

        if (location == null) {
            System.out.println("Книга " + book + " отсутсвует\n");
        } else {
            System.out.println("Книга " + book + " удалена\n");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);

        if (location == null) {
            System.out.println("Книга " + book + " отсутсвует\n");
        } else {
            System.out.println("Книга " + book + " находится на полке " + location + "\n");
        }
    }

    public void printAllBooks() {
        System.out.println("Библиотека:");
        int i = 1;
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(i + ")" + "\tКнига: " + entry.getKey() + '\n' + "\tПолка: " + entry.getValue() + '\n');
            i++;
        }
        System.out.println();
    }
}
