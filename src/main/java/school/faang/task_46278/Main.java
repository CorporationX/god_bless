package school.faang.task_46278;

public class Main {
    public static void main(String[] args) {
        Droid droid1 = new Droid("R2D2");
        Droid droid2 = new Droid("C3PO");
        Droid droid3 = new Droid("BB8");

        String message1 = "Hello, C3PO!";
        String message2 = "How are you, BB8?";
        String message3 = "R2D2, let's meet!";

        int key1 = 5;
        int key2 = 3;
        int key3 = 7;

        // R2D2 отправляет сообщение C3PO
        droid1.sendMessage(droid2, message1, key1);

        // C3PO отправляет сообщение BB8
        droid2.sendMessage(droid3, message2, key2);

        // BB8 отправляет сообщение R2D2
        droid3.sendMessage(droid1, message3, key3);
    }
}
