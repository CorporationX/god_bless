package derschrank.sprint04.task25.bjstwo_51104.units;

public record Product(
        String name,
        double price
) {
    @Override
    public String toString() {
        return String.format("%s, %.2f$", name, price);
    }
}
