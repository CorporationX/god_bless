package school.faang.sprint1.bjs245364;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.getBooks().put(new Book("Поэзия XX века", "А. С. Пушкин", 1911), "001");
        library.getBooks().put(new Book("Преступление и наказание", "Ф. М. Достоевский", 1915), "001");
        library.getBooks().put(new Book("Искусство как наука", "Меллер", 1813), "020");
        library.getBooks().put(new Book("История древнего мира", "Платон", 89), "001");
        library.getBooks().put(new Book("Риторика", "Аристотель", 15), "195");

        String shelfForNewBook = "003";
        library.addBook("Новая книга", "Виктор Гюго", 2024, shelfForNewBook, library.getBooks());
        library.removeBook("Поэзия XX века", "А. С. Пушкин", 1911, library.getBooks());
        library.findBook("Риторика", "Аристотель", 15, library.getBooks());
        library.printAllBooks(library.getBooks());
    }
}
