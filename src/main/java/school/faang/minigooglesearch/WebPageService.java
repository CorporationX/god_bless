package school.faang.minigooglesearch;

import java.util.*;

public class WebPageService {

    public void addWebPage(WebPage webPage, Map<String, List<WebPage>> webPages){
        String[] keyWords = webPage.getContent().toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");

        for(String s : keyWords){
            webPages.putIfAbsent(s, new ArrayList<>());
            webPages.get(s).add(webPage);
        }
    }

    public List<WebPage> findWebPages(String string, Map<String, List<WebPage>> webPages){
        return webPages.get(string.toLowerCase());
    }

    public void removeWebPageByUrl(WebPage webPage, Map<String, List<WebPage>> webPages){
        String[] keyWords = webPage.getContent().toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");

        for(String keyWord : keyWords){

            List<WebPage> pages = webPages.get(keyWord);
            Iterator<WebPage> iterator = pages.iterator();

            while(iterator.hasNext()){
                WebPage currentWebPage = iterator.next();
                if(Objects.equals(currentWebPage.getUrl(), webPage.getUrl())){
                    iterator.remove();
                    break;
                }
            }

            if (pages.isEmpty()) {
                webPages.remove(keyWord);
            }
        }
    }
}
