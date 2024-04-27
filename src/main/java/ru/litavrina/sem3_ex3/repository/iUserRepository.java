package ru.litavrina.sem3_ex3.repository;

import ru.litavrina.sem3_ex3.domain.User;

import java.util.List;

public interface iUserRepository {
    public List<User> getUserList();
    public void setUserList(List<User> userList);
    public User saveUser(User user);
}
