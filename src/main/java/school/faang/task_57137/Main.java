package school.faang.task_57137;

public class Main {
    public static void main(String[] args) {
        LibrarySystem bookLocation = new LibrarySystem();

        bookLocation.addBook("Война и Мир", "Лев Толстой", 1863, "q4");
        bookLocation.addBook("Горе от ума", "Александр Сергеевич Грибоедов", 1824, "s64");
        bookLocation.addBook("Фауст", "Иван Сергеевич Тургенев", 1855, "s64");
        bookLocation.addBook("Левша", "Николай Семенович Лесков", 1881, "t86");

        bookLocation.printAllBooks();

        bookLocation.removeBook("Фауст", "Иван Сергеевич Тургенев", 1855);
        bookLocation.printAllBooks();

        bookLocation.findBook("Горе от ума", "Александр Сергеевич Грибоедов", 1824);

    }
}
