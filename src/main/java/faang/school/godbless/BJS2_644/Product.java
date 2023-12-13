package faang.school.godbless.BJS2_644;


import lombok.Getter;

@Getter
public class Product {
    private int id;
    private String name;
    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name=name;
        this.category=category;
    }
    public String toString(){
        return getName();
    }
}
