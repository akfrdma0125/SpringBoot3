package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Article;
import org.example.dto.AddArticleRequest;
import org.example.dto.ArticleResponse;
import org.example.dto.UpdateArticleRequest;
import org.example.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<ArticleResponse> findAll(){
        return blogRepository.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
    }

    public ArticleResponse findById(long id){

        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Not Found: "+id));

        return new ArticleResponse(article);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not Found: "+id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
