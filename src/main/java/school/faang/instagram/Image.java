package school.faang.instagram;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Image {
    private String name;
    @Setter
    private String description;
}
