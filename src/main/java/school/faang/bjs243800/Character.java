package school.faang.bjs243800;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int health = 100;
    private int strange;
    private int agility;
    private int mind;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strange, int agility, int mind) {
        this.strange = strange;
        this.name = name;
        this.agility = agility;
        this.mind = mind;
    }

    @Override
    public String toString() {
        return String.format("Hero{name='%s', strange='%d', agility='%d', mind='%d'}", name, strange, agility, mind);
    }

    protected void dealingDamadge(Character character, int damadge) {
        character.health -= damadge;
    }

    protected abstract void attack(Character character);
}
