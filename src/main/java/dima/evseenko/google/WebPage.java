package dima.evseenko.google;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;

    public Set<String> getKeywords() {
        String keywords = getTitle()+" "+getContent();
        keywords = keywords.replace("!", "");
        keywords = keywords.replace("-", " ");
        keywords = keywords.replace(".", "");
        keywords = keywords.replace(",", "");
        keywords = keywords.replace(":", "");

        return new HashSet<>(List.of(keywords.trim().toLowerCase().split(" ")));
    }
}
