package school.faang.bjs2_86153;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
public class LibrarySystem {
    private HashMap<Book, String> bookLocation;

    public LibrarySystem(HashMap<Book, String> bookLocation) {
        this.bookLocation = bookLocation;
    }

    public void addBook(String title, String author, int year, String location) {
       bookLocation.put(new Book(title, author, year), location);
        System.out.println("Книга была добавлена на полку");

   }

   public void removeBook(String title, String author, int year) {
       bookLocation.remove(new Book(title, author, year));
       System.out.println("Вы убрали книгу с полки");
   }

   public void findBook(String title, String author, int year) {
       if (bookLocation.containsKey(new Book(title, author, year))) {
           System.out.println("Местонахождение книги - " + bookLocation.get(new Book(title, author, year)));
       } else  {
           System.out.println("Книга не найдена");
       }
   }

   public void printAllBooks() {
       for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
           System.out.println("Book: " + entry.getKey() +", местонахождение, " + entry.getValue());
       }
   }
}
