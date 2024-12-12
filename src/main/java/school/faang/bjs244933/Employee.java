package school.faang.bjs244933;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private Set<String> skills;
}
