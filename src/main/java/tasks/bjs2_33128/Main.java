package tasks.bjs2_33128;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = getBooks();
        Library library = new Library(books);
        library.showBooks();
        library.removeBookByTitle("Война и мир");
        library.removeBookByTitle("Анна Каренина");
        library.removeBookByAuthor("Фёдор Достоевский");
        library.removeBookByYear(1185);
        library.showBooks();
        library.addBook("Три товарища", "Эрих Мария Ремарк", 1936);
        library.addBook("Сто лет одиночества", "Габриэль Гарсиа Маркес", 1967);
        library.addBook("Замок", "Франц Кафка", 1926);
        library.addBook("Цветы для Элджернона", "Дэниел Киз", 1966);
        library.addBook("Шантарам", "Грегори Дэвид Робертс", 2003);
        library.showBooks();
    }

    public static List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book("Война и мир", "Лев Толстой", -1));
        books.add(new Book("", "Джордж Оруэлл", 1949));
        books.add(new Book("О дивный новый мир", " ", 1932));
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1940));
        books.add(new Book("Анна Каренина", "Лев Толстой", 1877));
        books.add(new Book("Братья Карамазовы", "Фёдор Достоевский", 1880));
        books.add(new Book("Собачье сердце", "Михаил Булгаков", 1925));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Герой нашего времени", "Михаил Лермонтов", 1840));
        books.add(new Book("Слово о полку Игореве", "Неизвестный автор", 1185));
        books.add(new Book("Двенадцать стульев", "Илья Ильф и Евгений Петров", 1928));
        books.add(new Book("Золотой теленок", "Илья Ильф и Евгений Петров", 1931));
        books.add(new Book("Мы", "Евгений Замятин", 1920));

        return books;
    }
}
