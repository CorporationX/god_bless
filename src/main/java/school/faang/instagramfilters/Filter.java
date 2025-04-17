package school.faang.instagramfilters;

public enum Filter {
    GREYSCALE("grayscaleFilter"),
    SEPIA("sepia"),
    VIGNETTE("vignette");

    public final String label;

    Filter(String label) {
        this.label = label;
    }
}
