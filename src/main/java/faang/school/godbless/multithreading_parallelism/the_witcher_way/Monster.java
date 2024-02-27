package faang.school.godbless.multithreading_parallelism.the_witcher_way;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Monster {
    private String name;
    private String villageLocation;
    private Location location;

    public Monster(String name, String villageLocation) {
        this.name = name;
        this.villageLocation = villageLocation;
    }

    public Location getCoordinates(){
        switch (villageLocation){
            case "Velen" -> {
                return new Location(0, 90);
            }
            case "Toussaint" -> {
                return new Location(50, 20);
            }
            case "White Orchard" -> {
                return new Location(120, 70);
            }
            case "Skellige" -> {
                return new Location(-50, 160);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}
