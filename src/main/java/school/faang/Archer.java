package school.faang;

import lombok.NonNull;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setPower(3);
        this.setDexterity(10);
        this.setIntelligence(5);
    }

    @Override
    public void attack(@NonNull Character character) {
        this.setHealth(this.getHealth() - character.getPower());
    }
}
