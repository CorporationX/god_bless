package school.faang.BJS233103;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static BookService bookService = new BookServiceImpl();

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Думай и богатей", "Наполеон Хилл", 1937));
        books.add(new Book("Алхимик", "Пауло Коэльо", 1988));
        books.add(new Book("Осень в карманах", "Андрей Аствацатуров", 2015));
        books.add(new Book("Светила", "Элеанор Каттон", 2020));

        for (Book book : books) {

            bookService.getBooks().put(book, bookService.generatePlace());
        }

        bookService.printBooks();
        bookService.addBook("New Age", "Christian Something", 2019);
        bookService.deleteBookByTitle("Светила", "Элеанор Каттон", 2020);
        bookService.findBook("Думай и богатей", "Наполеон Хилл", 1937);
        bookService.printBooks();
    }

}
