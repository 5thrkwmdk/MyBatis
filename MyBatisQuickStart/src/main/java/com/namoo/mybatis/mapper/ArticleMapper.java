package com.namoo.mybatis.mapper;

import com.namoo.mybatis.domain.Article;

public interface ArticleMapper {
	//
	void insertArticle(Article article);
	Article selectArticle(int articleNo);

}
