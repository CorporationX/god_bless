package faang.school.godbless.BJS2_21897;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> imageFilter){
       return imageFilter.apply(image);
    }
    public Function<Image, Image> combineFilters(Function<Image, Image> filtersOne, Function<Image,Image> filtersTwo){
        return filtersTwo.andThen(filtersOne);
    }
}
