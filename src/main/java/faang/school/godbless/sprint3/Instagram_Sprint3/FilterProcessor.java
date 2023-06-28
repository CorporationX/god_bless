package faang.school.godbless.sprint3.Instagram_Sprint3;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.act(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return (image) -> secondFilter.act(firstFilter.act(image));
    }
}
