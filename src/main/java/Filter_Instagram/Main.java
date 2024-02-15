package Filter_Instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage=new Image("origin.png", "Original picture");
        FilterProcessor filterProcessor=new FilterProcessor();

        Function<Image, Image> grayscaleFilter =(image) -> new Image(image.getFileName() +"_grayscale", "Black-White filter");
        Function<Image, Image> sepiaFilter =(image) -> new Image(image.getFileName() + "_sepia", "Sepia filter");

        //execution
        Image grayscaleImage=filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage=filterProcessor.applyFilter(originalImage, (FilterProcessor.Function<Image, Image>) sepiaFilter);

        //creating and combining
        Function<Image, Image>combinedFilter=filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

    }
}
