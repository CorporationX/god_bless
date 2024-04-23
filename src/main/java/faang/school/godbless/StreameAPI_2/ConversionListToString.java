package faang.school.godbless.StreameAPI_2;

import java.util.List;

public class ConversionListToString {
    public static List<String> convertNumbersToString (List<Integer> number) {
        return number.stream()
                .map(Integer::toBinaryString)
                .toList();
    }
}
