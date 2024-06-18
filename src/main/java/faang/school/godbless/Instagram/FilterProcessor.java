package faang.school.godbless.Instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image , Function<Image , Image> imageFunction){
        Image newImage = imageFunction.apply(image);
        System.out.println(newImage.namePhoto() + " " + newImage.descriptionPhoto());
        return new Image(newImage.namePhoto() , newImage.descriptionPhoto());
    }

    public Function<Image , Image> combineFilter(Function<Image, Image> firstImage,
                                                Function<Image , Image> secondImage){
       return secondImage.andThen(firstImage);

    }
}
