package school.faang.instagram;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
public class Image {
    private final String name;
    private String description;
}


