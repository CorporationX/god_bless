package filterSpam_806;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<MessageFilter> filters = new ArrayList<>();

    public static void main(String[] args) {

        MessageProcessor messageProcessor = new MessageProcessor();

        filters = Arrays.asList(
                (message) -> message.toLowerCase().contains("спам"),
                (message) -> message.isBlank(),
                (message) -> message.length() < 4
        );

        messageProcessor.processMessage("СПАМ", filters);
        messageProcessor.processMessage("Привет, могу позвонить?", filters);
        messageProcessor.processMessage("", filters);
    }
}