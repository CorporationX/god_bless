package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name){
        this.name = name;
    }

}
