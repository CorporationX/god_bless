package school.faang.droidsecrets;

public class Main {
    public static void main(String[] args) {
        // Создаём трёх дроидов
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        // Оригинальные сообщения
        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";

        // R2D2 отправляет сообщение C3PO
        r2d2.sendMessage(c3po, message1, 3);

        // C3PO отвечает R2D2
        c3po.sendMessage(r2d2, message2, 5);

        // BB-8 отправляет сообщение C3PO
        bb8.sendMessage(c3po, "The mission is complete.", 7);
    }
}

