package faang.school.godbless.google;

import java.util.*;

public class Main {
    private static HashMap<String, List<WebPage>> index = new HashMap<>();

    public static void indexWebPage(WebPage page) {
        String[] keyWords = page.getContent().toLowerCase().split("[(),.;:!? ]+");
        HashSet<String> wordsSet = new HashSet<>(Arrays.asList(keyWords));
        String[] uniqueKeyWords = wordsSet.toArray(new String[0]);
        for (String keyWord : uniqueKeyWords) {
            if (!index.containsKey(keyWord)) {
                index.put(keyWord, new LinkedList<>(List.of(page)));
            } else {
                index.get(keyWord).add(page);
            }
        }
    }

    public static List<WebPage> findPages(String keyWord) {
        if (!index.containsKey(keyWord.toLowerCase())) {
            return Collections.emptyList();
        }
        return index.get(keyWord.toLowerCase());
    }

    public static void deletePage(String url) {
        for (Map.Entry<String, List<WebPage>> entry : index.entrySet()) {
            List<WebPage> pages = entry.getValue();
            pages.removeIf(page -> page.getUrl().equals(url));
        }
    }

    public static void main(String[] args) {
        indexWebPage(new WebPage("https://what/java", "What Java is?",
                "Java is a highly popular, object-oriented programming language " +
                        "designed to have as few implementation dependencies as possible, " +
                        "enabling developers to write code that can run on any device " +
                        "with a Java Virtual Machine (JVM)."));
        indexWebPage(new WebPage("https://what/SQLdatabase", "What SQL database is?",
                "An SQL database (Structured Query Language database) is " +
                        "a type of relational database management system " +
                        "that uses SQL for defining, manipulating, and querying data."));
        indexWebPage(new WebPage("https://what/examples", "Programming languages",
                "There are many programming languages available. " +
                        "The most popular ones are: Java, C++, Python, JavaScript, Golang and many more."));
        indexWebPage(new WebPage("https://what/english", "Why it is important to learn English?",
                "Learning English is important because it serves as a global lingua franca, " +
                        "enabling communication across diverse cultures; " +
                        "there are numerous opportunities in education and employment " +
                        "for those who are proficient in the language."));

        //no pages
        System.out.println(findPages("apple"));
        //one page
        System.out.println(findPages("SQL"));
        //two pages
        System.out.println(findPages("Java"));

        deletePage("https://what/examples");
        //one page (another one was deleted)
        System.out.println(findPages("java"));
    }
}
