package faang.school.godbless.javahashmap.task9;

import java.util.*;

public class Main {
    private static final Map<String, List<WebPage>> WEB_PAGES_MAP = new HashMap<>();
    private static final Set<WebPage> WEB_PAGE_SET = new HashSet<>();

    public static void main(String[] args) {
        addPageToIndex(new WebPage("https://www.bbc.com/news", "BBC News - Home",
                "Последние новости из мира политики, экономики, спорта и культуры."));
        addPageToIndex(new WebPage("https://www.amazon.com/Apple-MacBook-Pro-13-inch-Space-Gray/dp/B08N4B2929",
                "Apple MacBook Pro 13.3-inch (Space Gray) - Apple M1 Chip - 8GB RAM - 512GB SSD",
                "Ультратонкий и мощный ноутбук Apple MacBook Pro с процессором Apple M1. 8 ГБ " +
                        "оперативной памяти, 512 ГБ SSD. 13.3-дюймовый Retina дисплей. " +
                        "Длительное время автономной работы."));
        addPageToIndex(new WebPage("https://www.allrecipes.com/recipe/23147/chocolate-chip-cookies/",
                "Chocolate Chip Cookies", "Классический рецепт шоколадного печенья. " +
                "Легко и быстро готовится!"));
        addPageToIndex(new WebPage("https://www.lonelyplanet.com/travel-ideas/destinations/europe",
                "Europe Travel Ideas", "Лучшие места для путешествий по Европе. Советы и рекомендации " +
                "для планирования поездки."));
        addPageToIndex(new WebPage("https://www.reddit.com/r/programming", "r/programming - Reddit",
                "Форум для программистов. Обсуждение языков программирования, технологий и" +
                        " вопросов разработки."));
        addPageToIndex(new WebPage("https://www.imdb.com/title/tt0111161/", "The Shawshank Redemption (1994)",
                "История заключенного, который оказывается в тюрьме за убийство, которого он не совершал. " +
                        "Фильм о надежде и дружбе."));
        addPageToIndex(new WebPage("https://en.wikipedia.org/wiki/Artificial_intelligence", "Artificial " +
                "intelligence - Wikipedia", "Статья о искусственном интеллекте. Определение, история, " +
                "применения, этические аспекты."));
        addPageToIndex(new WebPage("https://www.medium.com", "Medium - Where good ideas find you.",
                "Блог, где вы можете найти интересные статьи на разные темы. Публикуются тексты о технологиях, " +
                        "искусстве, политике и других актуальных вопросах."));

        System.out.println(findWebPages("Лучшие"));
        System.out.println();
        System.out.println(findWebPages("история"));
        System.out.println();
        removePageFromTheIndex(new WebPage("https://en.wikipedia.org/wiki/Artificial_intelligence", "Artificial " +
                "intelligence - Wikipedia", "Статья о искусственном интеллекте. Определение, история, " +
                "применения, этические аспекты."));
        System.out.println(findWebPages("история"));
    }
    
    public static void addPageToIndex(WebPage webPage) {
        WEB_PAGE_SET.add(webPage);
        String[] arrayWord = webPage.getContent().replace(",", "").split(" ");
        for (String word : arrayWord) {
            WEB_PAGES_MAP.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> findWebPages(String keyWord) {
        return WEB_PAGES_MAP.get(keyWord);
    }

    public static void removePageFromTheIndex(WebPage webPage) {
        if (WEB_PAGE_SET.contains(webPage)) {
            WEB_PAGE_SET.remove(webPage);
            String[] arrayWord = webPage.getContent().replace(",", "").split(" ");
            for (String word : arrayWord) {
                List<WebPage> pages = WEB_PAGES_MAP.get(word);
                Iterator<WebPage> iterator = pages.iterator();
                while (iterator.hasNext()) {
                    WebPage currentPage = iterator.next();
                    if (currentPage.equals(webPage)) {
                        iterator.remove();
                        break;
                    }
                }
            }
        }
    }
}