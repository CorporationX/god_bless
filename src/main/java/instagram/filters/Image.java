package instagram.filters;

import lombok.Data;
import lombok.NonNull;

@Data
public class Image {
    @NonNull
    private final String fileName;
    @NonNull
    private final String description;
}
