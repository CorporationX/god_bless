package school.faang;

import school.faang.firsttask.User;
import school.faang.forthTask.SearchEngine;
import school.faang.forthTask.WebPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        usersGrouping();
        googleSearchEngine();
    }

    public static void usersGrouping() {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 30, "Company 1", "Address 1"));
        users.add(new User("Alex", 25, "Company 2", "Address 2"));
        users.add(new User("Stepan", 30, "Company 3", "Address 3"));

        Map<Integer, List<User>> grouped = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(" - " + user.getName());
            }
        }
    }

    public static void googleSearchEngine() {
        SearchEngine searchEngine = new SearchEngine();

        WebPage page1 = new WebPage("http://example1.com", "Example Page", "This is an example content with some example words.");
        WebPage page2 = new WebPage("http://example2.org", "Another Example", "Another example content with different words.");
        WebPage page3 = new WebPage("http://example3.org", "Third Example", "Third variant content with different words.");

        searchEngine.indexWebPage(page1);
        searchEngine.indexWebPage(page2);
        searchEngine.indexWebPage(page3);

        System.out.println("Set of indexes: " + searchEngine.getIndex().keySet());

        System.out.println("Search results for 'example':" + searchEngine.search("example").toString());

        for (WebPage page : searchEngine.search("example")) {
            System.out.println(page);
        }

        searchEngine.removeWebPage("http://example1.com");

        System.out.println("\nSearch results for 'example' after removal:");
        for (WebPage page : searchEngine.search("example")) {
            System.out.println(page);
        }
    }
}
