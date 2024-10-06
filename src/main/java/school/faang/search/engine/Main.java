package school.faang.search.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String content1 = Files.readString(Path.of("src/main/resources/faang-school.txt"));
            String content2 = Files.readString(Path.of("src/main/resources/habr.txt"));
            String content3 = Files.readString(Path.of("src/main/resources/leetcode.txt"));

            var page1 = new WebPage("https://habr.com/", "Habr", content2);
            var page2 = new WebPage("https://LeetCode.com/", "LeetCode", content3);
            var page3 = new WebPage("https://faang.com/", "FaangSchool", content1);

            //Добавление
            SearchEngine searchEngine = new SearchEngine();
            searchEngine.add(page1);
            searchEngine.add(page2);
            searchEngine.add(page3);

            //поиск
            List<WebPage> pages = searchEngine.getPages("одна");
            System.out.println("Совпадения по слову одна: \n" + pages);

            //удаление
            searchEngine.remove(page2.getUrl());
            System.out.println("Совпадения по слову одна: \n" + searchEngine.getPages("одна"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
