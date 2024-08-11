package googleSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<WebPage>webPageList = new ArrayList<>();
        webPageList.add(new WebPage("google.com", "поисковик", List.of("поисковик", "погода", "новости", "календарь")));
        webPageList.add(new WebPage("yandex.ru", "поисковик", List.of("поисковик", "погода", "новости", "календарь")));
        webPageList.add(new WebPage("Uber.com", "такси", List.of("такси", "поездка", "дешево", "совместно", "быстро")));
        webPageList.add(new WebPage("taxi.yandex.ru", "такси", List.of("такси", "поездка", "дешево", "совместно", "быстро")));
        Map<String , List<WebPage>> webPageMap = new HashMap<>();

        WebPage.indexMap(webPageMap, webPageList);
        WebPage.outputMap(webPageMap);
        WebPage.searchPage(webPageMap, "поисковик");
        WebPage.removeUrl(webPageMap, "google.com");
        WebPage.outputMap(webPageMap);
    }
}
