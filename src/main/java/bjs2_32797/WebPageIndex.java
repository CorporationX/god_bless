package bjs2_32797;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WebPageIndex {
    private WebPage page;
    private List<Node<WebPage>> list;

    public WebPageIndex(WebPage page) {
        this.page = page;
        this.list = new ArrayList<>();
    }
}
