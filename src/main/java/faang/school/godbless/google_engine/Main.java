package faang.school.godbless.google_engine;

public class Main {

    public static void main(String[] args) {
        WebPageService webPageService = new WebPageService();
        webPageService.addNewPage(new WebPage("google.com", "google", "car house phone code"));
        webPageService.addNewPage(new WebPage("yandex.ru", "yandex", "car, market engine"));
        webPageService.addNewPage(new WebPage("github.com", "github", "pull request merge"));
        System.out.println(webPageService.findAllWebPagesByKeyword("car"));
    }

}
