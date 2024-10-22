package school.faang.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image imageOriginal = new Image("sun.jpg", "original image");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> blackAndWhite =
                (image) -> new Image(image.getName(), image.getDescription() + " | black and white");
        Function<Image, Image> sepia =
                (image) -> new Image(image.getName(), image.getDescription() + " | sepia");
        Function<Image, Image> vignette =
                (image) -> new Image(image.getName(), image.getDescription() + " | vignette");

        Image firstImage = filterProcessor.applyFilter(imageOriginal, blackAndWhite);
        System.out.println(firstImage.getDescription());

        Image secondImage = filterProcessor.applyFilter(firstImage, sepia);
        System.out.println(secondImage.getDescription());

        Image thirdImage = filterProcessor.applyFilter(secondImage, vignette);
        System.out.println(thirdImage.getDescription());

        System.out.println("--------------------");

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(blackAndWhite, sepia);
        Image imageFromCombinedFilters = filterProcessor.applyFilter(imageOriginal, combinedFilter);
        System.out.println(imageFromCombinedFilters.getDescription());
    }
}

