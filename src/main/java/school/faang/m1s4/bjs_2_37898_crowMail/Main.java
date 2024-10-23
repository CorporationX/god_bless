package school.faang.m1s4.bjs_2_37898_crowMail;

public class Main {
    public static void main(String[] args) {
        Kingdom lannister = new Kingdom("Lannister");
        Kingdom stark = new Kingdom("Stark");

        for (int i = 0; i < 10; i++) {
            lannister.sendRaven(stark);
        }

        Kingdom.shutdownPool();

    }
}
