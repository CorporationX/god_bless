package school.faang.bjs2_86260_1_1_3_1_vesteros_library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("Война и мир", "Лев Толстой", 1869, "Зал 1, Полка 3");
        library.addBook("Преступление и наказание", "Фёдор Достоевский", 1866, "Зал 2, Полка 5");
        library.addBook("Мастер и Маргарита", "Михаил Булгаков", 1967, "Зал 1, Полка 7");
        library.addBook("Анна Каренина", "Лев Толстой", 1878, "Зал 3, Полка 2");

        System.out.println("📚 Все книги:");
        library.printAllBooks();

        System.out.println("\n🔍 Поиск книги 'Мастер и Маргарита':");
        System.out.println(library.findBook("Мастер и Маргарита", "Михаил Булгаков", 1967));

        System.out.println("\n Удаляем 'Анна Каренина'...");
        library.removeBook("Анна Каренина", "Лев Толстой", 1878);

        System.out.println("\n📚 Все книги после удаления:");
        library.printAllBooks();
    }

}
