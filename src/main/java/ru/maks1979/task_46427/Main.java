package ru.maks1979.task_46427;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image currentImage = new Image("Some Image ", "Some photo of UFO ");
        Function<Image, Image> analiticFilter = (image) -> new Image(image.getName()
                + "with xray filter", image.getDescription() + "|understand is this UFO");
        Function<Image, Image> planetFilter = (image) -> new Image(image.getName()
                + "with сosmicray filter", image.getDescription() + "|understand from what planet it is");
        Image firstAnalysis = filterProcessor.applyFilter(currentImage, analiticFilter);
        System.out.println(firstAnalysis);
        Image secondAnalysis = filterProcessor.applyFilter(currentImage, planetFilter);
        System.out.println(secondAnalysis);

        Function<Image, Image> doubleAnalysis = filterProcessor.combineFilters(analiticFilter, planetFilter);
        Image fullInfo = filterProcessor.applyFilter(currentImage, doubleAnalysis);
        System.out.println(fullInfo);

    }
}
