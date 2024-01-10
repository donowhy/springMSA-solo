package springMSA.userservice.users.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springMSA.userservice.users.entity.UserEntity;
import springMSA.userservice.users.repository.UserRepository;
import springMSA.userservice.users.service.dto.UserDto;
import springMSA.userservice.users.service.dto.UserResponseDto;
import springMSA.userservice.users.service.dto.orders.ResponseOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public void createUser(UserDto userDto) {

        userRepository.save(UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .email(userDto.getEmail())
                .name(userDto.getName())
                .encryptedPwd(passwordEncoder.encode(userDto.getEncryptedPwd()))
                .build());
    }

    @Override
    public UserResponseDto userInfo(String userId) throws NoSuchFieldException {
        UserEntity userEntity = userRepository.findbyUserId(userId).orElseThrow(() ->
                new NoSuchFieldException("User not found"));

        List<ResponseOrder> orders = new ArrayList<>();

        return UserResponseDto.builder()
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .orders(orders)
                .build();
    }

    @Override
    public List<UserResponseDto> userAll() {
        List<UserEntity> userAllInfo = userRepository.findAll();

        List<UserResponseDto> userIters = new ArrayList<>();
        for (UserEntity userEntity : userAllInfo) {
            userIters.add(UserResponseDto.builder()
                            .email(userEntity.getEmail())
                            .name(userEntity.getName())
                    .build());
        }

        return userIters;
    }
}
