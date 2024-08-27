package ru.kraiush.lambda.BJS2_21037;

import java.util.Collections;

public class AppDruidsCommunicate {

    public static void main(String[] args) {

        String message = "learning is funny";
        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println("\nMessage to send: \n" + message);

        DruidProducer druidProducer = new DruidProducer();

        String sended = druidProducer.sendEncryptedMessage(message, 77);
        sended = sended.replaceAll("[\\s]{2,}", " ");
        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println("\nEncrypted sended message: \n" + sended);

        DruidReceiver druidReceiver = new DruidReceiver();

        String receive = druidReceiver.receiveEncryptedMessage(sended, 77);
        receive = receive.replaceAll("[\\s]{2,}", " ");
        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println("\nEncrypted received message: \n" + receive);
        System.out.print(String.join("", Collections.nCopies(80, "-")));
    }
}
