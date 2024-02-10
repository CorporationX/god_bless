package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> map = new HashMap<>();
        //
        Book book1 = new Book("Маленький принц", "Экзюпери", 1965);
        Book book2 = new Book("Атлант расправил плечи", "Айн Ренд", 1957);
        Book book3 = new Book("Преступление и Наказание", "Достоевский", 1866);
        Book book4 = new Book("Война и мир", "Толстой", 1863);
        Book book5 = new Book("Раковые яйца", "Булгакова", 1924);

        //добавление
        map.put(book1, "B");
        map.put(book2, "A");
        map.put(book3, "C");
        map.put(book4, "D");
        map.put(book5, "E");

        //удаление
        //map.remove("Маленький принц");
        //map.remove("Айн Ренд");

        removeBook("Маленький принц", "Экзюпери", 1965);
        //получение данных по названию
        map.get("Война и мир");
        map.get("Атлант расправил плечи");

        //
    }
    private static void removeBook(Map<Book, String>map, String title, String author, Integer year) {
        Book bookRemove = new Book(title, author, year);

        map.remove(bookRemove);

    }




}
