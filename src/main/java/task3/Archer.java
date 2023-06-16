package task3;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(int power, int cleverness, int intelligence) {
        super(3, 10, 5);
    }

    //Когда переопределяем конструктор класса, то какое ключевое слово
    // позволит из конструктора дочернего вызвать конструктор базового
    // и передать туда всё необходимое
    @Override

}
