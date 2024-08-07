package faang.school.godbless.BJS2_19305;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Pair {
    private String first;
    private Integer second;

    @Override
    public String toString() {
        return "faculty: " + first +
                ", year of study: " + second;
    }
}
