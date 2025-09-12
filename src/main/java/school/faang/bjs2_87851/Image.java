package school.faang.bjs2_87851;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(includeFieldNames = true)
@Getter
@AllArgsConstructor
public class Image {
    private final String name;
    private final String description;
}
