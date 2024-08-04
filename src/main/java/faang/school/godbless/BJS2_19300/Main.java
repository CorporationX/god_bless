package faang.school.godbless.BJS2_19300;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Main {

    private Map<Book, String> booksInfo;

    public Main() {
        this.booksInfo = new HashMap<>();
        booksInfo.put(new Book("Война и мир", "Толстой Л.Н.", 1873), "1 полка");
        booksInfo.put(new Book("Идиот", "Достоевский Ф.М.", 1874), "2 полка");
        booksInfo.put(new Book("Капитанская дочка", "Пушкин А.С.", 1836), "3 полка");
    }

    public void addNewBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        booksInfo.put(book, location);
        System.out.println("Книга " + book.getTitle() + " добавлена");
    }

    public void removeBook(String title, String author, Integer year) {
        Book book = new Book(title, author, year);
        booksInfo.remove(book);
        System.out.println("Книга " + book.getTitle() + " удалена");
    }

    public String findBook(String title, String author, Integer year) {
        Book book = new Book(title, author, year);
        return booksInfo.getOrDefault(book, "Книга не найдена в библиотеке");
    }

    public void printAllBooks() {
        System.out.println("Все книги в библиотеке:");
        for (Map.Entry<Book, String> entry : booksInfo.entrySet()) {
            System.out.println(entry.getKey() + " находится на " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Main library = new Main();
        library.printAllBooks();

        System.out.println("Добавление новой книги 'Мастер и Маргарита':");
        library.addNewBook("Мастер и Маргарита", "Булгаков М.А.", 1967, "4 полка");
        library.printAllBooks();

        System.out.println("Поиск книги 'Война и мир':");
        System.out.println(library.findBook("Война и мир", "Толстой Л.Н.", 1873));

        System.out.println("Поиск книги 'Анна Каренина':");
        System.out.println(library.findBook("Анна Каренина", "Толстой Л.Н.", 1877));

        System.out.println("Удаление книги 'Идиот':");
        library.removeBook("Идиот", "Достоевский Ф.М.", 1874);
        library.printAllBooks();

        System.out.println("Поиск удаленной книги 'Идиот':");
        System.out.println(library.findBook("Идиот", "Достоевский Ф.М.", 1874));
    }
}
