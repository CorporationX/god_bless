package faang.school.godbless.bjs2_8413;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {

  private static final Pattern WORDS_SEPARATOR_REGEX = Pattern.compile("[^a-z A-Z а-я]+", Pattern.UNICODE_CHARACTER_CLASS);

  private static final Map<String, List<WebPage>> webPages = new HashMap<>();

  public static void main(String[] args) {
    List<String> l = List.of("привет", "Привет");

    l.forEach(s -> System.out.println(s));
//    String[] sss = {"привет", "Привет"};
//    System.out.println(sss);





    WebPage ggg = new WebPage("https://testOne.com", "ddddd", "test2 test1 test3 test4");

    method(ggg);
  }

  private static void method(WebPage webPage) {
    String[] words = webPage.getContent().split(String.valueOf(WORDS_SEPARATOR_REGEX));
    for (String s : words) {
      System.out.println(s);
    }
  }

}
