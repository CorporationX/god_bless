package faang.school.godbless.googlesearchengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<String, List<WebPage>> PAGES_KEYWORD_INDEX = new HashMap<>();

    public static void main(String[] args) {
        WebPage springContext = new WebPage("https://github.com/user/spring-context",
                "Spring-Context",
                "GitHib repository 'Spring-Context'.");
        WebPage mvcExample = new WebPage("https://github.com/user/mvc-example",
                "MVC-Example",
                "GitHib repository 'MVC-Example'.");
        WebPage databaseNotFound = new WebPage("https://stackoverflow.com/questions/78847741/error-tf254078-no-attachable-database-were-found",
                "Error :TF254078 No attachable database were found",
                "I have upgraded the Test Environment with new Azure DevOps Server 2022.2, Then restore the tfs_configuration and tfs_DefaultCollection latest backup from another production server. Everything works fine.\n" +
                        "\n" +
                        "I took a full Backup before upgrading the Azure DevOps Server from 2022.1 to 2022.2. I have restored a Collection database in SQL Server. Then I follow Restore data to a different server than the current one, Because I have deleted the Tfs_Configuration and Tfs_DefaultCollection and Restored another latest from backup from another server.\n" +
                        "\n" +
                        "Now, I want to attach this collection from “Attach Team Project Collection” in “Azure DevOps Server Administration Console”. It gives me Error that No attachable database were found.\n" +
                        "\n" +
                        "How Can I attach this project collection ?\n" +
                        "\n" +
                        "I run TfsConfig commands to register this collection database. Checked all necessary service account permissions.");
        indexWebPage(springContext);
        indexWebPage(mvcExample);
        indexWebPage(databaseNotFound);
        System.out.println(findWebPagesByKeyword("GitHib"));
        System.out.println(findWebPagesByKeyword("commands"));
        removeWebPageByUrl("https://github.com/user/mvc-example");
        System.out.println(findWebPagesByKeyword("GitHib"));
    }

    public static void indexWebPage(WebPage webPage) {
        List<String> tokens = Arrays.stream(webPage.getContent().split(" "))
                .map(token -> (token.replaceAll("[,./';|_-]", ""))).toList();
        for (String token : tokens) {
            PAGES_KEYWORD_INDEX.computeIfAbsent((token), k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findWebPagesByKeyword(String keyword) {
        return PAGES_KEYWORD_INDEX.get(keyword);
    }

    public static void removeWebPageByUrl(String url) {
        for (String key : PAGES_KEYWORD_INDEX.keySet()) {
            List<WebPage> webPages = PAGES_KEYWORD_INDEX.get(key);
            webPages.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}