package derschrank.sprint03.task04.bjstwo_48413;

public interface StaffInterface {
    void collectFood() throws InterruptedException;

    boolean hasAfreeHand();

    boolean receiveFood(Food food);

    void giveAwayFood();
}
