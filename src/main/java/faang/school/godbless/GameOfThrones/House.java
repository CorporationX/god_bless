package faang.school.godbless.GameOfThrones;

import lombok.Getter;

import java.util.Objects;

public class House {
    private String name;
    @Getter
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;
        House house = (House) o;
        return Objects.equals(name, house.name) && Objects.equals(sigil, house.sigil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sigil);
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", sigil='" + sigil + '\'' +
                '}';
    }
}
