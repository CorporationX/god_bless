package school.faang;

public class Main {
    public static void main(String[] argc) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("На западном фронте без перемен", "Эрих Мария Ремарк", 1928, "A2");
        library.addBook("Триумфальная Арка", "Эрих Мария Ремарк", 1945, "A3");
        library.addBook("Черный Обелиск", "Эрих Мария Ремарк", 1956, "A4");
        library.addBook("Три товарища", "Эрих Мария Ремарк", 1936, "A5");
        //
        //        library.printAllBooks();
        //
        //        System.out.println(library.findBook("Три товарища",
        //                "Эрих Мария Ремарк", 1936));
        //        System.out.print('\n');
        //
        //
        //        library.removeBook("Три товарища", "Эрих Мария Ремарк",
        //                1936);
        //
        //        System.out.println(library.findBook("Войны и мир", "Лев Толстой", 1863));
        //
        library.printAllBooks();
    }
}
