package faang.school.godbless.instagram_filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image image = new Image("original.png", "Original image");

        Function<Image, Image> inverseFilter = (imageOriginal) ->
                new Image(imageOriginal.getName() + "_inverse", "Inverse Filter");
        Function<Image, Image> brightFilter = (imageOriginal) ->
                new Image(imageOriginal.getName() + "_bright", "Bright Filter");
        Function<Image, Image> darkFilter = (imageOriginal) ->
                new Image(imageOriginal.getName() + "_dark", "Dark Filter");

        FilterProcessor filterProcessor = new FilterProcessor();

        System.out.println(filterProcessor.applyFilter(image, inverseFilter));
        System.out.println(filterProcessor.applyFilter(image, brightFilter));
        System.out.println(filterProcessor.applyFilter(image, darkFilter));

        Function<Image, Image> doubleFilter = filterProcessor.combineFilters(inverseFilter, brightFilter);
        System.out.println(filterProcessor.applyFilter(image, doubleFilter));
    }
}