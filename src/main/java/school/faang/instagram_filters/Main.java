package school.faang.instagram_filters;

import java.util.function.Function;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 * Дата: 22.09.2025
 * Описание: система, которая позволяет выбрать фильтры и
 * применить их к фотографиям с помощью функций высокого порядка
 */

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.png", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (img) ->
                new Image(img.getName(), img.getDescription() + " | Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter = (img) ->
                new Image(img.getName(), img.getDescription() + " | Фильтр: сепия");

        Image gray = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(gray.getDescription());

        Image graySepia = filterProcessor.applyFilter(gray, sepiaFilter);
        System.out.println(graySepia.getDescription());

        Function<Image, Image> combined = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combined);
        System.out.println(combinedImage.getDescription());
    }
}