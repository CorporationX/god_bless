package Abstract;

public class Warrior extends Character {


    //если передаю все поля в super, то они не инициализируются и запрашиваются при создании объекта,
    //разве не проще запрашивать только имя, а остальное инициализировать как у меня?
    public Warrior(String name, int power, int  agility, int intelligent) {
        super(name, power = 10, agility = 5, intelligent = 3);
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
