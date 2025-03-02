package school.faang.superherobattle;

import lombok.AllArgsConstructor;

public record Superhero(String name, int strength, int agility) {

    public int getPower() {
        return (strength() + agility());
    }

}
