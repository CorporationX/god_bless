package school.BJS2_29016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Main {

    //Изменил List на Set для уникальности
    private static Map<String, Set<WebPage>> mappa = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("https://en.wikipedia.org/wiki/Beatrix_of_the_Netherlands");
        WebPage webPage2 = new WebPage("https://en.wikipedia.org/wiki/Golden_Trailer_Awards");
        WebPage webPage3 = new WebPage("https://en.wikipedia.org/wiki/Mark_Rutte");
        addWebPage(webPage1);
        addWebPage(webPage2);
        addWebPage(webPage3);
        System.out.println(mappa.get("Monica"));
        for(WebPage s: getPage("Monica")){
            System.out.println(s);
        }
        removePage("https://en.wikipedia.org/wiki/Golden_Trailer_Awards");
        System.out.println(mappa.get("Monica"));
    }

    //Метод должен разбивать содержание страницы на слова, и для каждого слова добавлять веб-страницу в список, связанный с этим словом в HashMap.
    private static void addWebPage(WebPage webPage) {
        List<String> list = new ArrayList<>();
        try (InputStream response = new URL(webPage.getUrl()).openStream();
             BufferedReader in = new BufferedReader(new InputStreamReader(new URL(webPage.getUrl()).openStream()))) {
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            String title = responseBody.substring(responseBody.indexOf("<title>") + 7,responseBody.indexOf("</title>"));
            //добавляю заголовок к WebPage
            webPage.setTitle(title);
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            String webpageText = stringBuilder.toString();
            String[] words = webpageText.replaceAll("<[^>]*>", "").split("\\s+");
            for (String word : words) {
                if (word.matches("[A-Za-z]+")) {
                    list.add(word);
                }
            }
            //добавляю контент к WebPage
            webPage.setContent(list);
            for (String x : list) {
                mappa.computeIfAbsent(x, k -> new HashSet<>()).add(webPage);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //получение списка по ключевому слову
    private static List<WebPage> getPage(String word) {
        List<WebPage> list = new ArrayList<>();
        for(Map.Entry<String, Set<WebPage>> entry : mappa.entrySet()) {
            if(Objects.equals(entry.getKey(),word)) {
                list.addAll(entry.getValue());
            }
        }
        return list;
    }

    //удаление страницы по ключевому слову
    private static void removePage(String url) {
        for(Map.Entry<String, Set<WebPage>> entry : mappa.entrySet()) {
            entry.getValue().removeIf(s -> s.getUrl().equals(url));
        }
    }
}
