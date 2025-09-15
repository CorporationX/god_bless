package school.faang.bjs2_88680;

public class Main {
    public static void main(String[] args) {
        Droid valera = new Droid();
        Droid alesha = new Droid();

        valera.sendMessage("Привет! Как дела?", 5, alesha);
        System.out.println("----------------------------------");
        alesha.sendMessage("Привет! Дела отлично!", 7, valera);
    }
}
