package school.faang.googleMiniEngine;

public class Main {

    public static void main(String[] args) {
        WebPage page1 = new WebPage("mysite.com", "title", "страница о том как я джава приложение писал");
        WebPage page2 = new WebPage("anothersite.com", "site", "ещё одна очень полезная страница о джава");
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.addWebPageToIndex(page1);
        searchEngine.addWebPageToIndex(page2);
        searchEngine.showSearchIndexContent();
        searchEngine.removeWebPageFromIndexByUrl("mysite.com");
        searchEngine.showSearchIndexContent();
    }
}
