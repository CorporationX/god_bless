package dima.evseenko.google;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebPageService webPageService = new WebPageService();
        webPageService.addWebPages(getPages());
        webPageService.printWebPages();

        System.out.println(webPageService.findWebPages("мини"));
        System.out.println(webPageService.findWebPages("java"));

        webPageService.deleteWebPage(new WebPage("https://faang-school.com/courses/4jnzmndg/92db5gpz", "Java HashMap: Кэшируем, кэшируем", "Сюжет: Вы работаете над созданием системы прогноза погоды. Ваша система должна быть способна предоставлять информацию о погоде в разных городах быстро и эффективно. Вы решаете использовать Java и HashMap для реализации кэширования информации о погоде."));
        webPageService.printWebPages();

        webPageService.deleteWebPageByUrl("https://faang-school.com/courses/4jnzmndg/n7zv2jjz");
        webPageService.printWebPages();
    }

    private static List<WebPage> getPages(){
        return List.of(
                new WebPage("https://faang-school.com/courses/4jnzmndg/xjd77jbd", "Java HashMap: Поисковый мини-движок Google", "Сюжет: Вы решили создать простой поисковой движок, который будет индексировать веб-страницы и позволять пользователям быстро находить страницы по ключевым словам. Ваша задача состоит в создании прототипа поискового движка, используя Java и HashMap для хранения и обработки данных."),
                new WebPage("https://faang-school.com/courses/4jnzmndg/vyd98gxz", "Java HashMap: Считаем прогулы", "Сюжет: Вы работаете на должности администратора в университете и получили задание создать систему учёта студентов по факультетам и курсам. Вы решаете использовать Java и HashMap для организации информации о студентах."),
                new WebPage("https://faang-school.com/courses/4jnzmndg/67zygx7z", "Java HashMap: Ловим события", "Сюжет: Вы работаете над проектом, в котором требуется обрабатывать данные от различных источников в реальном времени. Вам нужно создать структуру данных, которая будет обрабатывать и хранить данные потоковых событий, используя Java и HashMap."),
                new WebPage("https://faang-school.com/courses/4jnzmndg/vxdj8n3d", "Java HashMap: Библиотека Вестероса", "Сюжет: В королевстве Вестероса хранится огромное количество книг, и король поручил вам создать систему учёта этих книг, чтобы обеспечить легкий доступ к ним для жителей королевства. Вы решаете создать программу на Java, используя HashMap для хранения книг и их авторов."),
                new WebPage("https://faang-school.com/courses/4jnzmndg/vxzj843z", "Java HashMap: Двойной кэш-кэш", "Сюжет: Вы работаете в университете и решили создать простую систему для учёта студентов и их оценок по различным предметам. Ваша задача состоит в создании программы на Java, которая будет использовать две HashMap для хранения и обработки данных о студентах и их оценках."),
                new WebPage("https://faang-school.com/courses/4jnzmndg/n7zv2jjz", "Java HashMap: Игра престолов", "Сюжет: В мире Игры Престолов между домами Вестероса идёт борьба за Железный трон. В качестве помощника главного советника короля, вам необходимо создать систему для отслеживания домов и их гербов. Вам предстоит разработать программу, которая будет использовать HashMap для хранения информации о домах и их гербах."),
                new WebPage("https://faang-school.com/courses/4jnzmndg/92db5gpz", "Java HashMap: Кэшируем, кэшируем", "Сюжет: Вы работаете над созданием системы прогноза погоды. Ваша система должна быть способна предоставлять информацию о погоде в разных городах быстро и эффективно. Вы решаете использовать Java и HashMap для реализации кэширования информации о погоде.")
        );
    }
}
