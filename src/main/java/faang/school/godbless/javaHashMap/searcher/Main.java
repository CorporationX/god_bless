package faang.school.godbless.javaHashMap.searcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Main {
    private final Map<String, List<WebPage>> index;

    public Main() {
        index = new HashMap<>();
    }


    public static void main(String[] args) {
        Main pageService = new Main();

        WebPage page = new WebPage("nadir.cianid.com", "Masterclass of storytelling", "Mother washed a window frame. Mother frame.");
        pageService.indexWebPage(page);

        printIndex(pageService);
        System.out.println("------------------------------------");

        page = new WebPage("nadir.cianid.com", "Masterclass of storytelling", "Mother washed a window frame. Mother frame.");
        pageService.indexWebPage(page);

        printIndex(pageService);
        System.out.println("------------------------------------");

        page = new WebPage("nadir.cianid.ru", "Masterclass of storytelling 2", "Father washed a window frame. Father frame.");
        pageService.indexWebPage(page);

        printIndex(pageService);

        System.out.println("------------------------------------");

        System.out.println(pageService.search("father"));

        System.out.println("------------------------------------");

        System.out.println("Result of removing pagy with url \"nadir.cianid.ru\" - " + pageService.removePage("nadir.cianid.ru"));

        System.out.println("Index at this point:");
        printIndex(pageService);

        System.out.println("------------------------------------");

        System.out.println("Result of removing pagy with url \"nadir.cianid.net\" - " + pageService.removePage("nadir.cianid.net"));

        System.out.println("Index at this point:");
        printIndex(pageService);


    }

    private static void printIndex(Main pageService) {
        pageService.index.entrySet().forEach(System.out::println);
    }

    public void indexWebPage(WebPage webPage) {
        List<String> keyWords = Arrays.stream(webPage.getContent().split("[\\s.,?!:;]+")).toList();

        for (String currentKeyWord : keyWords) {
            currentKeyWord = currentKeyWord.toLowerCase(Locale.ROOT);

            List<WebPage> currentPageList = index.computeIfAbsent(currentKeyWord, key -> new ArrayList<>());

            if (currentPageList.contains(webPage)) {
                continue;
            }

            currentPageList.add(webPage);
        }
    }

    public List<WebPage> search(String keyWord) {
        keyWord = keyWord.toLowerCase(Locale.ROOT);

        return index.get(keyWord);
    }

    public WebPage getPageByUrl(String url) {
        for (List<WebPage> currentPageList : index.values()) {
            for (WebPage currentWebPage : currentPageList) {
                if (currentWebPage.getUrl().equals(url)) {
                    return currentWebPage;
                }
            }
        }

        return null;
    }

    public boolean removePage(String url) {
        WebPage pageToBeRemoved = getPageByUrl(url);

        if (pageToBeRemoved == null) {
            return false;
        }

        for (List<WebPage> currentPageList : index.values()) {
            currentPageList.remove(pageToBeRemoved);
        }

        return true;
    }
}
