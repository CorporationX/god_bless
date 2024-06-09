package faang.school.godbless.vesteros_library;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public record Book(String title, String author, int year) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    //добавление новой книги и её местонахождения в библиотеке
    public static void addNewBook(Book book, String shelf, HashMap<Book, String> books) {
        //проверка наличия книги в библиотеке
        if (books.containsKey(book)) {
            System.out.println("Такая книга уже есть в библиотеке\n");
        } else {
            //внесение книги в библиотеку на первую полку
            books.put(book, shelf);
            System.out.println("Книга " + book + " внесена в библиотеку на полку " + shelf+"\n");
        }
    }

    //удаление книги по её названию, автору и году издания
    public static void deleteBookByItsTitleAuthorYear(String title,
                                               String author,
                                               int year,
                                               HashMap<Book, String> books) {
        Book bookForDeleting = new Book(title, author, year);//создаём книгу, которую надо удалить

        for (Map.Entry<Book, String> bookEntry : books.entrySet()) {
            Book book = bookEntry.getKey();
            if (book.equals(bookForDeleting)) {
                books.remove(book);
                System.out.println("Книга " + bookForDeleting + " успешно удалена из библиотеки!\n");
                return;
            }
        }
        System.out.println("Такой книги нет в библиотеке.\n");
    }

    //поиск книги и вывода информации о её местонахождении в библиотеке, используя название книги,
    // автора и год издания
    public static void findBookPlaceByTitleAuthorYear(String title,
                                               String author,
                                               int year,
                                               HashMap<Book, String> books) {
        //создаём книгу, у которой надо найти её место в библиотеке
        Book bookToFindItsPlace = new Book(title, author, year);
        for (Map.Entry<Book, String> booksEntry :
                books.entrySet()) {
            Book book = booksEntry.getKey();
            if (book.equals(bookToFindItsPlace)) {
                System.out.println("Книга "+book+" находится на полке " + booksEntry.getValue());
                return;
            }
        }
        System.out.println("Такой книги нет в библиотеке.");
    }

    // вывод списка всех книг и их местонахождения в библиотеке
    public static void getAllBooksAndItsPlaces(HashMap<Book, String> books) {
        for (Map.Entry<Book, String> booksEntry :
                books.entrySet()) {
            System.out.println("Книга " + booksEntry.getKey() + " находится на полке "
                    + booksEntry.getValue()+"\n");
        }
    }
}

