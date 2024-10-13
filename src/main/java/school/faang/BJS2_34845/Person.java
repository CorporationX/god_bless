package school.faang.BJS2_34845;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Person implements Comparable<Person> {
    private String name;
    private List<Person> friends;

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.getName());
    }
}
