package school.faang.task56935.service;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("Детектив века", "Агата Кристи", 1975, "секция Детективы, полка № 4");
        library.addBook("Война и мир", "Лев Толстой", 1869, "стеллаж А, полка 2");
        library.addBook("Марсианин", "Энди Вейер", 2011, "секция Sci-Fi, ряд 3");
        library.addBook("Так говорил Заратустра", "Фридрих Ницше", 1883, "зал философии, шкаф 5");
        library.addBook("Краткая история времени", "Стивен Хокинг", 1988, "научный отдел, полка 1");

        library.printAllBooks();
        library.removeBook("Детектив века", "Агата Кристи", 1975);
        System.out.println("После удаления");
        library.printAllBooks();
        System.out.println("Ищем книгу---" +
                library.findBook("Краткая история времени", "Стивен Хокинг", 1988));
    }
}