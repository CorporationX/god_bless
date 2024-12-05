package school.faang.task_43520;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Тень и кость", "Ли Бардуго", 2018, "1A");
        librarySystem.addBook("Перси Джексон", "Рик Риордан", 2009, "3С");
        librarySystem.addBook("Бегущий в лабиринте", "Джеймс Дашнер", 2005, "4K");
        librarySystem.addBook("Королевство шипов и роз", "Сара Маас", 2019, "4A");
        librarySystem.addBook("Правление волков", "Ли Бардуго", 2021, "1B");
        librarySystem.printAllBooks();
        System.out.println();

        librarySystem.findBook("Тень и кость", "Ли Бардуго", 2018);
        librarySystem.removeBook("Тень и кость", "Ли Бардуго", 2018);
        librarySystem.findBook("Тень и кость", "Ли Бардуго", 2018);
        System.out.println();

        librarySystem.addBook("Четвертое крыло", "Ребекка Яррос", 2023, "2F");
        librarySystem.printAllBooks();
    }
}
