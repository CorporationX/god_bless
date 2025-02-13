package school.faang.sprint2.lambda.instagramfilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Image {
    private final String name;
    private String description;
}
