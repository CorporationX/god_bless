package school.faang.bjs2_87879;


import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image imageOrig = new Image("dog", "dog on table");
        Function<Image, Image> blackAndWhite = image -> (new Image(image.getName(), ("%s | black and white")
                .formatted(image.getDescription())));

        FilterProcessor filterProcessor = new FilterProcessor();
        System.out.println(imageOrig);
        Image imageAfterFilter = filterProcessor.applyFilter(imageOrig, blackAndWhite);
        System.out.println(imageAfterFilter);

        Image imageOrigTwo = new Image("cat", "Cat on table");
        Function<Image, Image> filterNet = image -> (new Image(image.getName(), ("%s | Net")
                .formatted(image.getDescription())));
        Function<Image, Image> filter = filterProcessor.combineFilters(blackAndWhite, filterNet);
        System.out.println(filter.apply(imageOrigTwo));
    }

}
