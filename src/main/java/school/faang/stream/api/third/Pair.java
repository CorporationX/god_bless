package school.faang.stream.api.third;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Pair {
    private final String firstPerson;
    private final String secondPerson;

    public Pair(String firstPerson, String secondPerson) {
        if (firstPerson.compareTo(secondPerson) < 0) {
            this.firstPerson = firstPerson;
            this.secondPerson = secondPerson;
        } else {
            this.firstPerson = secondPerson;
            this.secondPerson = firstPerson;
        }
    }

    @Override
    public String toString() {
        return "(" + firstPerson + ", " + secondPerson + ")";
    }
}
