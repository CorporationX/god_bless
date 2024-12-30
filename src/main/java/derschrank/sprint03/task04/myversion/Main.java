package derschrank.sprint03.task04.myversion;

public class Main {
    private static final String SPLITTER = "==============================";
    private static final int COUNT_OF_ROOMS = 10;
    private static final int COUNT_OF_STAFFS = 10;

    public static void main(String[] args) {
        HouseInterface hotel = new House(COUNT_OF_ROOMS);

        System.out.println(SPLITTER);
        System.out.println(hotel);

        hotel.collectFood();

        System.out.println(SPLITTER);
        System.out.println(hotel);
    }
}
