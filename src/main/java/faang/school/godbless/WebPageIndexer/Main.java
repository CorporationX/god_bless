package faang.school.godbless.WebPageIndexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    Map<String, List<WebPage>> WEB_PAGES = new HashMap<>();

    public static void main(String[] args) {

        WebPage page1 = new WebPage("https://twitter.com/post/334fg82s", "What breed of dog should I choose?", """
                " Choosing a dog breed?  Consider your lifestyle, 
                space, and energy level! If you're active,
                think about breeds like Labs or Border Collies. 
                For apartment dwellers, smaller breeds like Pugs or French Bulldogs might be paw-fect. 
                It's all about finding the right fit for you! #DogBreeds #PetAdoption "
                """);
        WebPage page2 = new WebPage("https://twitter.com/post/s7h83dUihd", "Which came first, the chicken or the egg??", """
                The age-old question: Which came first, the chicken or the egg? 
                It's a classic chicken-and-egg scenario! While the answer might be up for debate, 
                evolution suggests that changes over time led to the emergence of the first chicken, 
                so perhaps the egg came first after all! #ChickenOrEgg #EvolutionMystery
                """);
        WebPage page3 = new WebPage("https://twitter.com/post/Rvff80rJis", "Why should I go on Java Bootcamp?", """
                Thinking about joining a Java Bootcamp? Here's why it could be a game-changer:
                                                                                            
                1. In-demand skills: Java is widely used in software development, offering numerous job opportunities.
                2. Strong foundation: Bootcamps provide intensive, hands-on learning to master Java fundamentals.
                3. Career boost: Completing a Java Bootcamp can open doors to entry-level software development roles.
                4. Community & networking: Connect with like-minded individuals and industry professionals for support and collaboration.
                5. Future-proofing: Java's robustness and versatility ensure its relevance in the ever-evolving tech landscape. #JavaBootcamp #TechCareer #FutureReady""");


        Main main = new Main();

        main.indexingPage(page1);
        main.indexingPage(page2);
        main.indexingPage(page3);

        main.getPageByWord("on");

        System.out.println();

        main.deletePageByURL("https://twitter.com/post/Rvff80rJis");

        main.getPageByWord("on");

    }

    public void indexingPage(WebPage page) {
        try {
            String[] words = page.getContent().split("\\s+|[^a-zA-Z0-9]");
            for (String word : words) {
                List<WebPage> pages = WEB_PAGES.getOrDefault(word, new ArrayList<>());

                pages.add(page);

                WEB_PAGES.put(word, pages);
            }
        } catch (NullPointerException e) {
            System.err.println("Error: Null ");
        }
    }

    public void getPageByWord(String word) {
        try {
            for (Map.Entry<String, List<WebPage>> entry : WEB_PAGES.entrySet()) {
                String keyword = entry.getKey();
                if (keyword.contains(word)) {
                    List<WebPage> pages = entry.getValue();
                    for (WebPage page : pages)
                        System.out.println("Word: \"" + word + "\" contains on page: " + page.getTitle() + ", with URL: " + page.getUrl());

                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error: Null ");
        }
    }

    public void deletePageByURL(String url) {
        try {
            for (Map.Entry<String, List<WebPage>> entry : WEB_PAGES.entrySet()) {
                List<WebPage> pages = entry.getValue();
                Iterator<WebPage> iterator = pages.iterator();
                while (iterator.hasNext()) {
                    WebPage page = iterator.next();
                    if (page.getUrl().equals(url)) {
                        iterator.remove();
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error: Null URL for the page.");
        }
    }

}
