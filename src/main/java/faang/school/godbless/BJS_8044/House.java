package faang.school.godbless.BJS_8044;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class House {
    private String name;
    private String crest;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return name.equals(house.name) && crest.equals(house.crest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
