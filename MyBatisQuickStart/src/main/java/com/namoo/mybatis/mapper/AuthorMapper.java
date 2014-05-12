package com.namoo.mybatis.mapper;

import java.util.List;

import com.namoo.mybatis.domain.Author;

public interface AuthorMapper {
	//
	void insertAuthor(Author author);
	Author selectAuthor(String authorId);
	List<Author> selectAllAuthors();
	void updateAuthor(Author author);
	
//	@Delete("DELETE from author_tb WHERE author_id = #{authorId}")
	void deleteAuthor(String authorId);

}
