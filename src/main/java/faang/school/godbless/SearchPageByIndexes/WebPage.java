package faang.school.godbless.SearchPageByIndexes;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@AllArgsConstructor
public class WebPage {
    @EqualsAndHashCode.Include
    private String url;

    private String title;
    private String content;
}
