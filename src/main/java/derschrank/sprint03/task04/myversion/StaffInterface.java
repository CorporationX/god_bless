package derschrank.sprint03.task04.myversion;

public interface StaffInterface {
    void collectFood() throws InterruptedException;

    boolean hasAfreeHand();

    boolean receiveFood(Food food);

    void giveAwayFood();
}
