package school.faang.T32879;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    Map<String, List<WebPage>> google = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();

        main.indexNewPage(new WebPage("url1", "Title 1", "word word11 word12 word13 1"));
        main.indexNewPage(new WebPage("url2", "Title 2", "word word21 word22 word33 2"));
        main.indexNewPage(new WebPage("url1", "Title 3", "word word21 word22 word33 3"));

        main.printAll();

        String kWord = "sjh";
        System.out.printf("\n Get List by key word %s. List: %s", kWord, main.getContentByWord(kWord).toString());

        main.deleteContextByUrl("url1");
        main.printAll();
    }

    public void indexNewPage(WebPage webPage) {
        String[] indexWords = webPage.getContent().split(" ");
        Arrays.stream(indexWords).forEach(s -> {
            google.putIfAbsent(s, new ArrayList<>());
            google.get(s).add(webPage);
        });
    }

    public List<WebPage> getContentByWord (String keyWord){
        return google.get(keyWord);
    }


    public void deleteContextByUrl(String url){
        KeyWordAndWebPage keyWordAndWebPage;
        keyWordAndWebPage = new KeyWordAndWebPage(null, null);
    }

    private KeyWordAndWebPage deleteCalculation(KeyWordAndWebPage keyWordAndWebPage, String url)
    {
        Map.Entry<String,> google.entrySet()

                forEach((kWord, webPages) -> {

            for (WebPage tempWebPage : webPages) {
                if(tempWebPage.getUrl().equals(url)) {
                    KeyWordAndWebPage keyWordAndWebPage1 = new KeyWordAndWebPage(kWord, tempWebPage);
                    return keyWordAndWebPage1;
                };
            };
        });
        return keyWordAndWebPage;
    }



    public void printAll() {
        google.forEach((s, webPages) -> System.out.printf("KeyWord: %s === Context : %s\n", s, webPages.toString()));
    }
}