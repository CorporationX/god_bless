package faang.school.godbless.multithreading.supercow;

public record Player(String name) {

    public void startBattle(Boss boss) {
        System.out.println("Игрок " + name + " присоединяется к сражению с боссом");
        boss.joinBattle(new Player(name));
        System.out.println("Игрок " + name + " присоединился к сражению с боссом");
    }
}
