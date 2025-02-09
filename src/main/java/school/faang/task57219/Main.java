package school.faang.task57219;

import school.faang.task57219.library.LibrarySystem;

public class Main {
    public static void main(String[] args) {
        LibrarySystem.addBook("Вокруг света в 80 дней", "Жюль Верн", 1872, "Полка №1");
        LibrarySystem.addBook("В зоне тумана", "Алексей Гравицкий", 2009, "Полка №2");
        LibrarySystem.addBook("Грокаем алгоритмы", "Адитья Бхаргава", 2022, "Полка №3");
        LibrarySystem.findBook("В зоне тумана", "Алексей Гравицкий", 2009);
        LibrarySystem.findBook("Тренируй свой мозг", "Рюта Кавашима", 2022);
        LibrarySystem.removeBook("В зоне тумана", "Алексей Гравицкий", 2009);
        LibrarySystem.printAllBooks();
    }
}
