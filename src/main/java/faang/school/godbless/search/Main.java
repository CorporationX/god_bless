package faang.school.godbless.search;

public class Main {
    public static void main(String[] args) {
        var engine = new SearchEngine();

        engine.addWebPage(new WebPage("books.com", "Books", "This page about books"));
        engine.printPages();

        engine.addWebPage(new WebPage("megashop.com", "MegaShop", "You can buy food, books and others items"));
        engine.addWebPage(new WebPage("cooking.com", "Cook", "Read the best books about food"));
        engine.printPages();

        System.out.printf("By books: %s%n", engine.findByWord("books"));

        engine.removeWebPageByUrl("books.com");
        System.out.printf("By books: %s%n", engine.findByWord("books"));
        engine.removeWebPageByUrl("cooking.com");
        System.out.printf("By books: %s%n", engine.findByWord("books"));
    }
}
