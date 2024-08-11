package com.functional.insta;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) ->
                new Image(image.getName() + "_vignette", "Фильтр: виньетка");

        System.out.println(filterProcessor.applyFilter(originalImage, grayscaleFilter));
        System.out.println(filterProcessor.applyFilter(originalImage, sepiaFilter));
        System.out.println(filterProcessor.applyFilter(originalImage, vignetteFilter));
        System.out.println();

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);
    }
}
