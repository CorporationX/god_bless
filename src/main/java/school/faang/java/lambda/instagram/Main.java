package school.faang.java.lambda.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> filter1 = image ->  new Image(image.getName(), image.getDescription() + " == Added filter1");
        Function<Image, Image> filter2 = image ->  new Image(image.getName(), image.getDescription() + " == Added filter2");

        Image image1 = new Image("Name 1", "Description 1." );
        Image image2 = new Image("Name 2", "Description 3." );
        Image image3 = new Image("Name 3", "Description 3." );

        Function<Image, Image>  sepiaFilter = filterProcessor.combineFilters(filter1, filter2);

        System.out.println(filterProcessor.applyFilter(image1, filter1));
        System.out.println(filterProcessor.applyFilter(image2, filter2));
        System.out.println(filterProcessor.applyFilter(image3, sepiaFilter));
    }
}