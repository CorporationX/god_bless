package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.WebPageService.writeIndexToMap;

public class Main {

    private static Map<String, List<WebPage>> webPagesWithKey = new HashMap<>();
    private static Set<WebPage> pages = new HashSet<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("https://github.com/CorporationX", "BEST_COURSE", "Hello word");
        WebPage webPage2 = new WebPage("https://github.com", "BEST_SITE", "Hello git");
        WebPage webPage3 = new WebPage("https://google.com", "BEST_BROWSE", "Hello google");
        writeIndexToMap(webPage1, webPagesWithKey, pages);
        writeIndexToMap(webPage1, webPagesWithKey, pages);
        writeIndexToMap(webPage2, webPagesWithKey, pages);
        writeIndexToMap(webPage3, webPagesWithKey, pages);
    }

}
