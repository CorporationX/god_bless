package school.faang.googlesearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    // HashMap for storing keywords as keys and list of WebPages as values
    private Map<String, List<WebPage>> index = new HashMap<>();

    // Method to index a new web page
    public void indexWebPage(WebPage webPage) {
        // Split the content into words and add the web page to the index for each word
        String[] words = webPage.getContent().toLowerCase().split("\\W+");
        for (String word : words) {
            index.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    // Method to search for web pages by keyword
    public List<WebPage> search(String keyword) {
        return index.getOrDefault(keyword.toLowerCase(), new ArrayList<>());
    }

    // Method to remove a web page from the index by its URL
    public void removeWebPage(String url) {
        // Iterate over the index and remove any references to the web page with the given URL
        for (List<WebPage> webPages : index.values()) {
            webPages.removeIf(webPage -> webPage.getUrl().equalsIgnoreCase(url));
        }
    }

}