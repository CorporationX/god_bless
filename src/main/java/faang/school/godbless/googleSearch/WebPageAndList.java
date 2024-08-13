package faang.school.godbless.googleSearch;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class WebPageAndList {
    private WebPage webPage;
    private List<Node> nodesList;
}
