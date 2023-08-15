package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Article;
import org.example.dto.AddArticleRequest;
import org.example.dto.ArticleResponse;
import org.example.dto.UpdateArticleRequest;
import org.example.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        return ResponseEntity.ok()
                .body(blogService.findAll());
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findAllArticles(@PathVariable long id){
        return ResponseEntity.ok()
                .body(blogService.findById(id));
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
                                                 @RequestBody UpdateArticleRequest request){
        Article savedArticle = blogService.update(id,request);

        return ResponseEntity.ok()
                .body(savedArticle);
    }

}
