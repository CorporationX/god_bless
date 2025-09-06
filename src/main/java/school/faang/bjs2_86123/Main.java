package school.faang.bjs2_86123;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Преступление и наказание", "Достоевский", 1866, "Романы");
        librarySystem.addBook("Война и мир", "Толстой", 1867, "Романы");
        librarySystem.addBook("Маленький принц", "Экзюпери", 1943, "Для детей");
        librarySystem.printALlBooks();
        System.out.println("+++++++++++++++");
        librarySystem.removeBook("Война и мир", "Толстой", 2025);
        librarySystem.printALlBooks();
        System.out.println("+++++++++++++++");
        librarySystem.removeBook("Война и мир", "Толстой", 1867);
        librarySystem.printALlBooks();
        System.out.println("+++++++++++++++");
        librarySystem.findBook("Война и мир", "Толстой", 1867);
        librarySystem.findBook("Маленький принц", "Экзюпери", 1943);
    }
}
