package sendARaven;

public class Main {
    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Kingdom 1");
        Kingdom kingdom2 = new Kingdom("Kingdom 2");
        Kingdom kingdom3 = new Kingdom("Kingdom 3");
        Kingdom kingdom4 = new Kingdom("Kingdom 4");

        System.out.println(kingdom1.sendMessage(kingdom2).join());
        System.out.println(kingdom3.sendMessage(kingdom4).join());

        Kingdom.shutdown();
    }
}
