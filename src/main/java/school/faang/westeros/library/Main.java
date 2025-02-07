package school.faang.westeros.library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        System.out.println("\nНаполняем библиотеку новыми книгами!");
        library.addBook("HP and the Philosopher’s Stone", "J.K.Rowling", 1997, "#1");
        library.addBook("HP and the Chamber of Secrets", "J.K.Rowling", 1998, "#2");
        library.addBook("HP and the Prisoner of Azkaban", "J.K.Rowling", 1999, "#3");
        library.addBook("HP and the Goblet of Fire", "J.K.Rowling", 2000, "#4");
        library.addBook("HP and the Order of the Phoenix", "J.K.Rowling", 2003, "#4");
        library.addBook("HP and the Half-Blood Prince", "J.K.Rowling", 2005, "#1");
        library.printAllBooks();
        System.out.println("\nУдаляем лишние книги!");
        library.removeBook("HP and the Prisoner of Azkaban", "J.K.Rowling", 1999);
        library.removeBook("HP", "J.K.Rowling", 1999);
        System.out.println("\nПоиск книг!");
        library.findBook("HP and the Order of the Phoenix", "J.K.Rowling", 2003);
        library.findBook("HP and the Order of the Phoenix", "J.K.Rowling", 2020);
        library.printAllBooks();
    }
}
