package faang.school.godbless.javaHashMap.searcher;

public class Main {

    public static void main(String[] args) {
        WebPageService pageService = new WebPageService();

        System.out.println("Indexing new web page. Index after this:");

        WebPage page = new WebPage("nadir.cianid.com", "Masterclass of storytelling", "Mother washed a window frame. Mother frame.");
        pageService.indexWebPage(page);

        pageService.printIndex();

        System.out.println("------------------------------------");


        System.out.println("\nIndexing new web page. Index after this:");
        page = new WebPage("nadir.cianid.com", "Masterclass of storytelling", "Mother washed a window frame. Mother frame.");
        pageService.indexWebPage(page);

        pageService.printIndex();

        System.out.println("------------------------------------");


        System.out.println("\nIndexing new web page. Index after this:");
        page = new WebPage("nadir.cianid.ru", "Masterclass of storytelling 2", "Father washed a window frame. Father frame.");
        pageService.indexWebPage(page);

        pageService.printIndex();

        System.out.println("------------------------------------");

        System.out.println("\nSearch by word father:");
        System.out.println(pageService.search("father"));

        System.out.println("------------------------------------");


        System.out.println("\nResult of removing page with url \"nadir.cianid.ru\" - " + pageService.removePage("nadir.cianid.ru"));

        System.out.println("Index at this point:");
        pageService.printIndex();

        System.out.println("------------------------------------");


        System.out.println("\nResult of removing page with url \"nadir.cianid.net\" - " + pageService.removePage("nadir.cianid.net"));

        System.out.println("Index at this point:");
        pageService.printIndex();
    }
}
