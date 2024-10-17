package module_1.module_1_2_HashMap.googleSearchEngine;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
@ToString
public class WebPage {
    private String url;
    private String title;
    private String content;
}
