package faang.school.godbless.lambda.instagram;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Image {
    @Getter
    private String name;
    private String description;
}
