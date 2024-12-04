package school.faang.task45283;

import java.util.Map;

public class LibrarySystem {
    public static void addBook(String title, String author, int year, String location) {
        Main.getBooks().put(new Book(title,author,year), location);
    }
    public static boolean removeBook(String title, String author, int year){
        Book book = new Book(title, author, year);
        return Main.getBooks().remove(book) != null;
    }
    public static String findBook (String title, String author, int year){
        Book book = new Book(title, author, year);
        return Main.getBooks().getOrDefault(book, "Данная книга отсутсвует");
    }
    public static void printAllBooks(){
        for (Map.Entry<Book, String> entry : Main.getBooks().entrySet()){
            System.out.println("Книга " + entry.getKey().getTitle() + ", автор " + entry.getKey().getAuthor() +
                    ", год издания " + entry.getKey().getYear() + " - лежит на полке №" + entry.getValue());
        }
    }
}
