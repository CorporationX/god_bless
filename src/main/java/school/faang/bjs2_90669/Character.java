package school.faang.bjs2_90669;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@EqualsAndHashCode
@Setter
@AllArgsConstructor
public class Character {

    private final String name;
    private List<Item> inventory;


}

