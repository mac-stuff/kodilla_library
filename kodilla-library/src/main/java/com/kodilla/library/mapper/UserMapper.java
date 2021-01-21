package com.kodilla.library.mapper;

import com.kodilla.library.domain.User;
import com.kodilla.library.domain.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getDate(),
                userDto.getRental()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getDate(),
                user.getRental()
        );
    }

    public List<UserDto> mapToUsersDtoList(final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
