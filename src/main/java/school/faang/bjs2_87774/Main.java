package school.faang.bjs2_87774;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image simpleImage = new Image("party-photo.jpg", "Оригинальное изображение");
        System.out.println(simpleImage);

        Function<Image, Image> cassetteFilter = image -> new Image(image.name(),
                image.description() + " | Наложен фильтр Кассета");

        Function<Image, Image> videoFilter = image -> new Image(image.name(),
                image.description() + " | Наложен фильтр Видеокамера");

        Function<Image, Image> depthFilter = image -> new Image(image.name(),
                image.description() + " | Наложен фильтр Глубина");

        Function<Image, Image> combinedFilter = FilterProcessor.combineFilters(cassetteFilter, videoFilter,
                depthFilter);
        simpleImage = FilterProcessor.applyFilter(simpleImage, combinedFilter);
        System.out.println(simpleImage);
    }
}
