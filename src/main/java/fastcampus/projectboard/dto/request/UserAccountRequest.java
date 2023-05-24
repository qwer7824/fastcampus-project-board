package fastcampus.projectboard.dto.request;


import fastcampus.projectboard.domain.UserAccount;
import fastcampus.projectboard.dto.ArticleDto;
import fastcampus.projectboard.dto.UserAccountDto;

public record UserAccountRequest(
        String userId,
        String userPassword,
        String email,
        String nickname,
        String memo
) {

    public UserAccountDto toDtos() {
        return UserAccountDto.of(
                userId,
                userPassword,
                email,
                nickname,
                memo
        );
    }

}