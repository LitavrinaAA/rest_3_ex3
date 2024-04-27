package ru.litavrina.sem3_ex3.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.litavrina.sem3_ex3.domain.User;

import java.util.List;

@Repository
@Primary
@Qualifier("UserRepositoryH2")
public class UserRepositoryH2 implements iUserRepository {
    private final JdbcTemplate jdbc;

    public UserRepositoryH2(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<User> getUserList() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
//            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    @Override
    public void setUserList(List<User> userList) {
        String sql = "INSERT INTO userTable (name,age, email) VALUES ( ?, ?, ?)";
        for (User user : userList) {
            jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
        }
    }

    public User saveUser(User user) {
        String sql = "INSERT INTO userTable (name,age, email) VALUES ( ?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
        return user;
    }


}
