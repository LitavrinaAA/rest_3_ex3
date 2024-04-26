package ru.litavrina.sem3_ex3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.litavrina.sem3_ex3.domain.User;
import ru.litavrina.sem3_ex3.service.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<User> userList() {
        return registrationService.getDataProcessingService().getRepository().getUserList();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        registrationService.getDataProcessingService().getRepository().getUserList().add(user);
        return "User added from body!";
    }
    @PostMapping("/param")//localhost:8080/users/param?name=Artur&age=23&email=exam1@yandex.ru
    @ResponseBody
    public String userAddFromParam(
            @RequestParam("name") String name
            , @RequestParam("age") int age
            , @RequestParam("email") String email) {
        return registrationService.processRegistration(name, age, email);
    }
}
