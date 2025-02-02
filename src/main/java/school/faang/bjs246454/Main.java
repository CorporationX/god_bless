package school.faang.bjs246454;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        final FilterProcessor filterProcessor = new FilterProcessor();
        final Image myCat = new Image("Barsik.jpeg", "Original image");

        Function<Image, Image> filterSepia =
                ((image) -> new Image(image.getName(), image.getDescription() + "| applied filter sepia "));
        Function<Image, Image> filterBlackAndWithe =
                (image -> new Image(image.getName(), image.getDescription() + "| applied filter black and white "));
        Function<Image, Image> filterVignette =
                (image -> new Image(image.getName(), image.getDescription() + "| applied filter vignette "));

        Image sepiaFilter = filterProcessor.applyFilter(myCat, filterSepia);
        System.out.println(sepiaFilter);

        Image blackAndWhiteFilter = filterProcessor.applyFilter(myCat, filterBlackAndWithe);
        System.out.println(blackAndWhiteFilter);

        Image vignetteFilter = filterProcessor.applyFilter(myCat, filterVignette);
        System.out.println(vignetteFilter);

        Function<Image, Image> twoFilters = filterProcessor.combineFilters(filterSepia, filterBlackAndWithe);
        Image changedCat = twoFilters.apply(myCat);
        System.out.println(changedCat);

        Function<Image, Image>[] arrayFilters = new Function[3];
        arrayFilters[0] = filterSepia;
        arrayFilters[1] = filterVignette;
        arrayFilters[2] = filterBlackAndWithe;

        Function<Image, Image> comboFilters = filterProcessor.mixFilters(arrayFilters);
        Image combineChange = filterProcessor.applyFilter(myCat, comboFilters);
        System.out.println(combineChange);
    }
}
