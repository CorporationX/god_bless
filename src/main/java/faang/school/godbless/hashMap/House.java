package faang.school.godbless.hashMap;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

@AllArgsConstructor
public class House {

    private String name;
    private String sigil;

    @Override
    public String toString() {
        return " Название дома - " + name + " герб - " + sigil;
    }
}
