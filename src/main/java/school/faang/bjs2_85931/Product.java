package school.faang.bjs2_85931;

public record Product(int id, String productName, Category category) {

    public enum Category {
        FOOD, MEDICINES, TECHNOLOGIES
    }
}
