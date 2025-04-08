package school.faang.bjs2_68771;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Евгение Онегин", "Пушкин А.С.", 1823, "стеллаж 1");
        librarySystem.addBook("Сказка о царе Салтане", "Пушкин А.С.", 1831, "стеллаж 2");
        librarySystem.addBook("Сказка о мёртвой царевне и о семи богатырях", "Пушкин А.С.", 1833, "стеллаж 1");
        librarySystem.addBook("Капитанская дочка", "Пушкин А.С.", 1836, "стеллаж 2");
        librarySystem.addBook("Герой нашего времени", "Лермонтов М.С.", 1838, "стеллаж 1");
        librarySystem.addBook("Княгиня Лиговская", "Лермонтов М.С.", 1836, "стеллаж 2");
        System.out.println(librarySystem.printAllBooks());
        System.out.println("-------");
        try {
            System.out.println(
                librarySystem.findBook("Сказка о мёртвой царевне и о семи богатырях", "Пушкин А.С.", 1833)
            );
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        try {
            System.out.println(
                librarySystem.findBook("Сказка о живой царевне и о семи богатырях", "Пушкин А.С.", 1833)
            );
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        System.out.println("-------");
        librarySystem.removeBook("Сказка о мёртвой царевне и о семи богатырях", "Пушкин А.С.", 1833);
        librarySystem.removeBook("Сказка о живой царевне и о семи богатырях", "Пушкин А.С.", 1833);
        System.out.println(librarySystem.printAllBooks());
    }
}
