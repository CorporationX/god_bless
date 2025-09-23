package school.faang.bjs2_92603;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Kingdom winterfell = new Kingdom("Winterfall");
        Kingdom kingsLanding = new Kingdom("King's Landing");
        Kingdom highgarden = new Kingdom("Highgarden");

        sendMessageWithHandle(winterfell, kingsLanding);
        sendMessageWithHandle(kingsLanding, highgarden);
        sendMessageWithHandle(highgarden, winterfell);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void sendMessageWithHandle(Kingdom sender, Kingdom receiver) {
        Kingdom.sendRaven(sender, receiver)
                .handle((result, exception) -> {
                    if (exception != null) {
                        log.error("Error delivery: {}", exception.getMessage());
                        return "Message not delivered from " + sender.getName() +
                                " в " + receiver.getName();
                    } else {
                        System.out.println(result);
                        return result;
                    }
                });
    }
}