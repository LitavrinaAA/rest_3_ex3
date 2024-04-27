package ru.litavrina.sem3_ex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.litavrina.sem3_ex3.domain.User;
import ru.litavrina.sem3_ex3.repository.UserRepository;
import ru.litavrina.sem3_ex3.repository.UserRepositoryH2;
import ru.litavrina.sem3_ex3.repository.iUserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    @Autowired
    @Qualifier("UserRepositoryH2")
    private iUserRepository repository;

    public iUserRepository getRepository() {
        return repository;
    }
    public void  addUserToList(User user)
    {
        repository.getUserList().add(user);
    }
    public List<User> sortUsersByAge(List<User> users) {


        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge( int age) {
        List<User> users = repository.getUserList();
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
}
