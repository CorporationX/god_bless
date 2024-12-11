package school.faang.bjs244933;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employee {
    private int id;//: уникальный идентификатор сотрудника;
    private String name;//: имя сотрудника;
    private Set<String> skills;//: набор навыков сотрудника.
}
