package school.faang.task_57137;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("Война и Мир", "Лев Толстой", 1863, "q4");
        library.addBook("Горе от ума", "Александр Сергеевич Грибоедов", 1824, "s64");
        library.addBook("Фауст", "Иван Сергеевич Тургенев", 1855, "s64");
        library.addBook("Левша", "Николай Семенович Лесков", 1881, "t86");

        library.printAllBooks();

        library.removeBook("Фауст", "Иван Сергеевич Тургенев", 1855);
        library.printAllBooks();

        library.findBook("Горе от ума", "Александр Сергеевич Грибоедов", 1824);

    }
}
