package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Google google = new Google();

        WebPage page1 = new WebPage("https://example.com/page1", "T 1", "This is the first page.");
        WebPage page2 = new WebPage("https://example.com/page2", "T 2", "This is the second page.");
        WebPage page3 = new WebPage("https://example.com/page3", "T 3", "Another content.");

        google.indexWebPage(page1);
        google.indexWebPage(page2);
        google.indexWebPage(page3);

        System.out.println("Search results for 'This':");
        google.search("This").forEach(page -> System.out.println("    " + page));

        google.removeWebPage("https://example.com/page2");

        System.out.println("\nSearch results for 'This' after deletion:");
        google.search("This").forEach(page -> System.out.println("    " + page));
    }
}