package school.faang.google.mini.engine;

public class Main {

    public static void main(String[] args) {
        WebPage page1 = new WebPage("mysite.com", "title", "страница о том как я джава приложение писал");
        WebPage page2 = new WebPage("anothersite.com", "site", "ещё одна очень полезная страница о джава");
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.indexWebPage(page1);
        searchEngine.indexWebPage(page2);
        searchEngine.showSearchIndexContent();
        searchEngine.removeWebPageFromIndex("mysite.com");
        searchEngine.showSearchIndexContent();
    }
}
