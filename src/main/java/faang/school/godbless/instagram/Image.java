package faang.school.godbless.instagram;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Image {
    @NonNull
    private String name;
    @NonNull
    private String description;
}
