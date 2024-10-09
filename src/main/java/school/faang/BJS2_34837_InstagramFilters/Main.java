package school.faang.BJS2_34837_InstagramFilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        ImageProcessor processor = new ImageProcessor();

        Image seaFamilyImage = new Image("trip to sea 2008.jpg", "Photo of all family members at sea.");
        Image shaykImage = new Image("Irina Shayk.jpg", "Irina Shayk at fashion shows.");

        Function<Image, Image> vintageFilter = image -> new Image(image.getName(), image.getDescription() + " | Filter: vintage");
        Function<Image, Image> blurFilter = image -> new Image(image.getName(), image.getDescription() + " | Filter: blur");
        Function<Image, Image> vintageBlurFilter = processor.combineFilters(vintageFilter, blurFilter);

        Image seaFamilyImageVintage = processor.applyFilter(seaFamilyImage, vintageFilter);
        System.out.println(seaFamilyImageVintage.getDescription() + "\n");

        Image seaFamilyImageBlur = processor.applyFilter(seaFamilyImage, blurFilter);
        System.out.println(seaFamilyImageBlur.getDescription() + "\n");

        Image shaykImageVintageBlur = processor.applyFilter(shaykImage, vintageBlurFilter);
        System.out.println(shaykImageVintageBlur.getDescription() + "\n");
    }
}
