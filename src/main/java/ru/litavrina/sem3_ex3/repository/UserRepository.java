package ru.litavrina.sem3_ex3.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.litavrina.sem3_ex3.domain.User;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository implements iUserRepository  {
    private  List<User>  userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public User saveUser(User user) {
        userList.add(user);
        return user;
    }

}
