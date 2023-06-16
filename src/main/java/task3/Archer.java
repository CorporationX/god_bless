package task3;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(int power, int cleverness, int intelligence) {
        super(3, 10, 5);
    }

    //Когда переопределяем конструктор класса, то ключевое слово (Override)
    //позволит из конструктора дочернего вызвать конструктор базового
    //и передать туда всё необходимое.

    @Override
    //static метод нельзя было переопределять, а сейчас все можно)))
    public void attack(Character Warrior) {
        //super.attack(Warrior);
        Warrior.health -= Archer.cleverness;
    }
}
