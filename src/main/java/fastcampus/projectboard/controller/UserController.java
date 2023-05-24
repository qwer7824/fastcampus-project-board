package fastcampus.projectboard.controller;


import fastcampus.projectboard.dto.UserAccountDto;
import fastcampus.projectboard.dto.request.UserAccountRequest;
import fastcampus.projectboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String createMember(UserAccountRequest userAccountRequest) {
        log.info("aaa {}",userAccountRequest.userId());
        userService.saveUserAccount(userAccountRequest.toDtos());
        return "redirect:/articles";
    }
}
