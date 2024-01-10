package springMSA.userservice.users.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class UserDto {

    @NotNull(message = "Email cannot be null")
    @Size(min = 5, message = "Email not be less than 5 characters")
    @Email
    private String email;

    @NotNull(message = "name cannot be null")
    @Size(min=2, message = "name not be less than 2 characters")
    private String name;

    @NotNull(message = "password cannot be null")
    @Size(min=8, message = "Password not be less than 8 characters")
    private String encryptedPwd;

    public UserDto() {
    }

}
