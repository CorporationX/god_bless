package school.faang.functional_interfaces__lambdas.bjs2_87385;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encriptionKey1 = 3;
        int encriptionKey2 = 7;

        // R2D2 отправляет сообщение C3PO
        r2d2.sendMessage(c3po, message1, encriptionKey1);

        // C3PO отвечает R2D2
        c3po.sendMessage(r2d2, message2, encriptionKey2);

        // BB-8 отправляет сообщение C3PO
        bb8.sendMessage(c3po, "The mission is complete.", encriptionKey1);
    }
}
