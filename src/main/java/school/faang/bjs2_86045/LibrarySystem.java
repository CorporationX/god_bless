package school.faang.bjs2_86045;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    // 3️⃣ В классе LibrarySystem создайте HashMap с ключом типа Book и значением типа String
    // (местонахождение книги в библиотеке, например, номер полки).
    private static Map<Book, String> bookLocation = new HashMap<>();

    // 4️⃣ Реализуйте следующие методы в классе LibrarySystem:
    // добавляет новую книгу с её местонахождением в библиотеке.
    public static void addBook(String title, String author, int year, String location) {
        bookLocation.put(new Book(title, author, year), location);
    }

    // удаляет книгу из библиотеки по её названию, автору и году издания.
    public static void removeBook(String title, String author, int year) {
        if (bookLocation.containsKey(new Book(title, author, year))) {
            bookLocation.remove(new Book(title, author, year));
            System.out.println("Removed Book: " + new Book(title, author, year));
        } else {
            System.out.println("Book not found");
        }

    }

    // ищет книгу по названию, автору и году издания и выводит информацию о её местонахождении в библиотеке.
    // Если книга не найдена, метод должен сообщить об этом.
    public static void findBook(String title, String author, int year) {
        String location;
        if (bookLocation.get(new Book(title, author, year)) == null) {
            location = "not found";
        } else {
            location = bookLocation.get(new Book(title, author, year));
        }
        System.out.println(new Book(title, author, year) + " location: " + location);
    }

    // выводит полный список всех книг в библиотеке и их местонахождение
    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    // + Тестируйте вашу программу, вызывая различные методы класса LibrarySystem, и убедитесь, что она работает
    // корректно, учитывая переопределенные методы equals и hashCode.
}
