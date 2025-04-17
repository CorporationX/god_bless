package school.faang.bjs270086;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
public class Item {
    private String name;
    private @Setter int price;
}
