package school.faang.task_43822;

public abstract class Character {
    private String name;
    private Integer power;
    private Integer stamina;
    private Integer iq;
    private Integer health;

    public Character(String name){
        this.name = name;
        this.health = 100;
    }

    public Character(String name, Integer power, Integer stamina, Integer iq){
        this.name = name;
        this.power = power;
        this.stamina = stamina;
        this.iq = iq;
        this.health = 100;
    }

    public abstract void attack(Character c);

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public void setIq(Integer iq) {
        this.iq = iq;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", stamina=" + stamina +
                ", iq=" + iq +
                ", health=" + health +
                '}';
    }
}
