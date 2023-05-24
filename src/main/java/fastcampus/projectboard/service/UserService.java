package fastcampus.projectboard.service;

import fastcampus.projectboard.domain.UserAccount;
import fastcampus.projectboard.dto.UserAccountDto;
import fastcampus.projectboard.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {


    private final UserAccountRepository userAccountRepository;

    public void saveUserAccount(UserAccountDto dto) {
        Optional<UserAccount> optional = userAccountRepository.findById(dto.userId());
        log.warn("이미 존재하는 유저 아이디 입니다 - {}", dto.userId());
        if (optional.isPresent()) { // 이미 존재하는 유저 아이디라면
            log.warn("이미 존재하는 유저 아이디 입니다 - {}", dto.userId());
        } else { // 유저 계정 만들기
            userAccountRepository.save(dto.toEntity());
        }
    }
}
