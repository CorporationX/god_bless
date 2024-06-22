package faang.school.godbless.Set_the_Path;

import lombok.Getter;

@Getter
public class Monster {

    private String name;
    private String location;

    public Monster(String name, String location) {
        if (name.isBlank()) throw new IllegalArgumentException("invalid arg(s)");
        else {
            this.name = name;
            this.location = location;
        }
    }

    public Location getLocation() {
        switch (location) {
            case "Velen" -> {return new Location(0,90);}
            case "Toussaint" -> {return new Location(50,20);}
            case "White Orchard" -> {return new Location(120,70);}
            case "Skellige" -> {return new Location(-5,160);}
            default -> {return new Location(0,0);}
        }
    }
}
