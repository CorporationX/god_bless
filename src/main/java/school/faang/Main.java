package school.faang;
public class Main {
    public static void main(String[] args) {
        WebPageService webPageService = new WebPageService();
        WebPage wikiPage = new WebPage("https://ru.wikipedia.org/wiki/home_page",
                "Home_page", "Добро пожаловать в Википедию");

        WebPage youTubePage = new WebPage("https://www.youtube.com/playlist?list=WL",
                "playlist",
                "Одно или несколько видео удалены из плейлиста");
        WebPage vkPage = new WebPage("https://www.vk.ru",
                "Home_page",
                "Добро пожаловать в VK");
        WebPage instagramPage = new WebPage("https://www.instagram.com",
                "Home_page",
                "Добро пожаловать в Instagram");

        webPageService.indexWeb(wikiPage);
        webPageService.indexWeb(youTubePage);
        webPageService.indexWeb(vkPage);
        webPageService.indexWeb(instagramPage);

        webPageService.printAllWebs();

        System.out.println("===================================================");

        webPageService.printAllUrls();

        String keyWord = "Добро";
        System.out.println("Ключивое слово: " + keyWord + ", cписок страниц: " +
                webPageService.searchPages(keyWord));

        System.out.println("=====================================================");
        System.out.println("Удаляем страницу: " + vkPage);
        webPageService.deletePage(vkPage);

        webPageService.printAllWebs();
        webPageService.printAllUrls();
    }
}
