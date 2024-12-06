package school.faang.dismantlingtheamazonwarehouse45131;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor

public class Product {
    private int id;
    private String name;
    private String category;
}
