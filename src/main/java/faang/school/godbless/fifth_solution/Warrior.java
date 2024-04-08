package faang.school.godbless.fifth_solution;

public class Warrior extends Character{

    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
        this.setPower(10);
        this.setDexterity(5);
        this.setIntelligence(3);
        this.setName(name);
    }
}
