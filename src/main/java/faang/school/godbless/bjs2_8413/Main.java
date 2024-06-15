package faang.school.godbless.bjs2_8413;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
  private static final String WORDS_SEPARATOR_REGEX = "\\W+";
  private static final String EMPTY = "";
  private static final String KEYWORD = "Ключевое слово - ";
  private static final String WEBSITE = " Сайт: ";

  private static final Map<String, List<WebPage>> webPages = new HashMap<>();

  public static void main(String[] args) {

    WebPage firsPage = new WebPage("https://testOne.com", "testOn", "Java, String, Integer, Long");
    WebPage secondPage = new WebPage("https://testTwo.com", "testTwo", "Interface, Class, Java, Best");
    WebPage thirdPage = new WebPage("https://testThree.com", "testThree", "JAVA, VOID, API, Class");
    WebPage fourthPage = new WebPage("https://testFour.com", "testFour", "Stream, Optional, API, Class");
    WebPage fifthPage = new WebPage("https://delete.com", "delete", "delete, Stream, Class, Long");

    addWebPage(firsPage);
    addWebPage(secondPage);
    addWebPage(thirdPage);
    addWebPage(fourthPage);
    addWebPage(fifthPage);

    System.out.println(searchWebPage("JAVA"));

    showAllWebPages();

    deleteWebPage("https://delete.com");

    showAllWebPages();

    addWebPage(fifthPage);

    showAllWebPages();
  }

  private static void addWebPage(WebPage webPage) {
    var words = Arrays.stream(webPage.content().split(WORDS_SEPARATOR_REGEX))
        .filter(str -> !str.isBlank())
        .map(String::toLowerCase)
        .toList();
    words.forEach(word -> webPages.computeIfAbsent(word, webPages -> new ArrayList<>())
          .add(webPage));
  }

  private static List<WebPage> searchWebPage(String word) {
    return webPages.get(word.toLowerCase());
  }

  private static void deleteWebPage(String url) {
    final String currentUrl = Optional.ofNullable(url)
        .orElse(EMPTY);
    final var iterator = webPages.entrySet().iterator();
    while (iterator.hasNext()) {
      final var webPages = iterator.next().getValue();
      webPages.removeIf(page -> currentUrl.equals(page.url()));
      if (webPages.isEmpty()) {
        iterator.remove();
      }
    }
  }

  private static void showAllWebPages() {
    webPages.forEach((key, value) -> System.out.println(KEYWORD + key + WEBSITE + value));
  }

}
