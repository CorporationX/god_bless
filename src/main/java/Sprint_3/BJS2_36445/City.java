package Sprint_3.BJS2_36445;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class City {
    public String name;
    private Location location;

    public City(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public void displayCity() {
        System.out.println("City " + name + " location at ( " + location.getX() + ", " + location.getY() + ")");
    }
}
