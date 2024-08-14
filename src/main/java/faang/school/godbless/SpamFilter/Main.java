package faang.school.godbless.SpamFilter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter<String> spamFilter = message -> message.toLowerCase().contains("spam");
        MessageFilter<String> lengthFilter = message -> message.length() > 15;
        MessageFilter<String> emojiFilter = message -> message.contains("😀");
        MessageFilter<String> rickRollFilter = message -> message.contains("never gonna give you up");

        //Представим что картинки проанализировала наша система
        MessageFilter<Image> explicitImageFilter = image -> image.getDescription().contains("explicit");
        MessageFilter<Image> advertisementFilter = image -> image.getDescription().contains("advertisement");

        List<MessageFilter> messageFilters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Hello!", "This is spam!", "What's going on? 😀", "A long message without spam or emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, messageFilters);
            System.out.println("Message: " + message + " | Skipped (filtered): " + isFiltered);
        }

        List<MessageFilter> imageFilters = Arrays.asList(explicitImageFilter, advertisementFilter);

        List<Image> images = Arrays.asList(new Image("Photo_from_creepy_dude.png", "explicit image"),
                                            new Image("Summer_2024.jpg", "Photo of an ocean"),
                                            new Image("YouPhone15.png", "New YouPhone 15 advertisement"));

        for (Image image : images) {
            boolean isFiltered = messageProcessor.processMessage(image, imageFilters);
                System.out.println("Image: " + image.getFileName() + " | Skipped (filtered): " + isFiltered);
        }
    }
}
