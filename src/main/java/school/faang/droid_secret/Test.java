package school.faang.droid_secret;

public class Test {
    public static void main(String[] args) {
        Droid gonzo88 = new Droid();
        Droid gonzo14 = new Droid();

        // Отправка сообщения от r2d2 к c3po
        gonzo88.sendMessage("Здравствуй gonzo14!", 5, gonzo14);

        // Отправка сообщения от c3po к r2d2
        gonzo14.sendMessage("Как сам, gonzo88", 3, gonzo88);
    }
}
