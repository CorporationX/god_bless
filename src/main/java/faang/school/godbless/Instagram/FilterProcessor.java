package faang.school.godbless.Instagram;

import java.util.function.Function;

public class FilterProcessor {
    public static Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> firstFunction, Function<Image, Image> secondFunction) {
        return firstFunction.andThen(secondFunction);
    }

    public static void main(String[] args) {
        Image originalImage = new Image("Оригинал.jpg", "Оригинальное изображение");

        Function<Image, Image> grayFilter = (image -> new Image(image.getName() + "_grayFilter", image.getDescription() + " с добавлением серого фильтра"));
        Function<Image, Image> retroWaveFilter = image -> new Image(image.getName() + "_retroWave", image.getDescription() + " с добавлением ретровэйв фильтра");

        Image grayFilterImage = FilterProcessor.applyFilter(originalImage, grayFilter);
        System.out.println(grayFilterImage.getDescription());
        Image retroWaveFilterImage = FilterProcessor.applyFilter(originalImage, retroWaveFilter);
        System.out.println(retroWaveFilterImage.getDescription());

        Function<Image, Image> combinedFilter = FilterProcessor.combineFilters(grayFilter, retroWaveFilter);
        Image combinedFilterImage = FilterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedFilterImage.getDescription());
    }
}
