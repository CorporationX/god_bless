package school.faang.bjs2_86142;

public class Main {

    private static final String FIRST_LOCATION = "Vesteros";
    private static final String SECOND_LOCATION = "Sortesev";

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("Echoes of Tomorrow", "Lena Voronina", 2021, SECOND_LOCATION);
        library.addBook("The Last Equation", "Maxim Petrov", 2018, SECOND_LOCATION);
        library.addBook("Beneath the Ice", "Irina Sokolova", 2023, FIRST_LOCATION);
        library.addBook("The Clockmaker's Secret", "Natalia Zaitseva", 2020, SECOND_LOCATION);
        library.addBook("Letters to Orion", "Dmitry Karpov", 2015, FIRST_LOCATION);

        library.removeBook("Echoes of Tomorrow", "Lena Voronina", 2021);
        library.removeBook("fjkgh", "fnhgjd", 2222);

        library.findBook("Letters to Orion", "Dmitry Karpov", 2015);
        library.findBook("fjkgh", "fnhgjd", 2222);

        library.printAllBooks();
    }
}
