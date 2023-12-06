package faang.school.godbless._регистррация_пользователей;
import java.util.Set;

public class User {
    public String name;
    public  int age;
    public String  work_place;
    public String address;
    final static Set<String> VALID_JOBS =Set.of("Google","Uber","Amazon");
    final static Set<String> VALID_ADDRESSES= Set.of("London","New York","Amsterdam");
    final static int age1 =18;

    public User(String name, int age, String work_place, String address) {
        if(!name.isEmpty()&&age>=age1&&VALID_JOBS.contains(work_place)&&VALID_ADDRESSES.contains(address)){
            this.name=name;
            this.age=age;
            this.work_place=work_place;
            this.address=address;
        }else {
            throw new IllegalArgumentException();
        }
    }
}
