package school.faang;

import school.faang.collectusers.User;
import school.faang.westeros_library.Book;
import school.faang.westeros_library.LibrarySystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        testWesterosLibrary();
        testUsersGroupedByAge();
        testCollectUsers();
    }

    public static void testWesterosLibrary() {
        // --- Tests for Book Class (equals and hashCode) ---
        System.out.println("--- Testing Book Class (equals and hashCode) ---");

        Book book1 = new Book("A Game of Thrones", "George R.R. Martin", 1996);
        Book book2 = new Book("A Game of Thrones", "George R.R. Martin", 1996);
        Book book3 = new Book("A Clash of Kings", "George R.R. Martin", 1999);
        Book book4 = new Book("A Game of Thrones", "Someone Else", 1996);
        Book book5 = new Book("A Game of Thrones", "George R.R. Martin", 1997);

        // Test Case 1: Equality of two identical books
        System.out.println("\nTest Case 1: Identical Books");
        System.out.println("book1.equals(book2): " + book1.equals(book2));
        System.out.println("book1.hashCode() == book2.hashCode(): " + (book1.hashCode() == book2.hashCode()));

        // Test Case 2: Inequality due to different title
        System.out.println("\nTest Case 2: Different Title");
        System.out.println("book1.equals(book3): " + book1.equals(book3));
        System.out.println("book1.hashCode() == book3.hashCode(): " + (book1.hashCode() == book3.hashCode()));

        // Test Case 3: Inequality due to different author
        System.out.println("\nTest Case 3: Different Author");
        System.out.println("book1.equals(book4): " + book1.equals(book4));
        System.out.println("book1.hashCode() == book4.hashCode(): " + (book1.hashCode() == book4.hashCode()));

        // Test Case 4: Inequality due to different year
        System.out.println("\nTest Case 4: Different Year");
        System.out.println("book1.equals(book5): " + book1.equals(book5));
        System.out.println("book1.hashCode() == book5.hashCode(): " + (book1.hashCode() == book5.hashCode()));

        // Test Case 5: Using Book objects as keys in HashMap (equality and hashCode in action)
        System.out.println("\nTest Case 5: Books as HashMap Keys");
        Map<Book, String> bookLocations = new HashMap<>();
        bookLocations.put(book1, "Shelf A1");
        bookLocations.put(book2, "Shelf B2"); // Should overwrite book1 due to equals and hashCode
        System.out.println("Size of bookLocations (should be 1): " + bookLocations.size());
        System.out.println("Location of book1 (should be Shelf B2): " + bookLocations.get(book1));
        System.out.println("Location of book2 (should be Shelf B2): " + bookLocations.get(book2));
        System.out.println("Location of book3 (should be null): " + bookLocations.get(book3));

        // Test Case 6: Using Book objects in HashSet (equality and hashCode in action)
        System.out.println("\nTest Case 6: Books in HashSet");
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2); // Should not add as it's equal to book1
        bookSet.add(book3);
        System.out.println("Size of bookSet (should be 2): " + bookSet.size());
        System.out.println("Contains book1: " + bookSet.contains(book1));
        System.out.println("Contains book2: " + bookSet.contains(book2));
        System.out.println("Contains book3: " + bookSet.contains(book3));

        // --- Tests for LibrarySystem Class ---
        System.out.println("\n--- Testing LibrarySystem Class ---");
        LibrarySystem library = new LibrarySystem();

        library.addBook("A Game of Thrones", "George R.R. Martin", 1996, "Shelf A1");
        library.addBook("A Clash of Kings", "George R.R. Martin", 1999, "Shelf B2");

        System.out.println("\nTest Case 7 (Library): Finding existing book");
        System.out.println("Location of 'A Game of Thrones': "
                + library.findBook("A Game of Thrones", "George R.R. Martin", 1996));

        System.out.println("\nTest Case 8 (Library): Adding duplicate (overwrites location)");
        library.addBook("A Game of Thrones", "George R.R. Martin", 1996, "Shelf C3");
        System.out.println("Location of 'A Game of Thrones' after adding again: "
                + library.findBook("A Game of Thrones", "George R.R. Martin", 1996));

        System.out.println("\nTest Case 9 (Library): Removing a book");
        library.removeBook("A Clash of Kings", "George R.R. Martin", 1999);
        System.out.println("Location of 'A Clash of Kings' after removal: "
                + library.findBook("A Clash of Kings", "George R.R. Martin", 1999));

        System.out.println("\nTest Case 10 (Library): Printing all books");
        System.out.println("All Books in Library:\n" + library.printAllBooks());
    }

    public static void testUsersGroupedByAge() {
        List<school.faang.groupusersage.User> users = List.of(
                new school.faang.groupusersage.User("Alice", 30, "TechCorp", "123 Main St"),
                new school.faang.groupusersage.User("Bob", 25, "Startup Inc", "456 Oak Ave"),
                new school.faang.groupusersage.User("Charlie", 30, "Global Ltd", "789 Pine Ln"),
                new school.faang.groupusersage.User("David", 25, "New Firm", "111 Willow Dr")
        );

        Map<Integer, List<school.faang.groupusersage.User>> groupedUsers =
                school.faang.groupusersage.User.groupUsers(users);
        for (Map.Entry<Integer, List<school.faang.groupusersage.User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void testCollectUsers() {
        User user1 = new User(1, "Alice", 30, new HashSet<>(Arrays.asList("Reading", "Hiking", "Photography")));
        User user2 = new User(2, "Bob", 25, new HashSet<>(Arrays.asList("Gaming", "Coding", "Reading")));
        User user3 = new User(3, "Charlie", 40, new HashSet<>(Arrays.asList("Painting", "Gardening", "Cooking")));
        User user4 = new User(4, "David", 28, new HashSet<>(Arrays.asList("Coding", "Running", "Music")));
        User user5 = new User(5, "Eve", 35, new HashSet<>(Arrays.asList("Traveling", "Photography", "Yoga")));
        User user6 = new User(6, "Frank", 22, new HashSet<>(Arrays.asList("Gaming")));
        User user7 = new User(7, "Grace", 45, new HashSet<>());

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        Set<String> hobbiesToFind1 = new HashSet<>(Arrays.asList("Reading", "Coding"));
        Set<String> hobbiesToFind2 = new HashSet<>(Arrays.asList("Photography", "Swimming"));
        Set<String> hobbiesToFind3 = new HashSet<>(Arrays.asList("Gaming"));
        Set<String> hobbiesToFind4 = new HashSet<>(Arrays.asList("NonExistentHobby"));

        System.out.println("\nTest Case 1: Finding users who like Reading or Coding");
        Map<String, String> lovers1 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind1);
        System.out.println("Hobby Lovers: " + lovers1);

        System.out.println("\nTest Case 2: Finding users who like Photography or Swimming");
        Map<String, String> lovers2 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind2);
        System.out.println("Hobby Lovers: " + lovers2);

        System.out.println("\nTest Case 3: Finding users who like Gaming");
        Map<String, String> lovers3 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind3);
        System.out.println("Hobby Lovers: " + lovers3);

        System.out.println("\nTest Case 4: Finding users who like a non-existent hobby");
        Map<String, String> lovers4 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind4);
        System.out.println("Hobby Lovers: " + lovers4);
    }
}
