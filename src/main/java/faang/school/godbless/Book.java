package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {
    private static void removeBook(Map<Book, String>map, String title, String author, Integer year) {
        Book bookRemove = new Book(title, author, year);

        map.remove(bookRemove);

    }
    @Getter
    @Setter
    private String title;
    @Setter
    @Getter
    private String author;
    @Getter
    @Setter
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }


    public static void main(String[] args) {
        Map<Book, Integer> map=new HashMap<>();
        //
        Book book1=new Book("Маленький принц","Экзюпери", 1965);
        Book book2=new Book("Атлант расправил плечи","Айн Ренд", 1957);
        Book book3=new Book("Преступление и Наказание","Достоевский", 1866);
        Book book4=new Book("Война и мир","Толстой", 1863);
        Book book5=new Book("Раковые яйца","Булгакова", 1924);
        //добавление
        map.put(book1, 12);
        map.put(book2, 65);
        map.put(book3, 78);
        map.put(book4, 787);
        map.put(book5, 1224);
        //удаление
        map.remove("Маленький принц");
        map.remove("Айн Ренд");

        removeBook("Маленький принц","Экзюпери", 1965);
        //получение данных по названию
        map.get("Война и мир");
        map.get("Атлант расправил плечи");

        //
    }




}
