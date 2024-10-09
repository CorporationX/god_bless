package school.faang.task134;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Data
public class WebPage {

    private String url;
    private String title;
    private String content;
}
