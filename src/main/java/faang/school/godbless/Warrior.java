package faang.school.godbless;

public class Warrior extends Character{
    super.force = 10;
    dexterity = 5;
    intelligence = 3;

    @Override
    public Warrior(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException(name + " Illegal name");
        }
    }
}
