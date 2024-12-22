package derschrank.sprint03.task04.bjstwo_48413;


public class Staff extends Thread implements StaffInterface {
    private static final int COUNT_OF_HANDS = 2;
    private static final int DELAY_FOR_WAY_TO_KITCHEN = 7000;
    private static final int DELAY_FOR_WAY_BETWEEN_ROOMS = 1000;
    private static final int DELAY_FOR_RECEIVE_FOOD = 2000;
    private static final int TRY_TO_FILL_ALL_HANDS = 2;

    private final HouseInterface house;
    private final Food[] hands;
    private String name;

    public Staff(House house) {
        this.house = house;
        hands = new Food[COUNT_OF_HANDS];
    }

    @Override
    public void run() {
        name = Thread.currentThread().getName();
        collectFood();
    }

    @Override
    public void collectFood() {
        for (int i = 0; i < TRY_TO_FILL_ALL_HANDS; i++) {
            for (RoomInterface room : house.getRooms()) {
                if (!room.isClear()) {
                    room.knockKnock(this);
                }
                if (!hasAfreeHand()) {
                    break;
                }

                delay(DELAY_FOR_WAY_BETWEEN_ROOMS);
            }
        }

        delay(DELAY_FOR_WAY_TO_KITCHEN);
        giveAwayFood();
    }

    @Override
    public boolean hasAfreeHand() {
        for (int i = 0; i < hands.length; i++) {
            if (hands[i] == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean receiveFood(Food food) {
        for (int i = 0; i < hands.length; i++) {
            if (hands[i] == null) {
                hands[i] = food;
                delay(DELAY_FOR_RECEIVE_FOOD);
                System.out.println("Staff become leftover: " + food + ". Staff: " + name);
                return true;
            }
        }
        return false;
    }

    @Override
    public void giveAwayFood() {
        KitchenInterface kitchen = house.getKitchen();

        for (int i = 0; i < hands.length; i++) {
            if (hands[i] != null) {
                if (kitchen.receiveFood(hands[i])) {
                    hands[i] = null;
                }
            }
        }
    }

    private void delay(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println("Interrupt was in Staff: " + name);
        }
    }




}
