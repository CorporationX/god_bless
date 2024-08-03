package faang.school.godbless.bjs2_18437;

import lombok.experimental.UtilityClass;

import java.util.Collection;

@UtilityClass
public class AppCollectionUtils<E> {
    public <E> boolean isCollectionContainsElement(Collection<E> collection, E e) {
        if (collection == null || e == null) {
            throw new IllegalArgumentException();
        }

        return collection.contains(e);
    }

    public <E> boolean isCollectionContainsElementNullSafety(Collection<E> collection, E e) {
        if (collection == null || e == null) {
            return false;
        }

        return collection.contains(e);
    }

    public <E> boolean isCollectionContainsElement(Collection<E> collection, E e, boolean nullSafety) {
        return nullSafety
                ? isCollectionContainsElementNullSafety(collection, e)
                : isCollectionContainsElement(collection, e);
    }
}
