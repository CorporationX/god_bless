package school.faang.filtersInstagram;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@NonNull
public class Image {
    private final String name;
    private final String description;
}
