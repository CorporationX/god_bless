package school.faang.BJS2_33089;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Book A", "Author A", 1678), "Shelf A");
        library.addBook(new Book("Book B", "Author B", 1799), "Shelf B");
        library.addBook(new Book("Book C", "Author C", 1825), "Shelf C");
        System.out.println();

        //смотрим какие книги умеются на данный момент в библеотеке
        library.getAllBooks();
        System.out.println();

        //добавляем еще одну книгу
        library.addBook(new Book("Book D", "Author D", 1465), "Shelf D");
        System.out.println();

        //смотрим на изменения
        library.getAllBooks();
        System.out.println();

        //далее происводим поиск книг по их полям
        System.out.println(library.findBook("Book D"));
        System.out.println(library.findBook("Author A"));
        System.out.println(library.findBook(1799));
        System.out.println();

        //удаляем книги
        library.deleteBook("Book D");
        library.deleteBook("Author B");
        library.deleteBook(1825);

        //пытаемся удалить книгу которой уже нет в списке
        library.deleteBook("Author D");
        System.out.println();

        //и снова проверяем список книг
        library.getAllBooks();
    }
}
