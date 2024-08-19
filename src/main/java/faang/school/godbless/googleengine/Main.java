package faang.school.godbless.googleengine;

public class Main {

    public static void main(String[] args) {
        WebPageService webPageService = new WebPageService();

        WebPage habr1 = new WebPage("https://habr.com/ru/companies/rosbank/articles/695360/",
                "Spring Data JPA: метод save и границы его применимости",
                "... На митапе Росбанка и Jug.ru я рассказывал о том, как устроен метод " +
                        "Save в Spring Data JPA, почему он может вызвать лишний select, как решить " +
                        "эту проблему и при чем здесь доменные события Spring. Здесь я поделюсь " +
                        "этой информацией с вами.");

        WebPage habr2 = new WebPage("https://habr.com/ru/articles/580044/",
                "Внутренняя работа HashMap в Java",
                "статья родилась и выросла из довольно небольшой и не претендующей на откровение " +
                        "оптимизации сайта, описанного в другом материале. Сайт этот связан с музыкальной " +
                        "тематикой и, соответственно, активно отображает обложки альбомов, хранящиеся " +
                        "(до поры до времени) на сервере не в ФС, как обычно бывает, а в БД SQL Server " +
                        "(в BLOB-поле, о чём несложно догадаться); в старом варианте пора извлечения " +
                        "изображений из базы и сохранения их в виде файлов возникает в момент запроса " +
                        "альбомов пользователем, после чего (по истечении сессии) они удаляются.");

        System.out.println(webPageService.createIndex(habr1));

        webPageService.createIndex(habr2);

        System.out.println(); System.out.println();

        System.out.println(webPageService.findPageByWord("доменные"));

        System.out.println();

        System.out.println(webPageService.findPageByWord("истечении"));

        webPageService.removeWebPageByURL("https://habr.com/ru/articles/580044/");

        System.out.println(); System.out.println();

        System.out.println(webPageService.findPageByWord("истечении"));
    }

}
