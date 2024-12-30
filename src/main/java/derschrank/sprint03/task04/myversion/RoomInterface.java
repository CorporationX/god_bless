package derschrank.sprint03.task04.myversion;

public interface RoomInterface {
    void receiveFood(Food food);

    void knockKnock(Staff staff);

    boolean isClear();

    String getNumber();

    int getCountOfFood();
}
