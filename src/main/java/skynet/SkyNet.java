package skynet;

public class SkyNet {
    public static void main(String[] args) {
        Robot target1 = new Robot("target1");
        Robot target2 = new Robot("target2");

        new Thread(target1::attack).start();
        new Thread(target2::attack).start();
    }
}
