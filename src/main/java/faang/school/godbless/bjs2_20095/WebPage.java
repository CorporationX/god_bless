package faang.school.godbless.bjs2_20095;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WebPage {
    // url is unique for each entity
    @EqualsAndHashCode.Include
    private String url;
    private String title;
    private String content;

    // it's needed to remove page from collection comparing by equals()
    public WebPage(String url) {
        this.url = url;
    }
}
