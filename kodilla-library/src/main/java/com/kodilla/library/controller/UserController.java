package com.kodilla.library.controller;

import com.kodilla.library.domain.User;
import com.kodilla.library.domain.UserDto;
import com.kodilla.library.mapper.UserMapper;
import com.kodilla.library.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final DBService service;
    private final UserMapper userMapper;

    @Autowired
    public UserController(DBService service, UserMapper userMapper) {
        this.service = service;
        this.userMapper = userMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        List<User> users = service.getAllUsers();
        return userMapper.mapToUsersDtoList(users);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam Long userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(
                service.getUser(userId).orElseThrow(UserNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(@RequestParam Long userId) {
        service.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        service.saveUser(user);
    }
}
