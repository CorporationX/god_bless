package BJS257594;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "| original image |");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getFileName(), image.getDescription() +  "| gray filter |");
        Function<Image, Image> brightnessFilter = (image) ->
                new Image(image.getFileName(), image.getDescription() +  "| brightness filter |");
        Function<Image, Image> contrastFilter = (image) ->
                new Image(image.getFileName(), image.getDescription() + "| contrast filter |");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());
        Image brightnessImage = filterProcessor.applyFilter(originalImage, brightnessFilter);
        System.out.println(brightnessImage.getDescription());
        Image contrastImage = filterProcessor.applyFilter(originalImage, contrastFilter);
        System.out.println(contrastImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilter(grayscaleFilter, contrastFilter);
        System.out.println("combined : ");
        Image combinedImage = combinedFilter.apply(originalImage);
        System.out.println(combinedImage.getDescription());

        Function<Image, Image> combinedFilter2 = filterProcessor.combineFilter(brightnessFilter, contrastFilter);
        Image combinedImage2 = combinedFilter2.apply(originalImage);
        System.out.println(combinedImage2.getDescription());
    }
}
