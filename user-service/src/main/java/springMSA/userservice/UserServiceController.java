package springMSA.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
public class UserServiceController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome MSA service";
    }

    @GetMapping("/check")
    public String check() {
        return "Custom filter check";
    }
}
