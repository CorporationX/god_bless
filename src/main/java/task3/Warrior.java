package task3;

public class Warrior extends Character {
    public Warrior(String name, int power, int cleverness, int intelligence) {
        super(name, 10, 5, 3);
    }
    //Когда переопределяем конструктор класса, то (Override) ключевое слово
    //позволит из конструктора дочернего вызвать конструктор базового
    //и передать туда всё необходимое

    @Override
    public void attack(Character character) {
        //super.attack(Archer);
        character.health -= this.power;
    }
}
