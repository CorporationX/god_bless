package faang.school.godbless;

public abstract class Character {

    private String name;
    private String power;
    private String mind;
    private Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, String power, String mind) {
        this.name = name;
        this.power = power;
        this.mind = mind;
    }
}
