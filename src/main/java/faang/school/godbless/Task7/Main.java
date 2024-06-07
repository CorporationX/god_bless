package faang.school.godbless.Task7;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void addToMap(Book newbook, String shelf, Map<Book, String> library) {
        library.put(newbook, shelf);
    }

    public static void main(String[] args) {

        Map<Book, String> library = new HashMap<>();
        Book calculus = new Book("Calculus", "Zoric", 2023);
        Book algebra = new Book("Algebra", "Kostrikin", 2000);
        Book geometry = new Book("Geometry", "Tuzhilin", 2006);
        library.put(calculus, "shelf1");
        library.put(algebra, "shelf2");
        library.put(geometry, "shelf3");
        System.out.println(library);
        Book combinatorics = new Book("combinatorics", "Alekseev", 2002);
        addToMap(combinatorics, "shelf4", library);
        System.out.println(library);
    }
}
