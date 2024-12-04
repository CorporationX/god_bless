package school.faang.task43801;

import lombok.Getter;

@Getter
public abstract class Character {
    protected static final int LOW_HP = 0;

    private boolean alive = true;
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int healthPoints = 100;

    public Character(String name) {
        checkName(name);

        this.name = name;
    }

    public Character(int intelligence, int dexterity, int strength, String name) {
        this(name);

        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.strength = strength;
    }

    protected void setHealthPoints(int healthPoints) {
        this.healthPoints = Math.max(healthPoints, 0);
    }

    protected abstract void attack(Character otherCharacter);

    protected boolean isAlive() {
        if (healthPoints == 0) {
            alive = false;
            System.out.println("Персонаж " + name + " не может атаковать, он мёртв!\n");
        }
        return alive;
    }

    protected boolean isAlive(Character character) {
        if (character.getHealthPoints() == LOW_HP) {
            character.alive = false;
            System.out.println("Персонаж " + character.getName() + " не может быть атакован, он мёртв!");
        }
        return character.alive;
    }

    private void checkName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Нужно задать имя персонажу");
        }
    }

    @Override
    public String toString() {
        return "Статус персонажа: "
                + "name='" + name + '\''
                + ", strength=" + strength
                + ", dexterity=" + dexterity
                + ", intelligence=" + intelligence
                + ", healthPoints=" + healthPoints
                + ", status=" + (alive ? "жив" : "мёртв");
    }
}
