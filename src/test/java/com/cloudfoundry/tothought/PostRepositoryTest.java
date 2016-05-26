package com.cloudfoundry.tothought;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import com.cloudfoundry.tothought.entities.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloudfoundry.tothought.entities.Post;
import com.cloudfoundry.tothought.repositories.PostRepository;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class PostRepositoryTest {

	@Autowired
	PostRepository repository;
	
	@Test
	@Transactional
	public void test() {
		Post post = new Post();
		post.setPostDate(new Date());
		post.setTitle("First Post");

		Tag tag1 = new Tag();
		Tag tag2 = new Tag();
		tag1.setName("Java");
		tag2.setName("Java2");

		post.getTags().add(tag1);
		post.getTags().add(tag2);

		repository.save(post);
		
		Post dbpost = repository.findOne(post.getPostId());
		assertNotNull(dbpost);
		System.out.println(dbpost.getTitle());

		List<Tag> tags = dbpost.getTags();
		assertTrue(tags.size() == 2);
		assertTrue(tags.contains(tag1));
		assertTrue(tags.contains(tag2));
	}

}
