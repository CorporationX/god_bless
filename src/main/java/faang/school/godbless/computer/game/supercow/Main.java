package faang.school.godbless.computer.game.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player bilbo = new Player("Bilbo", boss);
        Player frodo = new Player("Frodo", boss);
        Player pippin = new Player("Pippin", boss);
        Player merry = new Player("Merry", boss);
        Player gimli = new Player("Gimli", boss);

        bilbo.start();
        frodo.start();
        pippin.start();
        merry.start();
        gimli.start();
    }

}
