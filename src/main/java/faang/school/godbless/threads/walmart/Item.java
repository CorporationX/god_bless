package faang.school.godbless.threads.walmart;

public enum Item {
    TEA(25),
    COFFEE(50),
    BREAD(10),
    TOMATO(31),
    CARROT(4),
    CUCUMBER(27),
    YOUGURT(21),
    MILK(70),
    COLA(90);

    private int price;
    Item(int i) {
        this.price = i;
    }
    public int getPrice() {
        return price;
    }
}
