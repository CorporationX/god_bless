package school.BJS2_29013;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class MapKey {

    private String facultat;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapKey mapKey = (MapKey) o;
        return year == mapKey.year && Objects.equals(facultat, mapKey.facultat);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result +(facultat != null ? facultat.hashCode() : 0);
        return result;
    }
}
