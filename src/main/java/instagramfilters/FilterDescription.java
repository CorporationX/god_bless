package instagramfilters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FilterDescription {
    BLACK_AND_WHITE(" Black & White filter applied! Converted into black and white."),
    SEPIA(" Sepia filter applied! Added yellow and brown appearances."),
    VIGNETTE(" Vignette filter applied! Reduced the saturation at the edges.");

    private final String description;
}
