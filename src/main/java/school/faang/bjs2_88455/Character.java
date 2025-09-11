package school.faang.bjs2_88455;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Character {
    private final String name;
    private ArrayList<Item> inventory = new ArrayList<>();
}
