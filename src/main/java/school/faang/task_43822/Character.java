package school.faang.task_43822;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private Integer power;
    private Integer stamina;
    private Integer iq;
    private Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer power, Integer stamina, Integer iq) {
        this.name = name;
        this.power = power;
        this.stamina = stamina;
        this.iq = iq;
    }

    public abstract void attack(Character c);


    @Override
    public String toString() {
        return "Character{"
                + "name='" + name + '\''
                + ", power=" + power
                + ", stamina=" + stamina
                + ", iq=" + iq
                + ", health=" + health
                + '}';
    }
}
