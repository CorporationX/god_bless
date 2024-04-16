package faang.school.godbless.javahashmap.westeroslibrary.test;

import faang.school.godbless.javahashmap.westeroslibrary.Book;
import faang.school.godbless.javahashmap.westeroslibrary.Main;

import java.util.HashMap;

public class TestMain {
    private Book book1 = Book.builder()
            .title("title1")
            .author("author1")
            .year(1111)
            .build();
    private Book book2 = Book.builder()
            .title("title2")
            .author("author2")
            .year(2222)
            .build();
    private Book book3 = Book.builder()
            .title("title3")
            .author("author3")
            .year(3333)
            .build();
    private Book book4 = Book.builder()
            .title("title4")
            .author("author4")
            .year(4444)
            .build();

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.testAdd();
        testMain.testRemove();
        testMain.testGet();
        testMain.testPrintAll();
    }

    public void testAdd() {
        Main myMain = new Main(new HashMap<>());
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.print("Main before implementation of the add method - ");
        System.out.println(myMain);
        System.out.println("-----------------------------------------------------------------------------------------");
        myMain.add(book1, "location1");
        System.out.print("Main after adding 1 book - ");
        System.out.println(myMain);
        System.out.println("-----------------------------------------------------------------------------------------");
        myMain.add(book2, "location2");
        myMain.add(book3, "location3");
        myMain.add(book4, "location4");
        System.out.print("Main after adding 3 books - ");
        System.out.println(myMain);
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public void testRemove() {
        Main myMain = new Main(new HashMap<>());
        myMain.add(book1, "location1");
        myMain.add(book2, "location2");
        myMain.add(book3, "location3");
        myMain.add(book4, "location4");
        System.out.print("Main before implementation of the remove method - ");
        System.out.println(myMain);
        System.out.println("-----------------------------------------------------------------------------------------");
        String location1 = myMain.remove("title1", "author1", 1111);
        System.out.print("Main after removing book1 - ");
        System.out.println(myMain);
        System.out.println("Location of book1 " + location1);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.print("Main after removing book3, book4 - ");
        String location3 = myMain.remove("title3", "author3", 3333);
        String location4 = myMain.remove("title4", "author4", 4444);
        System.out.println(myMain);
        System.out.println("Location of book3 " + location3);
        System.out.println("Location of book4 " + location4);
    }

    public void testGet() {
        Main myMain = new Main(new HashMap<>());
        myMain.add(book1, "location1");
        myMain.add(book2, "location2");
        myMain.add(book3, "location3");
        myMain.add(book4, "location4");
        System.out.println("-----------------------------------------------------------------------------------------");
        String location2 = myMain.get("title2", "author2", 2222);
        System.out.print("Location of the book2 - " + location2);
    }

    public void testPrintAll() {
        Main myMain = new Main(new HashMap<>());
        myMain.add(book1, "location1");
        myMain.add(book2, "location2");
        myMain.add(book3, "location3");
        myMain.add(book4, "location4");
        System.out.println("-----------------------------------------------------------------------------------------");
        String location2 = myMain.get("title2", "author2", 2222);
        System.out.print("\t\t\t\tResult of a printAll method:\n\n");
        System.out.println(myMain.printAll());
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
