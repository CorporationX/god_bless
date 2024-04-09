package faang.school.godbless.BJS2_5147;

public class Main {
    public static void main(String[] args) {
        Battlefield battlefield = new Battlefield();
        Hero winner = battlefield.battle();
        System.out.println(winner.getName());
    }
}
