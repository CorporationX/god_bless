package school.faang.bjs245148;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String category;
}
