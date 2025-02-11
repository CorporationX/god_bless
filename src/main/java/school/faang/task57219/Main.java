package school.faang.task57219;

import school.faang.task57219.library.LibrarySystem;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        System.out.println(librarySystem.addBook("Вокруг света в 80 дней", "Жюль Верн", 1872, "Полка №1"));
        System.out.println(librarySystem.addBook("В зоне тумана", "Алексей Гравицкий", 2009, "Полка №2"));
        System.out.println(librarySystem.addBook(null, "", 2009, "Полка №2"));
        System.out.println(librarySystem.addBook("Грокаем алгоритмы", "Адитья Бхаргава", 2022, "Полка №3"));
        System.out.println(librarySystem.addBook("Грокаем алгоритмы", "Адитья Бхаргава", 2022, "Полка №3"));
        System.out.println(librarySystem.findBook("В зоне тумана", "Алексей Гравицкий", 2009));
        System.out.println(librarySystem.findBook("Тренируй свой мозг", "Рюта Кавашима", 2022));
        System.out.println(librarySystem.findBook("", null, 2020));
        System.out.println(librarySystem.removeBook("В зоне тумана", "Алексей Гравицкий", 2009));
        librarySystem.printAllBooks();
    }
}
