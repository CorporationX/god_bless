package school.faang.bjs2_86060;

public class Main {
    public static void main(String[] args) {
        try {

            System.out.println("Добавление книг");
            LibrarySystem library = getLibrarySystem();

            System.out.println("\nУдаление книг");
            library.removeBook("Поколение П", "Виктор Пелевин", 1999);
            library.removeBook("Архитектура cложных веб приложений", "Адель Файзрахманов", 2020);
            library.removeBook("Не найдена книга", "Рэй Дуглас Бредбери", 1953);

            System.out.println("\nПоиск книг");
            System.out.println(library.findBook("Чистый код", "Роберт Мартин", 2008));
            System.out.println(library.findBook("Архитектура cложных веб приложений", "Адель Файзрахманов", 2020));

            System.out.println("\nВывод всех книг");
            library.printAllBooks();

        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static LibrarySystem getLibrarySystem() {
        LibrarySystem library = new LibrarySystem();

        try {
            library.addBook("Поколение П", "Виктор Пелевин", 1999, "Полка 1");
            library.addBook("О дивный новый мир", "Олдос Хаксли", 1946, "Полка 2");
            library.addBook("1984", "Джордж Оруэл", 1932, "Полка 1");
            library.addBook("451 градус по фаренгейту", "Рэй Дуглас Бредбери", 1953, "Полка 1");
            library.addBook("Чистый код", "Роберт Мартин", 2008, "Полка 2");
            library.addBook("Архитектура cложных веб приложений", "Адель Файзрахманов", 2020, "Полка 3");
            library.addBook("Краткие ответы на большие вопросы", "Стивен Хкоинг", 2018, "Полка 3");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при инициализации библиотеки: " + e.getMessage());
            throw e;
        }

        return library;
    }
}
