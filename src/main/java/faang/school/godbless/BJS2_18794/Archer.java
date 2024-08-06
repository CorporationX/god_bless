package faang.school.godbless.BJS2_18794;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
        System.out.println(this.name + " ударил " + character.name + ". " + character.name + " имеет " + character.health + " здоровья" );
    }
}
