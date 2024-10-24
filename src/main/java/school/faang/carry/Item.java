package school.faang.carry;

public record Item(String name, int power, int price) {

    public Item combineWith(Item item) {
        return new Item(
                name + item.name,
                power + item.power,
                price + item.price);
    }

    @Override
    public String toString() {
        return name;
    }
}
