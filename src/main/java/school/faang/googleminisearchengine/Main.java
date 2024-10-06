package school.faang.googleminisearchengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static school.faang.googleminisearchengine.WebPageService.getWebPagesByKeyWord;
import static school.faang.googleminisearchengine.WebPageService.indexingNewWebPage;
import static school.faang.googleminisearchengine.WebPageService.removePageByUrl;
import static school.faang.googleminisearchengine.WebPageService.testPrintAllPages;
import static school.faang.googleminisearchengine.WebPageService.testPrintAllPagesByKeyWord;

public class Main {
    public static final HashMap<String, ArrayList<WebPage>> WEB_PAGES = new HashMap<>();
    public static final Set<WebPage> EXISTING_PAGES = new HashSet<>();

    public static void main(String[] args) {
        indexingNewWebPage(new WebPage("https://docs.oracle.com/", "Class String",
                "Strings are constant and can't be modified"));
        indexingNewWebPage(new WebPage("https://docs.oracle.com/",
                "Class StringBuffer",
                "A string buffer can be modified"));
        indexingNewWebPage(new WebPage("https://modifiedapps.com/",
                "MODIFIED APPS",
                "Modded apps are simply modified versions of the original mobile app"));
        indexingNewWebPage(new WebPage("https://faang-school.com/courses/",
                "Java HashMap",
                "Key-value data structure"));
        indexingNewWebPage(new WebPage("https://faang-school.com/courses/",
                "Java HashMap",
                "Key-value data structure"));

        ArrayList<WebPage> testWebPagesByKeyWord = getWebPagesByKeyWord("modified");
        testPrintAllPagesByKeyWord(testWebPagesByKeyWord);

        removePageByUrl("https://faang-school.com/courses/");

        ArrayList<WebPage> testWebPagesByKeyWordAfterRemove = getWebPagesByKeyWord("data");
        testPrintAllPagesByKeyWord(testWebPagesByKeyWordAfterRemove);
        testPrintAllPages();
    }
}
