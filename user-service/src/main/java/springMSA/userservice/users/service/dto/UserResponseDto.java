package springMSA.userservice.users.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import springMSA.userservice.users.service.dto.orders.ResponseOrder;

import java.util.List;

@Getter
public class UserResponseDto {

    @NotNull(message = "Email cannot be null")
    @Size(min = 5, message = "Email not be less than 5 characters")
    @Email
    private String email;

    @NotNull(message = "name cannot be null")
    @Size(min=2, message = "name not be less than 2 characters")
    private String name;

    private List<ResponseOrder> orders;

    public UserResponseDto() {
    }

    @Builder
    public UserResponseDto(String email, String name, List<ResponseOrder> orders) {
        this.email = email;
        this.name = name;
        this.orders = orders;
    }
}
