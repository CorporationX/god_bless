package school.faang.stream3.synchronization.spotify;

public class Music {
    public static void main(String[] args) {

        User firstUser = new User("Adam");
        User secondUser = new User( "Eve");
        User thirdUser = new User("Solomon");

        firstUser.startNewPlayer();
        secondUser.joinPlayer(firstUser.getPlayer());
        thirdUser.joinPlayer(secondUser.getPlayer());


    }
}
