package miniSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final Map<String, List<WebPage>> SEARCH = new HashMap<String, List<WebPage>>();

    public static void addWebPage(WebPage page) {
        String[] index = page.getContent().replaceAll("[.,!?]", "").split(" ");
        for (String s : index) {
            SEARCH.putIfAbsent(s.toLowerCase(), new ArrayList<WebPage>());
            SEARCH.get(s.toLowerCase()).add(page);
        }
    }

    public static List<WebPage> findWebPages(String query) {
        return SEARCH.get(query.toLowerCase());
    }

    public static void deleteWebPage(String url) {
        SEARCH.forEach((k, v) -> {
            for (int i = 0; i < v.size(); i++) {
                if (v.get(i).getUrl().equals(url)) {
                    v.remove(i);
                }
            }
        });
    }

    public static void main(String[] args) {
        addWebPage(new WebPage("https://example.com", "Example Page", "This is an example content."));
        addWebPage(new WebPage("https://google.com", "Google", "Search engine homepage."));
        addWebPage(new WebPage("https://blog.com", "Tech Blog", "Latest tech trends and tutorials. This is an example content."));
        addWebPage(new WebPage("https://docs.com", "Documentation", "Official documentation for the product. Find detailed examples."));
        addWebPage(new WebPage("https://news.com", "Daily News", "Breaking news and analysis. This is an example content."));

        System.out.println(findWebPages("Breaking"));
        System.out.println(findWebPages("engine"));
        System.out.println(findWebPages("exaMple"));

        deleteWebPage("https://blog.com");
        System.out.println(findWebPages("EXAMPLE"));
    }
}
