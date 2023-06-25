package task3;

public class Archer extends Character {
    public Archer(String name, int power, int cleverness, int intelligence) {
        super(name, 3, 10, 5);
    }

    //Когда переопределяем конструктор класса, то ключевое слово (Override)
    //позволит из конструктора дочернего вызвать конструктор базового
    //и передать туда всё необходимое.

    @Override
    public void attack(Character character) {
        //Archer.attack(Warrior);
        // this это про Archer и character про Warrior, которого атакует Archer
        character.health -= this.cleverness;
    }
}








