package school.faang.task_45291;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("To kill a Mockingbird", "Harper Lee", 2013, "4-34");
        library.addBook("Pride and Prejudice", "Jane Austen", 2005, "2-12");
        library.addBook("The Diary of a Young Girl", "Anne Frank", 2002, "1-7");
        library.addBook("Animal Farm", "George Orwell", 2001, "0-13");
        library.addBook("The Little Prince", "Antoine Exupery", 1996, "3-21");

        library.removeBook("Animal Farm", "George Orwell", 2001);

        library.findBook("Deeper Than the Ocean", "James Schulz", 1945);
        library.findBook("Pride and Prejudice", "Jane Austen", 2005);

        library.printAllBooks();
    }
}
