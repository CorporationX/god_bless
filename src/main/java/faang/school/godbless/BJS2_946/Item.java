package faang.school.godbless.BJS2_946;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Item {
    private String name;
    private int value;

    public String toString(){
        return getName()+", "+getValue();
    }
}
