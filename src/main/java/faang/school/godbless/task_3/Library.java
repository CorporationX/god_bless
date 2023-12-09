package faang.school.godbless.task_3;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@NoArgsConstructor
public class Library {
    private Book book;
    private String rackInLibrary;

    private final Map<Book, String> booksInLibrary = new HashMap<>();

    public void addBookInLibrary(Book book, String rackInLibrary){
        if(!booksInLibrary.containsKey(book)){
            booksInLibrary.put(book, rackInLibrary);
        } else {
            System.out.println("This book is already in the library");
        }
    }
    public void removeBookInLibrary(Book book){
        if(booksInLibrary.containsKey(book)){
            booksInLibrary.remove(book);
            System.out.println("Remove from library: " + book.getTittle() +'\n');
        } else {
            System.out.println("There is no such book in the library");
        }
    }
    public void searchBookInLibrary(Book book){
        if(booksInLibrary.containsKey(book)){
            System.out.println("Find book: " + book.getTittle() + " - " + booksInLibrary.get(book));
        } else {
            System.out.println("Book: " + book.getTittle() + " there is no such in the library");
        }
        System.out.println();
    }
    public void getAllBooksInLibrary(){
        booksInLibrary.forEach((key, value) -> System.out.println(key.getTittle() + " - " + value));
        System.out.println();
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(book, library.book) && Objects.equals(rackInLibrary, library.rackInLibrary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, rackInLibrary);
    }

    @Override
    public String toString() {
        return "Library{" +
                "book=" + book.getTittle() +
                ", rackInLibrary='" + rackInLibrary + '\'' +
                '}';
    }
}
