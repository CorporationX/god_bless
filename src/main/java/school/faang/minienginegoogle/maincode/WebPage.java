package school.faang.minienginegoogle.maincode;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WebPage {
    private String url;
    private String title;
    private String context;
}