package instagram_800;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> fitter1 = (image) -> new Image(image.getName() + "_filter1", image.getData() + " with filter1");
        Function<Image, Image> fitter2 = (image) -> new Image(image.getName() + "_filter2", image.getData() + " with filter2");

        Image imageFilter1 = filterProcessor.applyFilter(originalImage, fitter1);
        Image imageFilter2 = filterProcessor.applyFilter(originalImage, fitter2);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(fitter1, fitter2);
        Image imageCombinedFilter = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(imageFilter1);
        System.out.println(imageFilter2);
        System.out.println(imageCombinedFilter);

    }
}