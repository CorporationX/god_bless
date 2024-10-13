package school.faang.westerosLibrary;

public class Main {
  public static void main(String[] args) {

    Book book1 = new Book("fist book", "Nikita", 23);
    Book book2 = new Book("second book", "Katia", 24);
    Book book3 = new Book("third book", "Alice", 16);


    Library library = new Library();
    library.addNewBook(book1, "верхняя полка");
    library.addNewBook(book2, "нижняя полка");
    library.addNewBook(book3, "средняя полка");

    System.out.println(library.getAllBook());
    System.out.println("==================");
    System.out.println("search third book " + library.searchBook("third book", "Alice", 16));
    System.out.println("==================");
    System.out.println("delete first book " + library.deleteBook("fist book", "Nikita", 23));
    System.out.println("==================");
    System.out.println("search first book " + library.searchBook("second book", "Katia", 24));
    System.out.println("==================");
    System.out.println(library.getAllBook());
  }
}
