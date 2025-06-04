package school.faang.amazon79806;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {
   private int id;
   private Category category;
   private String name;
}
