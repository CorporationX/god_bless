package faang.school.godbless.Set_the_Path;

import lombok.Getter;

@Getter
public class Monster {

    private String name;
    private String place;
    private Location location;

    public Monster(String name, String place) {
        if (name.isBlank()) throw new IllegalArgumentException("invalid arg(s)");
        else {
            this.name = name;
            this.place = place;
        }
    }

    public Monster(String name, Location location) {
        if (name.isBlank()) throw new IllegalArgumentException("blank name");
        else {
            this.name = name;
            this.location = location;
        }
    }

    public Location getPlace() {
        switch (place) {
            case "Velen" -> {return new Location(0,90);}
            case "Toussaint" -> {return new Location(50,20);}
            case "White Orchard" -> {return new Location(120,70);}
            case "Skellige" -> {return new Location(-5,160);}
            default -> {return new Location(0,0);}
        }
    }
}
