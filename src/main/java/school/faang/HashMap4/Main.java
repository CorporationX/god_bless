package school.faang.HashMap4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static school.faang.HashMap4.WebPageOperator.deletePage;
import static school.faang.HashMap4.WebPageOperator.index;
import static school.faang.HashMap4.WebPageOperator.printMap;
import static school.faang.HashMap4.WebPageOperator.printWebPageList;
import static school.faang.HashMap4.WebPageOperator.searchKeyWord;

public class Main {
    public static void main(String[] args) {
        Map<String, List<WebPage>> webPageMap = new HashMap<>();

        index(new WebPage("vk.com", "VK", "Hello my friends."), webPageMap);
        index(new WebPage("telegram.org", "Tg", "Hello world"), webPageMap);
        index(new WebPage("x.com", "X", "The best friends"), webPageMap);
        index(new WebPage("youtu.be", "YouTube", "Say hello, the best friend"), webPageMap);
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
