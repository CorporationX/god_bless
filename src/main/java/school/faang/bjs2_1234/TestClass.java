package school.faang.bjs2_1234;

public class TestClass {
    String field1;
    int field2;
    String field3;

    public void test(int i) {
        switch (i) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("not found");
        }
        if (i < 5) {
            System.out.println("incorrect style");
        }
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
