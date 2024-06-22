package faang.school.godbless.Set_the_Path;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Location {
    private double x;
    private double y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Location other = (Location) o;
        return Double.compare(other.x, this.x) == 0
                && Double.compare(other.y, this.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}
