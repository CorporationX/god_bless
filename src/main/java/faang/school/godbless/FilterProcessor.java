package src.main.java.faang.school.godbless;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterProcessor {
    Image applyFilter(Image image, Function<Image,Image> filter){
        return filter.apply(image);
    }
    Image applyFilter2(Image image, BiFunction<Image,Image,Image> filter){
        return filter.apply(image,image);
    }
    Function<Image, Image> combineFilters(Function<Image, Image> sepiaFilter, Function<Image, Image> grayscaleFilter){
        return sepiaFilter.andThen(grayscaleFilter);
    }


    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

// Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");
        Function<Image, Image> blurFilter = (image) -> new Image(image.getName() + "_blur", "Фильтр: размытие");
        BiFunction<Image, Image, Image> duableBlurFilter = (image1,image2) -> new Image(image1.getName() + "_blur2", "Фильтр: размытие2");
        Predicate<Image> isFilterApplied = image -> {
            String name = image.getName();
            return name.contains("_blur") || name.contains("_blur2") || name.contains("_vignette") || name.contains("_sepia") || name.contains("_grayscale");
        };
// Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        Image blurImage = filterProcessor.applyFilter(originalImage, blurFilter);
        boolean hasFilterApplied = isFilterApplied.test(originalImage);
        if(hasFilterApplied){
            System.out.println("На изображение был наложен фильтр");
        } else {
            System.out.println("На изображение не было наложено фильтров");
        }


// Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
    }

}
