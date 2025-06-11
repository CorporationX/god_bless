package school.faang.instagram;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterProcessorTest {
    private static FilterProcessor processor;

    @BeforeAll
    public static void setUp() {
        processor = new FilterProcessor();
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testApplyFilter(Image original, Image expected, Function<Image, Image> filter) {
        Image actual = processor.applyFilter(original, filter);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideExtendedParameters")
    public void testCombineFilters(Image original, Function<Image, Image> filter1,
                                   Function<Image, Image> filter2, Image expected) {
        Function<Image, Image> combinedFilter = processor.combineFilters(filter1, filter2);
        Image actual = processor.applyFilter(original, combinedFilter);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideParameters() {
        Function<Image, Image> grayscaleFilter =
                (image) -> new Image(image.getName(), image.getDescription() + " | Filter: grayscale");

        Function<Image, Image> sepiaFilter =
                (image) -> new Image(image.getName(), image.getDescription() + " | Filter: sepia");

        Image beachPic = new Image("Beach", "water, sand, people in bikini");
        Image grayscaleBeachPic = new Image("Beach", "water, sand, people in bikini | Filter: grayscale");
        Image sepiaBeachPic = new Image("Beach", "water, sand, people in bikini | Filter: sepia");

        Image saharaPic = new Image("Sahara", "sand everywhere");
        Image grayscaleSaharaPic = new Image("Sahara", "sand everywhere | Filter: grayscale");
        Image sepiaSaharaPic = new Image("Sahara", "sand everywhere | Filter: sepia");
        return Stream.of(
                Arguments.of(beachPic, grayscaleBeachPic, grayscaleFilter),
                Arguments.of(saharaPic, grayscaleSaharaPic, grayscaleFilter),
                Arguments.of(beachPic, sepiaBeachPic, sepiaFilter),
                Arguments.of(saharaPic, sepiaSaharaPic, sepiaFilter)
        );
    }

    private static Stream<Arguments> provideExtendedParameters() {
        Function<Image, Image> grayscaleFilter =
                (image) -> new Image(image.getName(), image.getDescription() + " | Filter: grayscale");

        Function<Image, Image> sepiaFilter =
                (image) -> new Image(image.getName(), image.getDescription() + " | Filter: sepia");

        Image beachPic = new Image("Beach", "water, sand, people in bikini");
        Image mixedFilterBeachPic =
                new Image("Beach", "water, sand, people in bikini | Filter: grayscale | Filter: sepia");

        Image saharaPic = new Image("Sahara", "sand everywhere");
        Image mixedFilterSaharaPic = new Image("Sahara", "sand everywhere | Filter: grayscale | Filter: sepia");
        return Stream.of(
                Arguments.of(beachPic, grayscaleFilter, sepiaFilter, mixedFilterBeachPic),
                Arguments.of(saharaPic, grayscaleFilter, sepiaFilter, mixedFilterSaharaPic)
        );
    }
}
