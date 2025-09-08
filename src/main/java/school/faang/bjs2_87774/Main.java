package school.faang.bjs2_87774;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> cassetteFilter = image -> new Image(image.name(),
                image.description() + " | Наложен фильтр Нуар");

        Function<Image, Image> videocamFilter = image -> new Image(image.name(),
                image.description() + " | Наложен фильтр Видеокамера");

        Image simpleImage = new Image("party-photo.jpg", "Оригинальное изображение");
        System.out.println(simpleImage);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(cassetteFilter, videocamFilter);
        simpleImage = filterProcessor.applyFilter(simpleImage, combinedFilter);
        System.out.println(simpleImage);
    }
}
