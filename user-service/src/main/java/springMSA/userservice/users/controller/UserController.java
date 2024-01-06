package springMSA.userservice.users.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springMSA.userservice.users.service.UserService;
import springMSA.userservice.users.service.dto.UserDto;
import springMSA.userservice.users.service.dto.UserResponseDto;

import java.util.List;

@RestController
@RequestMapping("/user-service/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity createdUser(@RequestBody UserDto userDto) {

        log.info("여기까진");

        userService.createUser(userDto);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/info/{userId}")
    public ResponseEntity<UserResponseDto> userInfo(@PathVariable("userId") String userId) throws NoSuchFieldException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.userInfo(userId));
    }

    @GetMapping("/all-info")
    public ResponseEntity<List<UserResponseDto>> userAllInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.userAll());
    }
}
