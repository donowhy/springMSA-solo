package springMSA.userservice.users.service;

import springMSA.userservice.users.entity.UserEntity;
import springMSA.userservice.users.service.dto.UserDto;
import springMSA.userservice.users.service.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    void createUser (UserDto userDto);

    UserResponseDto userInfo (String userId) throws NoSuchFieldException;

    List<UserResponseDto> userAll();

}
