package com.namoo.mybatis.mapper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.namoo.mybatis.domain.Author;

public class AuthorMapperTest2 {
	//
	private SqlSession session;

	@Before
	public void setUp() throws Exception {
		//
		String config="com/namoo/mybatis/mapper/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

		//
		session = factory.openSession();
	}

	@Test
	public void testCRUD() {
		//
		String id = "testuser";
		String name = "테스트";
		String email = "test@test.com";
		
		// create
		Author author = new Author();
		author.setId(id);
		author.setName(name);
		author.setEmail(email);
		
//		authorMapper.insertAuthor(author);
		session.insert("com.namoo.mybatis.mapper.AuthorMapper.insertAuthor", author);
		
		// read
//		author = authorMapper.selectAuthor(id);
		author = session.selectOne("com.namoo.mybatis.mapper.AuthorMapper.selectAuthor", id);
		
		assertThat(id, is(author.getId()));
		assertThat(name, is(author.getName()));
		assertThat(email, is(author.getEmail()));
		
		// update
		author.setName("테스트2");
//		authorMapper.updateAuthor(author);
		session.update("com.namoo.mybatis.mapper.AuthorMapper.updateAuthor", author);
		
//		author = authorMapper.selectAuthor(id);
		author = session.selectOne("com.namoo.mybatis.mapper.AuthorMapper.selectAuthor", id);
		assertThat("테스트2", is(author.getName()));
		
		// delete
//		authorMapper.deleteAuthor(id);
		session.delete("com.namoo.mybatis.mapper.AuthorMapper.deleteAuthor", id);
		
		assertNull(session.selectOne("com.namoo.mybatis.mapper.AuthorMapper.selectAuthor", id));
	}
}
