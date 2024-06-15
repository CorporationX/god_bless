package faang.school.godbless.Abstraction;

public abstract class Character {
    int health = 100;
    String name;
    int power;
    int agility;
    int intelligence;

    public Character(String name) {
        this.name = name;
    }

    protected abstract void attack(Character charter);
}

    class Warrior extends Character {
    Warrior(String name) {              //задаю конструктор воину где ввожу имя воина , а его данные
        super(name);                   // сила ловкость интелект будут всегда заданны стандартно
        power = 10;
        agility = 5;
        intelligence = 3;
    }

   public void attack(Character character) {               //метод атаки для воина
        character.health = character.health - power;
    }
}

     class Archer extends Character {
    Archer(String name) {
        super(name);
        power = 3;
        agility = 10;
        intelligence = 5;
    }

    public void attack(Character character) {                    //метод атаки для лучника
        character.health= character.health - agility;
    }
}

class Test {

    public static void main(String[] args) {
        Warrior war1 = new Warrior("Knight");
        Archer archer1 = new Archer("Bowman");


        war1.attack(archer1);
        war1.attack(archer1);
        archer1.attack(war1);
        System.out.println(archer1.health);
        System.out.println(war1.health);
        System.out.println(war1.name);

    }
}

