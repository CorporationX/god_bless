package school.faang.registerUsers;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegister {
    private static final List<String> VALID_JOBS = List.of( "Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of( "London", "New York", "Amsterdam");

    private String name;
    private Integer age;
    private String work;
    private String address;

    private UserRegister(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.work = builder.work;
        this.address = builder.address;
    }

    public static class Builder{
        private String name;
        private Integer age;
        private String work;
        private String address;

        public Builder setName(String name) {
            if(name == null || name.isEmpty()){
                throw new IllegalArgumentException("имя не может быть пустым");
            }
            this.name = name;
            return this;
        }

        public Builder setAge(Integer age) {
            if(age < 18){
                throw new IllegalArgumentException("возраст больше 18 лет");
            }
            this.age = age;
            return this;
        }

        public Builder setWork(String work) {
            if(!VALID_JOBS.contains(work)){
                throw new IllegalArgumentException("не подходящее место работы");
            }
            this.work = work;
            return this;
        }

        public Builder setAddress(String address) {
            if(!VALID_ADDRESSES.contains(address)){
                throw new IllegalArgumentException("не тот город");
            }
            this.address = address;
            return this;
        }
        public UserRegister build() {
            return new UserRegister(this);
        }
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
