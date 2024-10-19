package school.faang.ironthroneatallcosts;

public class Main {

    public static void main(String[] args) {
        House starkHouse = new House();
        House lannisterHouse = new House();

        User john = new User("John Snow", starkHouse, "Stark");
        User tyrion = new User("Tyrion Lannister", lannisterHouse, "Lannister");
        User newLannisterLord = new User("New Lannister Lord", lannisterHouse, "Lannister");

        Thread johnThread = new Thread(john);
        Thread tyrionThread = new Thread(tyrion);
        Thread newLannisterLordThread = new Thread(newLannisterLord);

        johnThread.start();
        tyrionThread.start();

        try {
            Thread.sleep(1000);

            newLannisterLordThread.start();

            johnThread.join();
            tyrionThread.join();
            newLannisterLordThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
