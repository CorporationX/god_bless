package bjs2_29009;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
@ToString
public class Product {
    private final int id;
    private String name;
    private String category;
}
