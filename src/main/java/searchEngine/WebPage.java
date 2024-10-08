package searchEngine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;
}
