package school.faang.task_43822;

import lombok.Data;

@Data
public abstract class Character {
    protected String name;
    protected Integer power;
    protected Integer stamina;
    protected Integer iq;
    protected Integer health = 100;

    public Character(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can`t be null");
        }
        this.name = name;
    }

    public Character(String name, Integer power, Integer stamina, Integer iq) {
        if (name == null) {
            throw new IllegalArgumentException("Name can`t be null");
        }
        this.name = name;
        this.power = power;
        this.stamina = stamina;
        this.iq = iq;
    }

    public abstract void attack(Character c);

}
