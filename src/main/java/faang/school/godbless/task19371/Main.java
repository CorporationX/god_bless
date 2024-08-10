package faang.school.godbless.task19371;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> library;


    public static void putNewBook(Book book, String place){
        library.put(book,place);
    }

    public static String  removeBook(String title, String author, int year){
        Book book = new Book(title, author,year);
        if(library.containsKey(book)){
            library.remove(book);
            return "Книга удалена";
        } else return "Книга не найдена";
    }

    public static String findPlaceOfBook(Book book){
        return library.get(book);
    }

    public static Map<Book, String> getAllBooks(){
        return library;
    }

    public static void main(String[] args) {
        library = new HashMap<>();
        library.put(new Book("Над пропастью во ржи", "Девид Селинджер", 1986), "ряд 1, полка 4");
        library.put(new Book("Цветы для Элджернона", "Дениел Киз", 1959), "ряд 2, полка 5");

        putNewBook(new Book("Три товарища", "Эрих Мария Ремарк", 1939), "ряд 3, полка 6");
        System.out.println(findPlaceOfBook(new Book("Цветы для Элджернона", "Дениел Киз", 1959)));
        System.out.println(removeBook("Цветы для Элджернона", "Дениел Киз", 1959));
        System.out.println(getAllBooks());

    }


}
