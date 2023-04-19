package fastcampus.projectboard.controller;

import fastcampus.projectboard.config.SecurityConfig;
<<<<<<< Updated upstream
=======
import fastcampus.projectboard.config.TestSecurityConfig;
>>>>>>> Stashed changes
import fastcampus.projectboard.dto.ArticleCommentDto;
import fastcampus.projectboard.dto.request.ArticleCommentRequest;
import fastcampus.projectboard.service.ArticleCommentService;
import fastcampus.projectboard.util.FormDataEncoder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
<<<<<<< Updated upstream
=======
import org.springframework.security.test.context.support.TestExecutionEvent;
import org.springframework.security.test.context.support.WithUserDetails;
>>>>>>> Stashed changes
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@DisplayName("View 컨트롤러 - 댓글")
<<<<<<< Updated upstream
@Import({SecurityConfig.class, FormDataEncoder.class})
=======
@Import({TestSecurityConfig.class, FormDataEncoder.class})
>>>>>>> Stashed changes
@WebMvcTest(ArticleCommentController.class)
class ArticleCommentControllerTest {

    private final MockMvc mvc;
    private final FormDataEncoder formDataEncoder;

<<<<<<< Updated upstream
    @MockBean
    private ArticleCommentService articleCommentService;
=======
    @MockBean private ArticleCommentService articleCommentService;
>>>>>>> Stashed changes


    public ArticleCommentControllerTest(
            @Autowired MockMvc mvc,
            @Autowired FormDataEncoder formDataEncoder
    ) {
        this.mvc = mvc;
        this.formDataEncoder = formDataEncoder;
    }


<<<<<<< Updated upstream
=======
    @WithUserDetails(value = "unoTest", setupBefore = TestExecutionEvent.TEST_EXECUTION)
>>>>>>> Stashed changes
    @DisplayName("[view][POST] 댓글 등록 - 정상 호출")
    @Test
    void givenArticleCommentInfo_whenRequesting_thenSavesNewArticleComment() throws Exception {
        // Given
        long articleId = 1L;
        ArticleCommentRequest request = ArticleCommentRequest.of(articleId, "test comment");
        willDoNothing().given(articleCommentService).saveArticleComment(any(ArticleCommentDto.class));

        // When & Then
        mvc.perform(
                        post("/comments/new")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .content(formDataEncoder.encode(request))
                                .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/articles/" + articleId))
                .andExpect(redirectedUrl("/articles/" + articleId));
        then(articleCommentService).should().saveArticleComment(any(ArticleCommentDto.class));
    }

<<<<<<< Updated upstream
=======
    @WithUserDetails(value = "unoTest", setupBefore = TestExecutionEvent.TEST_EXECUTION)
>>>>>>> Stashed changes
    @DisplayName("[view][GET] 댓글 삭제 - 정상 호출")
    @Test
    void givenArticleCommentIdToDelete_whenRequesting_thenDeletesArticleComment() throws Exception {
        // Given
        long articleId = 1L;
        long articleCommentId = 1L;
<<<<<<< Updated upstream
        willDoNothing().given(articleCommentService).deleteArticleComment(articleCommentId);
=======
        String userId = "unoTest";
        willDoNothing().given(articleCommentService).deleteArticleComment(articleCommentId, userId);
>>>>>>> Stashed changes

        // When & Then
        mvc.perform(
                        post("/comments/" + articleCommentId + "/delete")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .content(formDataEncoder.encode(Map.of("articleId", articleId)))
                                .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/articles/" + articleId))
                .andExpect(redirectedUrl("/articles/" + articleId));
<<<<<<< Updated upstream
        then(articleCommentService).should().deleteArticleComment(articleCommentId);
=======
        then(articleCommentService).should().deleteArticleComment(articleCommentId, userId);
>>>>>>> Stashed changes
    }

}
