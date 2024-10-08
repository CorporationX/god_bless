package Instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image portret = new Image("Portret", "original");

        Function<Image, Image> retroFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | retro filter");
        Function<Image, Image> blackWhiteFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | blackWhiteFilter filter");
        Function<Image, Image> combineFilters = filterProcessor.combineFilters(retroFilter, blackWhiteFilter);

        filterProcessor.applyFilter(portret, retroFilter);
        filterProcessor.applyFilter(portret, blackWhiteFilter);
        filterProcessor.applyFilter(portret, filterProcessor.combineFilters(retroFilter, blackWhiteFilter));


    }
}