package faang.school.godbless.BJS2_4561;

import java.util.Map;

public class ActionOnBook {
    public static void addNewBook(String myHouse, String anton, int year, Map<Book, String> bookMap,  String position){
        Book newBook = new Book(myHouse, anton, year);

        bookMap.put(newBook, position);
    }

    public static void deleteBook(Book book, Map<Book, String> bookMap){
        bookMap.remove(book);
    }

    public static void searchBook(Book book, Map<Book, String> bookMap){
        System.out.println("Книга: " + book.getTitle() + ", Расположение: " + bookMap.get(book));
        System.out.print("\n");
    }

    public static void printAllBook(Map<Book, String> bookMap){
        for (Map.Entry<Book, String> book : bookMap.entrySet()){
            System.out.println("Название: " + book.getKey().getTitle() + ", Расположение: " + book.getValue());
        }
        System.out.print("\n");
    }
}
