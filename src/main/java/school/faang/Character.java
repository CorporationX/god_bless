package school.faang;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int health = 100;
    protected int strange;
    protected int agility;
    protected int mind;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strange, int agility, int mind) {
        this.name = name;
        this.strange = strange;
        this.agility = agility;
        this.mind = mind;
    }

    protected void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    protected abstract void attack(Character target);

    @Override
    public String toString() {
        return String.format(
                "Character{name='%s', health=%d, strange=%d, agility=%d, mind=%d}",
                name, health, strange, agility, mind
        );
    }
}
