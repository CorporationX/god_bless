package school.faang.sprint1.westeroslibrary;

/**
 * Represents a library system for storage information about books.
 * <p>
 * Defines operation that allows to interact with the library:
 * <ul>
 *   <li>add a book to the library;</li>
 *   <li>remove a book from the library;</li>
 *   <li>find a book;</li>
 *   <li>print all books in the library.</li>
 * </ul>
 */
public interface LibrarySystem {

    /**
     * Adds a new book to the library
     *
     * @param title    book title
     * @param author   book author
     * @param year     book release year
     * @param location in the library shelf
     * @return new added book location
     */
    String addBook(String title, String author, int year, String location);

    /**
     * Removes a book from the library
     *
     * @param title  book title
     * @param author book author
     * @param year   book release year
     * @return removed book location if found, otherwise {@code null}
     */
    String removeBook(String title, String author, int year);

    /**
     * Finds a book in the library
     *
     * @param title the title
     * @param author the author
     * @param year year
     */
    String findBook(String title, String author, int year);

    /**
     * Prints all books registered in the library
     */
    void printAllBooks();

}
