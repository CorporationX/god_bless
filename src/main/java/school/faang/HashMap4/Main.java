package school.faang.HashMap4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.HashMap4.WebPage.deletePage;
import static school.faang.HashMap4.WebPage.index;
import static school.faang.HashMap4.WebPage.printMap;
import static school.faang.HashMap4.WebPage.printWebPageList;
import static school.faang.HashMap4.WebPage.searchKeyWord;

public class Main {
    public static void main(String[] args) {
        Map<String, List<WebPage>> webPageMap = new HashMap<>();

        index(new WebPage("vk.com", "VK", "Hello my friends"), webPageMap);
        index(new WebPage("telegram.org", "Tg", "Hello world"), webPageMap);
        index(new WebPage("x.com", "X", "The best friends"), webPageMap);
        index(new WebPage("youtu.be", "YouTube", "Say hello to the best friend"), webPageMap);
        printMap(webPageMap);
        System.out.println("Searching word \"Hello\"");
        printWebPageList(searchKeyWord("Hello", webPageMap));
        System.out.println("Searching word \"Hell\"");
        printWebPageList(searchKeyWord("Hell", webPageMap));
        deletePage("x.com", webPageMap);
        System.out.println("-----After delete x.com: ");
        printMap(webPageMap);

    }
}
