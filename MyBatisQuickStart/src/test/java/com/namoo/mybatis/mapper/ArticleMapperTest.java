package com.namoo.mybatis.mapper;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.namoo.mybatis.domain.Article;

public class ArticleMapperTest {
	//
	private ArticleMapper articleMapper;
	
	@Before
	public void setUp() throws Exception {
		//
		String config="com/namoo/mybatis/mapper/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

		//
		SqlSession session = factory.openSession();
		articleMapper = session.getMapper(ArticleMapper.class);
	}

	@Test
	public void test() {
		//
		Article article = new Article();
		article.setSubject("제목입니다.");
		article.setContents("내용이지요.");
		
		articleMapper.insertArticle(article);
		
		System.out.println(article.getNo());
	}


}
