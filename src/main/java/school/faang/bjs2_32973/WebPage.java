package school.faang.bjs2_32973;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class WebPage {
    private String url;
    private String title;
    private String content;
}
