package school.faang.bjs2_31491;

import java.util.*;

class User {
	private String name;
	private int age;
	private String workplace;
	private String address;

	public User(String name, int age, String workplace, String address) {
		this.name = name;
		this.age = age;
		this.workplace = workplace;
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public static Map<Integer, List<User>> groupUsers(List<User> users) {
		Map<Integer, List<User>> groupedUsers = new HashMap<>();
		for (User user : users) {
			int age = user.getAge();
			if (!groupedUsers.containsKey(age)) {
				groupedUsers.put(age, new ArrayList<>());
			}
			groupedUsers.get(age).add(user);
		}
		return groupedUsers;
	}
}
