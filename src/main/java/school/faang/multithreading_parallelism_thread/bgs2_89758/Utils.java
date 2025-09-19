package school.faang.multithreading_parallelism_thread.bgs2_89758;

import lombok.NonNull;

import java.util.Collection;
import java.util.List;

public class Utils {

    public static <T extends Number & Comparable<T>> boolean isBetweenClose(@NonNull T lowerLimit,
                                                                            @NonNull T upperLimit,
                                                                            @NonNull T value) {

        return value.compareTo(lowerLimit) >= 0 && value.compareTo(upperLimit) <= 0;
    }

    public static <T extends Number & Comparable<T>, U extends Collection<T>> boolean
        isBetweenClose(@NonNull Collection<T> collection, T value) {

        if (collection.size() == 2) {

            List<T> listCollection = collection.stream().toList();
            T lowerLimit = listCollection.get(0);
            T upperLimit = listCollection.get(1);
            return Utils.isBetweenClose(lowerLimit, upperLimit, value);
        }
        throw new RuntimeException("Коллекция должна содержать 2 элемента");
    }

    public static Printf createPrintfWithSuffix(String terminatorChar) {
        return (format, args) -> {
            System.out.printf(format.toString() + terminatorChar, args);
        };
    }


}
