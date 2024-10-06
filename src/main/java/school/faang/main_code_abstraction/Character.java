package school.faang.main_code_abstraction;

import lombok.Data;

@Data
public abstract class Character implements  Attacing{
    private String name;
    private int dexterity;
    private int strengh;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strengh, int dexterity, int intelligence) {
        this.name = name;
        this.strengh = strengh;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    @Override
    public void couseDamage(int damage) {
        this.health -= damage;
    }
}