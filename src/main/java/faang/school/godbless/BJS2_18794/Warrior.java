package faang.school.godbless.BJS2_18794;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.power;
        System.out.println(this.name + " ударил " + character.name + ". " + character.name + " имеет " + character.health + " здоровья" );
    }
}
