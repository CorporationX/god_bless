package school.faang.bjs2_70098;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
class Item {
    private final String name;
    @Setter
    private Integer value;
}
