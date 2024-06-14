package faang.school.godbless;

import lombok.NonNull;

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

        getInfoLocationBook(new Book("Анна Каренина", "Л.Н.Толстой", 1873));

        deleteBook(new Book("Анна Каренина", "Л.Н.Толстой", 1873));
        addNewBook(new Book("Евгений Онегин", "А.С.Пушкин", 1967), "Шкаф №6");
        getFullInfo();
    }

    public static void addNewBook(@NonNull Book newBook, String location) {
            manual.put(newBook, location);
    }

    public static void deleteBook(@NonNull Book book) {
            manual.remove(book);
    }

    public static void getInfoLocationBook(@NonNull Book book) {
        System.out.println(manual.getOrDefault(book, "Книги нету в справочнике"));
    }


    public static void getFullInfo() {
        manual.forEach((key, value) -> System.out.println(key + " Расположение: " + value));
    }
}
