package school.faang.sprint.second.hogwarts.instagram;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Image {
    @NonNull
    private String name;
    @NonNull
    private String description;
}
