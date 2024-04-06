package faang.school.godbless.BJS2_4276;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

import static faang.school.godbless.BJS2_4276.ValidateUtils.generateId;
import static faang.school.godbless.BJS2_4276.ValidateUtils.validateStringData;

@Getter
public class User {

    private static final Set<Long> ID = new HashSet<>();

    private Long id;
    private String name;

    public User(String name) {
        validateStringData(name);
        this.id = generateId(ID);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + " " +
                "Name: " + this.getName();
    }
}
