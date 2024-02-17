package faang.school.godbless.filterinstagram;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Image {
    private String name;
    private String description;
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
