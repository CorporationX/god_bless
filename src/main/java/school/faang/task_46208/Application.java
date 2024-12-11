package school.faang.task_46208;

public class Application {
    public static void main(String[] args) {

        Droid sender = new Droid();
        Droid receiver = new Droid();
        String msg = "Join the Rebellion!";
        int key = 3;
        String encrypted = sender.sendMessage(msg, key, null);
        String original = receiver.receiveMessage(encrypted, key, null);
    }
}

