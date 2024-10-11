package school.faang.westeros.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("The Songs of Ice and Fire: A Collection of Ballads",
                "Maester Eddard of Oldtown",
                298, "Shelf 3A");
        library.addBook("The History of the Targaryen Kings",
                "Archmaester Gyldayn",
                300, "Shelf 1B");
        library.addBook("Dragons of the Dawn: The Rise and Fall",
                "Ser Jorah Mormont",
                305, "Shelf 2C");
        library.addBook("The Secrets of the Weirwoods",
                "Leaf, the Last Child of the Forest",
                290, "Shelf 2D");
        library.addBook("Knights and Knaves: Tales from the Seven Kingdoms",
                "Lady Brienne of Tarth",
                302, "Shelf 5E");

        System.out.println(library.searchBookShelf("The Chronicles of Winterfell", "Eddard Stark", 298));
        System.out.println(library.searchBookShelf("The Secrets of the Weirwoods",
                "Leaf, the Last Child of the Forest",
                290));
        library.addBook("The Chronicles of Winterfell", "Eddard Stark", 298, "Shelf 3B");
        library.deleteBook("The Songs of Ice and Fire: A Collection of Ballads",
                "Maester Eddard of Oldtown", 298);
        library.printBooks();
    }
}
