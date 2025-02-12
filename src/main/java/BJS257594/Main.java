package BJS257594;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
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
        log.info(grayscaleImage.getDescription());
        Image brightnessImage = filterProcessor.applyFilter(originalImage, brightnessFilter);
        log.info(brightnessImage.getDescription());
        Image contrastImage = filterProcessor.applyFilter(originalImage, contrastFilter);
        log.info(contrastImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilter(grayscaleFilter, contrastFilter);
        log.info("First combined : ");
        Image combinedImage = combinedFilter.apply(originalImage);
        log.info(combinedImage.getDescription());
        log.info("Second combined : ");
        Function<Image, Image> secondCombinedFilter = filterProcessor.combineFilter(brightnessFilter, contrastFilter);
        Image secondCombinedImage = secondCombinedFilter.apply(originalImage);
        log.info(secondCombinedImage.getDescription());
    }
}
