package school.faang.HashMap1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

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

    // 1.Добавление новой книги
    public static void addBook(Book newBook, String place, Map<Book, String> library){
        library.put(newBook, place);
    }

    // 2.Удаление по названию, автору и году
    public static void deleteBook(String title, String author, int year, Map<Book, String> library){
        library.remove(new Book(title, author, year));
    }

    // поиск книги и вывод её местонахождения по названию, автору и году
    public static void searchBook(String title, String author, int year, Map<Book, String> library){
        Book book = new Book(title, author, year);
        if(library.get(book) != null){
            System.out.println(book.getTitle() + " находится на полке №" + library.get(book));
        } else {
            System.out.println("Книга: " + book.getTitle() + " не найдена.");
        }
    }

    //перегрузка для метода allBooksInfo
    public static void searchBook(Book book, Map<Book, String> library){
        System.out.println(book.getTitle() + " находится на полке №" + library.get(book));
    }

    //Вывод списка всех книг и местонахождения
    public static void allBooksInfo(Map<Book, String> library){
        for (Map.Entry<Book, String> entry: library.entrySet()){
            searchBook(entry.getKey(), library);
        }
    }
}
