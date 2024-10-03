package school.faang;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        super.strength =3;
        super.intellect =5;
        super.dexterity=10;
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " атакует,  " + target.name + "и наносит " + this.strength+ " урона");
        target.health -= this.strength;
        System.out.println(target.name+ " теперь имеет  " + target.health +" здоровья");

    }
}
