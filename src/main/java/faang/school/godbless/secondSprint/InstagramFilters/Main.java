package faang.school.godbless.secondSprint.InstagramFilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image myImage = new Image("me.jpg", "Как вам?");
        Image lakeImage = new Image("lake.jpg", "Красота");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> moonFilter = image -> new Image(image.getFileName() + " + moon filter",
                image.getDescription());
        Function<Image, Image> grayFilter = image -> new Image(image.getFileName() + " + gray filter",
                image.getDescription());
        Function<Image, Image> yellowFilter = image -> new Image(image.getFileName() + " + yellow filter",
                image.getDescription());

        Image moonImage = filterProcessor.applyFilter(myImage, moonFilter);
        System.out.println(moonImage.getFileName());

        Function<Image, Image> combineFilter = filterProcessor.combineFilters(grayFilter, yellowFilter);
        Image yellowAndGrayImage = filterProcessor.applyFilter(lakeImage, combineFilter);
        System.out.println(yellowAndGrayImage.getFileName());
    }
}
