package school.faang;

public class Warrior extends Character{

    public Warrior(String name) {
        super(name);
        super.strength =10;
        super.intellect =3;
        super.dexterity=5;
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.name + " атакует, " + target.name + " и наносит " + this.strength+ "урона");
        target.health -= this.strength;
        System.out.println(target.name+ " теперь имеет: " + target.health + " здоровья");

    }
}
