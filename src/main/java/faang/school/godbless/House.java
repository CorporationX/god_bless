package faang.school.godbless;

import java.util.Objects;

public class House {
    private final String name;
    private final String sigil;

    public House(String houseName, String sigil) {
        this.name = houseName;
        this.sigil = sigil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(name, house.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", sigil='" + sigil + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }
}
