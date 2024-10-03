package school.faang.searchEngine;

public class Main {
  public static void main(String[] args) {

    WebPage webPage1 = new WebPage("url1", "page1", "123 asd zxc qwe");
    WebPage webPage2 = new WebPage("url2", "page2", "1233 asdd zxcz qwee");
    WebPage webPage3 = new WebPage("url3", "page3", "1234 asdw zxcz qwez");
    WebPage webPage4 = new WebPage("url3", "page3", "qwe asdw zxcz 123");
    WebPage webPage5 = new WebPage("url3", "page3", "1234 asdw 123 qwez");

    WebPageRepository webPageRepository = new WebPageRepository();

    webPageRepository.indexingPage(webPage1);
    webPageRepository.indexingPage(webPage2);
    webPageRepository.indexingPage(webPage3);
    webPageRepository.indexingPage(webPage4);
    webPageRepository.indexingPage(webPage5);

    System.out.println(webPageRepository.searchPages("123"));
    System.out.println(webPageRepository.searchPages("zxc"));
    System.out.println(webPageRepository.searchPages("qwez"));

    webPageRepository.removePage("url2");
    System.out.println(webPageRepository.searchPages("1233"));

    System.out.println(webPageRepository.getWebPages());

  }
}
