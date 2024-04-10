package faang.school.godbless.BJS2_4277;

import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

import static faang.school.godbless.BJS2_4277.ValidateUtils.generateId;
import static faang.school.godbless.BJS2_4277.ValidateUtils.validateData;

@EqualsAndHashCode
public class Student {

    private static final Set<Long> ID = new HashSet<>();

    private Long id;
    private String name;

    public Student(String name) {
        validateData(name);
        this.id = generateId(ID);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
