package faang.school.godbless.game_of_thrones;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class House {

    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(name, house.name) && Objects.equals(sigil, house.sigil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sigil);
    }
}
