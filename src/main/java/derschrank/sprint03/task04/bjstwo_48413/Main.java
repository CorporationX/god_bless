package derschrank.sprint03.task04.bjstwo_48413;

public class Main {
    private static final String SPLITTER = "\n==============================";
    private static final int COUNT_OF_ROOMS = 10;
    private static final int COUNT_OF_STAFFS = 10;

    public static void main(String[] args) {
        HouseInterface hotel = new House();

        System.out.println(SPLITTER);
        System.out.println(hotel);

        System.out.println(SPLITTER);
        hotel.collectAllFood();

        System.out.println(SPLITTER);
        System.out.println(hotel);
    }
}
