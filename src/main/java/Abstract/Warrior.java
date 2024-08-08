package Abstract;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intelligent = 3;
    }

    @Override
    public void attack(Character character) {
        System.out.println(this.name + " наносит урон " +
                character.name + " в размере " +
                this.power + " очков урона");
        character.setHealth(health - this.power);
        System.out.println("игроку " + character.getName() + " нанесено "
                + this.power + " урона. Здоровья осталось: "
                + character.getHealth());
    }
}
