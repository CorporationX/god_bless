package school.BJS2_29016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<String, List<WebPage>> mappa = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("https://en.wikipedia.org/wiki/Beatrix_of_the_Netherlands", "Королева Нидерландов", "В апреле 1999 года познакомилась с принцем Виллем-Александром на частной вечеринке в Испании. 31 марта 2001 года королева Нидерландов Беатрикс и принц Клаус объявили о помолвке своего старшего сына, принца Оранского Виллема-Александра, и Максимы Соррегьеты. 17 мая 2001 года Максима стала подданной Нидерландов. С 1 сентября по 14 ноября 2001 года Максима и Виллем-Александр побывали в турне по городам Нидерландов.\n" +
                "\n" +
                "Чтобы свадьба могла состояться, наследнику престола было необходимо получить официальное разрешение парламента. Многие парламентарии выступали против брака принца с дочерью министра режима диктатора Виделы, за время правления которого были репрессированы тысячи аргентинцев. В итоге разрешение было получено, но Максиме пришлось смириться с тем, что её родители не будут присутствовать на свадьбе.");
        WebPage webPage2 = new WebPage("https://en.wikipedia.org/wiki/Golden_Trailer_Awards", "Золотой трейлер", "Основное соревнование проводится между трейлерами различных кинофильмов. Монтажёры, создающие трейлер из готового материала, должны продемонстрировать небольшую часть истории, но так, чтобы, с одной стороны, привлечь внимание зрителя к выходящему фильму, а с другой, — оставить впечатление, что самое интересное будет показано в фильме. Конкурс состоит из более 60 категорий, в которых участвуют трейлеры как высокобюджетных блокбастеров, так и независимых фильмов. Аналогично, фильмы сильно различаются и по жанрам: от фильмов для всей семьи и мультфильмов и до ромкомов, в том числе и ужасы, триллеры и трэш.");
        WebPage webPage3 = new WebPage("https://en.wikipedia.org/wiki/Mark_Rutte", "Генсек НАТО", "Девятая статья Североатлантического договора требует от членов НАТО «создать Совет, в котором будет представлен каждый из них».  Соответственно, был сформирован Североатлантический совет. Первоначально Совет состоял из министров иностранных дел стран-членов НАТО и собирался ежегодно. В мае 1950 года стремление к более тесной координации на ежедневной основе привело к назначению депутатов Совета, постоянно базирующихся в Лондоне и наблюдающих за работой организации. Депутатам были предоставлены все полномочия по принятию решений в Североатлантическом совете, но их работа дополнялась время от времени встречами министров иностранных дел стран НАТО. На председателя заместителей была возложена ответственность «за руководство организацией и ее работой», включая все ее гражданские органы.");
        addWebPage(webPage1);
        addWebPage(webPage2);
        addWebPage(webPage3);
        System.out.println(mappa.get("НАТО"));
        System.out.println("---------------------------------------");
        for (WebPage s : getPage("от")) {
            System.out.println(s);
        }
        System.out.println("---------------------------------------");
        removePageWithUrl("https://en.wikipedia.org/wiki/Mark_Rutte");
        System.out.println(mappa.get("НАТО"));
    }

    //Метод должен разбивать содержание страницы на слова, и для каждого слова добавлять веб-страницу в список, связанный с этим словом в HashMap.
    private static void addWebPage(WebPage webPage) {
        String[] contents = webPage.getContent().split(" ");
        for (String content : contents) {
            if (!mappa.containsKey(content)) {
                mappa.computeIfAbsent(content, k -> new ArrayList<>()).add(webPage);
            } else {
                if (!mappa.get(content).contains(webPage)) {
                    mappa.get(content).add(webPage);
                }
            }
        }
    }

    //получение списка по ключевому слову
    private static List<WebPage> getPage(String word) {
        return mappa.get(word);
    }

    //удаление страницы по url
    private static void removePageWithUrl(String url) {
        for (Map.Entry<String, List<WebPage>> entry : mappa.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                entry.getValue().removeIf(s -> s.getUrl().equals(url));
            } else {
                entry.getValue().add(null);
                entry.getValue().removeIf(s -> s.getUrl().equals(url));
            }
        }
    }
}
