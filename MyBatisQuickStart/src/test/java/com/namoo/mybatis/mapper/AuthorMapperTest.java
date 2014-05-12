package com.namoo.mybatis.mapper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.namoo.mybatis.domain.Author;

public class AuthorMapperTest {
	//
	private AuthorMapper authorMapper;
	

	@Before
	public void setUp() throws Exception {
		//
		String config="com/namoo/mybatis/mapper/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

		//
		SqlSession session = factory.openSession();
		authorMapper = session.getMapper(AuthorMapper.class);
	}

	@Test
	public void testInsertAuthor() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAuthor() {
		//
		Author author = authorMapper.selectAuthor("hyunhokim");
		
		assertThat("hyunhokim", is(author.getId()));
		assertThat("김현오", is(author.getName()));
		assertThat("hyunhokim@nextree.co.kr", is(author.getEmail()));
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
		
		authorMapper.insertAuthor(author);
		
		// read
		author = authorMapper.selectAuthor(id);
		
		assertThat(id, is(author.getId()));
		assertThat(name, is(author.getName()));
		assertThat(email, is(author.getEmail()));
		
		// update
		author.setName("테스트2");
		authorMapper.updateAuthor(author);
		
		author = authorMapper.selectAuthor(id);
		assertThat("테스트2", is(author.getName()));
		
		// delete
		authorMapper.deleteAuthor(id);
		
		assertNull(authorMapper.selectAuthor(id));
		
	}
	
	
	@Test
	public void testSelectAllAuthors() {
		//
		List<Author> authors = authorMapper.selectAllAuthors();
		
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		
		assertThat(authors.size(), is(2));
		
		System.out.println(authors.size());
		System.out.println(authors.get(0).getName());
		System.out.println(authors.get(1).getName());
		
		
		
	}

	@Test
	public void testUpdateAuthor() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAuthor() {
		fail("Not yet implemented");
	}

}
