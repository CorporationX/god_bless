package school.faang.sprint1.bjs_45304;

import com.github.javafaker.Faker;

public class Main {
    public static String[] generateBookData() {
        Faker faker = new Faker();
        String title = faker.book().title();
        String author = faker.name().fullName();
        int year = faker.number().numberBetween(1800, 2024);
        String location = String.valueOf(faker.number().numberBetween(1, 300));

        return new String[]{title, author, String.valueOf(year), location};
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        for (int i = 0; i < 5; i++) {
            String[] bookData = generateBookData();
            library.addBook(bookData[0], bookData[1], Integer.parseInt(bookData[2]), bookData[3]);
        }
        library.printAllBooks();

        String[] bookData = generateBookData();
        library.addBook(bookData[0], bookData[1], Integer.parseInt(bookData[2]), bookData[3]);
        library.findBook(bookData[0], bookData[1], Integer.parseInt(bookData[2]));
        library.removeBook(bookData[0], bookData[1], Integer.parseInt(bookData[2]));
        library.printAllBooks();
    }
}