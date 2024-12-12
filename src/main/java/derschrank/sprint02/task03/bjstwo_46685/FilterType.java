package derschrank.sprint02.task03.bjstwo_46685;

import lombok.Getter;

import java.util.function.UnaryOperator;

@Getter
public enum FilterType {
    GRAYSCALE((img) -> new Image(img.name(), img.description() + "| Filter: grayscale")),
    SEPIA((img) -> new Image(img.name(), img.description() + "| Filter: sepia")),
    SUPER((img) -> new Image(img.name(), img.description() + "| Filter: super"));

    private final UnaryOperator<Image> filter;

    FilterType(UnaryOperator<Image> unaryOperator) {
        this.filter = unaryOperator;
    }
}
