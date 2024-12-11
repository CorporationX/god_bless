package school.faang.bjs245603.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();
}
