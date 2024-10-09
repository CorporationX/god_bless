package school.faang.bjs2_32870;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class WebPage {
    private final String url;
    private final String title;
    private final String content;


    @Override
    public String toString() {
        return "{" + url + " | " + title + " | " + content + "}";
    }
}
