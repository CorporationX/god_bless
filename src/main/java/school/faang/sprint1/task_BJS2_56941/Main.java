package school.faang.sprint1.task_BJS2_56941;

/*
сделал тесты

 */

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();


        try {
            System.out.println("addBook корректные данные");
            librarySystem.addBook("one", "someAuthor", 1990, "shelf1");
            librarySystem.addBook("two", "SomeOneElseAuthor", 1944, "shelf2");
            librarySystem.addBook("three", "AnotherAuthor", 1933, "shelf3");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------");



        try {
            System.out.println("addBook пустой title");
            librarySystem.addBook("", "someAuthor", 1990, "полка1");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------");




        System.out.println("addBook пустой author");
        try {
            librarySystem.addBook("some", "", 1990, "полка1");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------");
    }
}
