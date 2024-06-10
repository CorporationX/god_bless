package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> manual = new HashMap<>();

    static {
        manual.put(new Book("Человек в футляре", "А.П.Чехов", 1898), "В шкафу \"А\" на 4 полке");
        manual.put(new Book("Анна Каренина", "Л.Н.Толстой", 1873), "На складе");
        manual.put(new Book("Мертвые души", "Н.В.Гоголь", 1852), "Сгорела");
    }

    public static void main(String[] args) {
        getFullInfo();
        System.out.println();

        getInfoLocationBook("Анна Каренина", "Л.Н.Толстой", 1873);
        System.out.println();

        deleteBook("Анна Каренина", "Л.Н.Толстой", 1873);
        addNewBook(new Book("Евгений Онегин", "А.С.Пушкин", 1967), "Шкаф №6");
        getFullInfo();
    }

    public static void addNewBook(Book newBook, String location) {
        if (newBook != null && location != null)
            manual.put(newBook, location);
        else
            System.out.println("Переданны пустые данные");
    }

    public static void deleteBook(String name, String author, int years) {
        if (name != null && author != null) {
            Book deleteBook = new Book(name, author, years);
            if (manual.containsKey(deleteBook))
                manual.remove(deleteBook);
            else
                System.out.println("Книга не найдена");
        } else {
            System.out.println("Переданны пустые данные");
        }
    }

    public static void getInfoLocationBook(String name, String author, int years) {
        if (name != null && author != null) {
            Book searchBook = new Book(name, author, years);
            if (manual.containsKey(searchBook))
                System.out.println(manual.get(searchBook));
            else
                System.out.println("Книга не найдена");
        } else {
            System.out.println("Переданны пустые данные");
        }
    }

    public static void getFullInfo() {
        for (Map.Entry<Book, String> info : manual.entrySet()) {
            System.out.println(info.getKey() + " Расположение: " + info.getValue());
        }
    }
}
