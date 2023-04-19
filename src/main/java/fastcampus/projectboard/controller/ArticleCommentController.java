package fastcampus.projectboard.controller;

import fastcampus.projectboard.dto.UserAccountDto;
import fastcampus.projectboard.dto.request.ArticleCommentRequest;
import fastcampus.projectboard.dto.request.ArticleRequest;
import fastcampus.projectboard.service.ArticleCommentService;
import lombok.RequiredArgsConstructor;
<<<<<<< Updated upstream
=======
import org.springframework.security.core.annotation.AuthenticationPrincipal;
>>>>>>> Stashed changes
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;

<<<<<<< Updated upstream

    @PostMapping ("/new")
    public String postNewArticleComment(ArticleCommentRequest articleCommentRequest) {
        // TODO: 인증 정보를 넣어줘야 한다.
        articleCommentService.saveArticleComment(articleCommentRequest.toDto(UserAccountDto.of(
                "uno", "pw", "uno@mail.com", null, null
        )));
=======
    @PostMapping ("/new")
    public String postNewArticleComment(
            @AuthenticationPrincipal com.fastcampus.projectboard.dto.security.BoardPrincipal boardPrincipal,
            ArticleCommentRequest articleCommentRequest
    ) {
        articleCommentService.saveArticleComment(articleCommentRequest.toDto(boardPrincipal.toDto()));
>>>>>>> Stashed changes


        return "redirect:/articles/" + articleCommentRequest.articleId();
    }

    @PostMapping ("/{commentId}/delete")
<<<<<<< Updated upstream
    public String deleteArticleComment(@PathVariable Long commentId, Long articleId) {
        articleCommentService.deleteArticleComment(commentId);

        return "redirect:/articles/" + articleId;
    }
}
=======
    public String deleteArticleComment(
            @PathVariable Long commentId,
            @AuthenticationPrincipal com.fastcampus.projectboard.dto.security.BoardPrincipal boardPrincipal,
            Long articleId
    ) {
        articleCommentService.deleteArticleComment(commentId, boardPrincipal.getUsername());

        return "redirect:/articles/" + articleId;
    }

}
>>>>>>> Stashed changes
