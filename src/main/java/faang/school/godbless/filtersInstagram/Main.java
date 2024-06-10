package faang.school.godbless.filtersInstagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image imageOrigin = new Image("origin.jpeg", "origin_");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> sepiaFiltr = (image) -> new Image(image.getNameFile() + "+_image1", image.getDescription() + "+_sepia");

        Image imageSepia = filterProcessor.applyFilter(imageOrigin, sepiaFiltr);
        System.out.println(imageSepia);

        Function<Image, Image> blackWhite = (image) -> new Image(image.getNameFile() + "_i2", image.getDescription() + "_Фильтр: чернобелый");
        Function<Image, Image> blackPink = (image) -> new Image(image.getNameFile() + "_i3", image.getDescription() + "_Фильтр: чернорозовый");

        Function<Image, Image> newFunction = filterProcessor.combineFilters(blackPink, blackWhite);
        Image comb = filterProcessor.applyFilter(imageSepia, newFunction);
        System.out.println(comb);
    }
}
