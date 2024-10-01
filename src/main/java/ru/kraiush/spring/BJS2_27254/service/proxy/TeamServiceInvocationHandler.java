package ru.kraiush.spring.BJS2_27254.service.proxy;

import ru.kraiush.spring.BJS2_27254.model.TeamMember;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TeamServiceInvocationHandler implements InvocationHandler {

    private final TeamMember member;

    private boolean isAdmin;

    public TeamServiceInvocationHandler(TeamMember member) {
        this.member = member;
        if (member.getRole().equals("ROLE_ADMIN")) isAdmin = true;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (isAdmin) {
            System.out.println("Hi " + member.getName() + "!");
            return method.invoke(member, args);
        } else {
            throw new Exception("run this command is not allowed for non-admin users!");
        }
    }
}

