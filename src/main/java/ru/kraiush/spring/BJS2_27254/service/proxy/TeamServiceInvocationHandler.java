package ru.kraiush.spring.BJS2_27254.service.proxy;

import ru.kraiush.spring.BJS2_27254.model.TeamMember;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TeamServiceInvocationHandler implements InvocationHandler {

    private TeamMember user;

    private boolean isAdmin;

    public TeamServiceInvocationHandler(TeamMember user) {
        this.user = user;
        if (user.getRole().equals("ROLE_ADMIN")) isAdmin = true;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (isAdmin) {
            System.out.println("Hi " + user.getName() + "!");
            return method.invoke(user, args);
        } else {
            throw new Exception("run this command is not allowed for non-admin users!");
        }
    }
}

