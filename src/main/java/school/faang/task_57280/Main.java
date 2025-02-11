package school.faang.task_57280;

public class Main {
    public static void main(String[] args) {
        LibraryMap libraryMap = new LibraryMap();
        libraryMap.addBook("War and Piece", "Someone", 1950, "A2");
        libraryMap.addBook("War and Piece", "Someone", 1950, "A2");
        libraryMap.addBook("Goal", "Someone else", 1922, "B4");
        libraryMap.removeBook("Goal", "Someone else", 1922);
        libraryMap.removeBook("Goal", "Someone else", 1922);
        libraryMap.removeBook("Goal", "Someone else", 1922);
        libraryMap.findBook("Goal", "Someone else", 1922);
        libraryMap.findBook("War and Piece", "Someone", 1950);
        libraryMap.printAllBooks();
    }
}
