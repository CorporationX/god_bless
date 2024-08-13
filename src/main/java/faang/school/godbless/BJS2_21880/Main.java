package faang.school.godbless.BJS2_21880;

import java.util.LinkedList;
import java.util.Random;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("robert.jpg", "java developer", new LinkedList<>());
        Random random = new Random();

        Function<Image, Image> filter1 = (image) -> {
            Image newImage = new Image(image);
            newImage.add(new Filter("Размытие", random.nextInt(0, 100)));
            return newImage;
        };
        Function<Image, Image> filter2 = (image) -> {
            Image newImage = new Image(image);
            newImage.add(new Filter("Мозаика", random.nextInt(0, 100)));
            return newImage;
        };
        Function<Image, Image> filter3 = (image) -> {
            Image newImage = new Image(image);
            newImage.add(new Filter("Затемнение", random.nextInt(0, 100)));
            return newImage;
        };

        Image image1 = FilterProcessor.applyFilter(originalImage, filter1);
        Image image2 = FilterProcessor.applyFilter(originalImage, filter2);

        System.out.println(image1);
        System.out.println(image2);
        System.out.println();

        Function<Image, Image> combineFilter = FilterProcessor.combineFilters(filter1, filter2, filter3);
        System.out.println(combineFilter.apply(originalImage));
    }
}
