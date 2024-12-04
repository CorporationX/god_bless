package school.faang.task_45300;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Book, String> booksMap = new HashMap<>();
        Book book1 = new Book("Война и Мир", "Толстой", 2000);
        Book book2 = new Book("Евгений Онегин", "Пушкин", 2002);
        Book book3 = new Book("Отцы и дети", "Достоевский", 2000);
        Book book4 = new Book("Вий", "Горький", 2001);

        booksMap.put(book1, "15");
        booksMap.put(book2, "10");
        booksMap.put(book3, "12");
        booksMap.put(book4, "12");

        Book bookForSearch = new Book("Евгений Онегин", "Пушкин", 2002);

        System.out.println("Книга находится на полке: " + booksMap.get(bookForSearch));

        System.out.println(booksMap);
        booksMap.replace(book4, "22");
        System.out.println(booksMap);
    }
}
