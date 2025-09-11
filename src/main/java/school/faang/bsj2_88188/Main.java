package school.faang.bsj2_88188;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image image = new Image("image1", "first image");
        FilterProcessonr filterProcessonr = new FilterProcessonr();

        Function<Image, Image> whiteBackGround = (originalImage) ->
                new Image(originalImage.getName(),
                        originalImage.getDescripton() + " with white background");

        Function<Image, Image> rainFilter = (originalImage) ->
                new Image(originalImage.getName(),
                        originalImage.getDescripton() + " with added rain");

        Image whiteBackgroundImage = filterProcessonr.applyFilter(image, whiteBackGround);
        System.out.println(whiteBackgroundImage);

        Image rainedImage = filterProcessonr.applyFilter(image, rainFilter);
        System.out.println(rainedImage);

        Function<Image, Image> unitedFilter = filterProcessonr.combineFilters(whiteBackGround, rainFilter);
        Image filteredImage = filterProcessonr.applyFilter(image, unitedFilter);
        System.out.println(filteredImage);
    }
}
