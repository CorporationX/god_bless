package school.faang.task_45357;

public class Main {
    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();

        library.addBook("TestTitleOne", "TestAuthorOne", 1999, "Верхняя полка");
        library.addBook("TestTitleTwo", "TestAuthorTwo", 1438, "Нижняя полка");
        library.addBook("TestTitleThree", "TestAuthorThree", 1933, "Средняя полка");
        library.addBook("TestTitleFour", "TestAuthorFour", 1982, "Нижняя полка");
        library.addBook("TestTitleFive", "TestAuthorFive", 1933, "Верхняя полка");

        library.printAllBooks();
        library.removeBook("TestTitleFive", "TestAuthorFive", 1933);
        library.printAllBooks();

        library.removeBook("TestTitleFour", "TestAuthorFour", 1981);
        library.findBook("TestTitleOne", "TestAuthorOne", 1999);
        library.printAllBooks();
    }
}
