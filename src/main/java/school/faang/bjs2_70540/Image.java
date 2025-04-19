package school.faang.bjs2_70540;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
class Image {
    private final String name;
    @Setter
    private String description;
}
