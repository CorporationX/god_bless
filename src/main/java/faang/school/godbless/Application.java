package faang.school.godbless;

import faang.school.godbless.domain.User;
import faang.school.godbless.domain.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Application {

    public static Map<Book, String> mapBook = new HashMap<>();

    public static void main(String[] args) {


        mapBook.put(new Book("Capital", "Karl Marx", 1890), "2");
        mapBook.put(new Book("Mother", "Maksim Gorkyi", 1920), "3");
        mapBook.put(new Book("Idiot", "Dostaevski", 1902), "4");

        Book oneBook = new Book("Auditor", "Gogol", 1910);
        addBook(oneBook, "5");
        removeBook("Idiot", "Dostaevski", 1902);
        getBook("Capital", "Karl Marx", 1890);
        printAll();


    }

    public static void addBook(Book book, String number) {
        mapBook.put(new Book(book.title(), book.author(), book.year()), number);
    }

    public static void removeBook(String title, String author, int year) {
        mapBook.remove(new Book(title, author, year));
    }

    public static void getBook(String title, String author, int year) {
        System.out.println(mapBook.get(new Book(title, author, year)));
    }

    public static void printAll() {
        mapBook.forEach((book, num) -> System.out.println(book.toString() + ":" + num));

    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activitys) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {

            for (String activity : user.getActivitys()) {
                if (activitys.contains(activity)) {
                    map.put(user, activity);
                    break;
                }
            }
        }

        return map;

    }
}
