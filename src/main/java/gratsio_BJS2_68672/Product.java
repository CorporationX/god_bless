package gratsio_BJS2_68672;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@ToString
public class Product {
    private int id;
    private String name;
    private Category category;
}
