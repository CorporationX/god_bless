package Abstract;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        power = 3;
        agility = 10;
        intelligent= 5;
    }

    @Override
    public void attack(Character character) {
        System.out.println(this.name + " наносит урон " +
                character.getName() + " в размере " +
                this.agility + " очков урона");
        character.setHealth(character.health - this.agility);
        System.out.println("игроку " + character.getName() + " нанесено "
                + this.agility + " урона. Здоровья осталось: "
                + character.getHealth());
    }
}
