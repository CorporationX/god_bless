package school.faang.m1s2.bsj2_34734_instagram;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        filterProcessor.addNewFilter("Gray Scale",
                image -> new Image(image.getName(),
                        image.getDescription() + " | Filter: Gray Scale"));

        filterProcessor.addNewFilter("Sepia",
                image -> new Image(image.getName(), image.getDescription() + " | Filter: Sepia"));

        Image landscape = new Image("Landscape", "Original");
        Image grayScaleLandscape = filterProcessor.applyFilter(landscape, "Gray Scale");

        System.out.println(grayScaleLandscape.getDescription());

        filterProcessor.addNewFilter("Gray Scale Sepia", filterProcessor.combineFilters("Gray Scale",
                "Sepia"));

        Image grayScaleSepiaLandscape = filterProcessor.applyFilter(landscape, "Gray Scale Sepia");

        System.out.println(grayScaleSepiaLandscape.getDescription());
    }
}
