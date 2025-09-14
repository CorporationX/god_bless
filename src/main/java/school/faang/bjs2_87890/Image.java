package school.faang.bjs2_87890;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Image {
    private String name;
    @Setter @Getter
    private String description;
}
