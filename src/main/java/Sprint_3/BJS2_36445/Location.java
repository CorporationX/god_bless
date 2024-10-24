package Sprint_3.BJS2_36445;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void Location() {
        System.out.println("Location: " + x + ", " + y);
    }
}
