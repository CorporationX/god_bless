package tom_Jerry;

public class Food {
    private String food;

    public Food(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Food{" +
                "food='" + food + '\'' +
                '}';
    }
}
