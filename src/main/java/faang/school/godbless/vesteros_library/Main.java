package faang.school.godbless.vesteros_library;

import java.util.HashMap;

public class Main {

    private static final HashMap<Book, String> BOOKS = new HashMap<>();
    private static final Book VOINA_I_MIR = new Book("Война и мир", "Толстой Л.Н.", 2001);
    private static final Book MCIRY = new Book("Мцири", "Лермонтов М.Ю.", 2002);
    private static final Book PREST_I_NAKAZ = new Book("Преступление и наказание", "Достоевский Ф.",
            2003);
    private static final Book PETER_FIRST = new Book("Пётр I", "Толсной А.Н.", 1999);

    public static void main(String[] args) {

        BOOKS.put(VOINA_I_MIR, "1");
        BOOKS.put(MCIRY, "2");
        BOOKS.put(PREST_I_NAKAZ, "3");

        Book.getAllBooksAndItsPlaces(BOOKS);
        System.out.println();
        Book.addNewBook(MCIRY, "4", BOOKS);
        Book.getAllBooksAndItsPlaces(BOOKS);
        System.out.println();
        Book.addNewBook(PETER_FIRST, "4", BOOKS);
        Book.getAllBooksAndItsPlaces(BOOKS);
        System.out.println();
        Book.deleteBookByItsTitleAuthorYear("Мцири", "Лермонтов М.Ю.", 2002, BOOKS);
        Book.getAllBooksAndItsPlaces(BOOKS);
        System.out.println();
        Book.findBookPlaceByTitleAuthorYear("Пётр I", "Толсной А.Н.", 1999, BOOKS);
    }

}
