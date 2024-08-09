package faang.school.godbless.bjs2_18437;

import lombok.experimental.UtilityClass;

import java.util.Collection;

@UtilityClass
public class AppCollectionUtils<E> {
    public <E> boolean doesCollectionContainElement(Collection<E> collection, E e) {
        if (collection == null || e == null) {
            throw new IllegalArgumentException();
        }

        return collection.contains(e);
    }

    public <E> boolean doesCollectionContainElementNullSafety(Collection<E> collection, E e) {
        if (collection == null || e == null) {
            return false;
        }

        return collection.contains(e);
    }

    public <E> boolean doesCollectionContainElement(Collection<E> collection, E e, boolean nullSafety) {
        return nullSafety
                ? doesCollectionContainElementNullSafety(collection, e)
                : doesCollectionContainElement(collection, e);
    }
}
