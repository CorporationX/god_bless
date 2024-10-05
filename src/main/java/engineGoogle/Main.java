package engineGoogle;

public class Main {

    public static void main(String[] args) {
        WebIndexer webIndexer = new WebIndexer();
        WebPage page1 = new WebPage("https://sql-academy.org/ru/guide", "Гайд", "Tell about sql");
        WebPage page2 = new WebPage("https://sql", "История", "how do SQL and TELL");
        WebPage page3 = new WebPage("https://LOOOOOVE_SQLLLLL", "Love", "love ABOUT aqL");

        webIndexer.setIndexMap(page1);
        webIndexer.setIndexMap(page2);
        webIndexer.setIndexMap(page3);
        webIndexer.printPages();


        System.out.println("\n");
        System.out.println(webIndexer.findWebPage("SqL"));


        System.out.println("\n");
        webIndexer.removeWepPage("https://sql-academy.org/ru/guide");
        webIndexer.printPages();
    }
}
