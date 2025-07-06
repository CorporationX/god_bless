package school.faang.bjs2_82718;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;


@Getter
public abstract class SpaceItem {
    protected List<Item> items;

    public SpaceItem(@NonNull List<Item> items) {
        this.items = items;
    }

    public Optional<Item> getFirst() {
        if (isValidItems()) {
            return Optional.ofNullable(items.get(0));
        }
        return Optional.empty();
    }

    public Optional<Item> get(int ind) {
        if (isValidIndex(ind)) {
            return Optional.ofNullable(items.get(ind));
        }
        return Optional.empty();
    }

    private boolean isValidIndex(int ind) {
        return ind >= 0 && ind < items.size();
    }

    private boolean isValidItems() {
        return items != null && !items.isEmpty();
    }
}
