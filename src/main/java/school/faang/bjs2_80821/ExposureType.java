package school.faang.bjs2_80821;

public enum ExposureType {
    GAS_EMISSION("Выброс газа");

    private final String title;

    ExposureType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
