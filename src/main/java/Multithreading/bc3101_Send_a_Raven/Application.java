package Multithreading.bc3101_Send_a_Raven;

public class Application {
    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Kingdom1", "Hello");
        Kingdom kingdom2 = new Kingdom("Kingdom2", "Privet");

        kingdom1.sendRaven(kingdom1, kingdom2);
    }
}
