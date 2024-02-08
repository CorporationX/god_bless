package faang.school.godbless.library_westeros;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final  Map<Book, String> books = new HashMap<>();
    public static void main(String[] args) {

        // Create books
        Book book1 = new Book("The Great Adventure", "John Doe", 2005);
        Book book2 = new Book("Mystery of the Lost Treasure", "Jane Smith", 2010);
        Book book3 = new Book("Science of Everything", "Alice Johnson", 2018);

        books.put(book1, "122");
        books.put(book2, "133");
        books.put(book3, "127");

        Main.addNewBook( "Clean Code", "Robert C. Martin", 2008, "77" );
        Main.addNewBook("Design Patterns", "Erich Gamma", 1994, "77" );
        System.out.println("All books:");
        Main.printAllBooks();
        Main.deleteBook( "The Great Adventure", "John Doe", 2005 );
        Main.deleteBook( "Science of Everything", "Alice Johnson", 2018);
        System.out.println("All books:");
        Main.printAllBooks();

        Main.findBook( "The Great Adventure ", "John Doe ", 2005 );
        Main.findBook( "Design Patterns", "Erich Gamma", 1994 );

    }
    public static void  addNewBook(String title, String author, int year, String shelf){
              Book b = new Book(title, author, year);
              books.put(b, shelf);
    }

    public static void deleteBook(String title, String author, int year){
        Book targetBook = new Book(title, author, year);
        Book bookToRemove = null;
        for(Book key: books.keySet()){
            if(key.equals( targetBook )){
                bookToRemove = key;
                break;
            }
        }
        if(bookToRemove!=null){
            books.remove(bookToRemove);
            System.out.println("Book removed successfully: " + bookToRemove.toString());
        }else{
            System.out.println("No book found");
        }
    }
    public static void findBook(String title, String author, int year){
        Book targetBook = new Book(title, author, year);
        for(Book key : books.keySet()){
            if(!books.containsKey(targetBook)){
                System.out.println("Book " + title + author + year + " does not exist in library");
                return;
            }else if(key.equals( targetBook )) {
                System.out.println("Book " + title + author + year + " found on shelf " + books.get(key));
                return;
            }
        }
    }
    public static void printAllBooks(){
         for(Map.Entry<Book, String> entry: books.entrySet() ){
             System.out.println("Book " + entry.getKey().toString() + " is located on shelf " +entry.getValue());
         }
    }
}
