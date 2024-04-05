package faang.school.godbless.bjs2_4523;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Subject {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "'" + name + '\'';
    }
}
