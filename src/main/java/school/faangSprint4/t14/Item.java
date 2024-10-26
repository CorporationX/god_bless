package school.faangSprint4.t14;

public record Item(String name, int power) {

    @Override
    public String toString() {
        return "Item{name='" + name + "', power=" + power + "}";
    }
}