package school.faang.sprint1.task_BJS2_56941;

import java.lang.reflect.Proxy;

public class Main {
    private static final int minYear = 0;
    private static final int maxYear = 2025;
    private static Library librarySystem;

    public static void main(String[] args) {
        Library origin = new LibrarySystem();
        ClassLoader classLoader = origin.getClass().getClassLoader();
        Class<?>[] interfaces = origin.getClass().getInterfaces();
        TestInvocationHandler invocationHandler = new TestInvocationHandler(origin);
        librarySystem = (Library) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);


        System.out.println("addBook корректные данные");
        librarySystem.addBook("one", "someAuthor", 1990, "shelf1");
        librarySystem.addBook("two", "SomeOneElseAuthor", minYear, "shelf2");
        librarySystem.addBook("three", "AnotherAuthor", maxYear, "shelf3");
        System.out.println("----------");

        System.out.println("addBook empty title");
        librarySystem.addBook("", "someAuthor", 1990, "полка1");
        System.out.println("----------");


        System.out.println("addBook null title");
        librarySystem.addBook(null, "someAuthor", 1990, "полка1");
        System.out.println("----------");


        System.out.println("addBook empty author");
        librarySystem.addBook("some", "", 1990, "полка1");
        System.out.println("----------");


        System.out.println("addBook null author");
        librarySystem.addBook("some",  null, 1990, "полка1");
        System.out.println("----------");


        System.out.println("addBook too small year");
        librarySystem.addBook("some",  "someAuthor", minYear - 1, "полка1");
        System.out.println("----------");


        System.out.println("addBook too big year");
        librarySystem.addBook("some",  "someAuthor", maxYear + 1, "полка1");
        System.out.println("----------");

        System.out.println("addBook empty location");
        librarySystem.addBook("some",  "someAuthor", 1900, "");
        System.out.println("----------");


        System.out.println("addBook null location");
        librarySystem.addBook("some",  "someAuthor", 1421, null);
        System.out.println("----------");
        System.out.println("----------");

        System.out.println("removeBook корректные данные");
        librarySystem.removeBook("one", "someAuthor", 1990);
        System.out.println("----------");


        System.out.println("removeBook empty title");
        librarySystem.removeBook("",  "someAuthor", 1421);
        System.out.println("----------");


        System.out.println("removeBook null title");
        librarySystem.removeBook(null,  "someAuthor", 1421);
        System.out.println("----------");


        System.out.println("removeBook empty author");
        librarySystem.removeBook("some",  "", 1421);
        System.out.println("----------");


        System.out.println("removeBook null author");
        librarySystem.removeBook("some",  null, 1421);
        System.out.println("----------");


        System.out.println("removeBook too small year");
        librarySystem.removeBook("some",  "someAuthor",  minYear - 1);
        System.out.println("----------");

        System.out.println("removeBook too big year");
        librarySystem.removeBook("some",  "someAuthor", maxYear + 1);
        System.out.println("----------");
        System.out.println("----------");

        System.out.println("findBook book is find");
        librarySystem.findBook("one", "someAuthor", 1990);
        System.out.println("----------");

        System.out.println("findBook book isn`t find");
        librarySystem.findBook("osdf", "sdfsd", 192);
        System.out.println("----------");

        System.out.println("findBook empty title");
        librarySystem.findBook("", "someAuthor", 1990);
        System.out.println("----------");

        System.out.println("findBook null title");
        librarySystem.findBook(null, "someAuthor", 1990);
        System.out.println("----------");

        System.out.println("findBook empty author");
        librarySystem.findBook("one", "", 1990);
        System.out.println("----------");

        System.out.println("findBook null author");
        librarySystem.findBook("one", null, 1990);
        System.out.println("----------");

        System.out.println("findBook too small year");
        librarySystem.findBook("one", "Some", minYear - 1);
        System.out.println("----------");

        System.out.println("findBook too big year");
        librarySystem.findBook("one", "Some", maxYear + 1);
        System.out.println("----------");
        System.out.println("----------");

        System.out.println("printAllBooks");
        librarySystem.printAllBooks();
        System.out.println("----------");
    }
}
