package com.cloudfoundry.tothought;

import com.cloudfoundry.tothought.entities.Post;
import com.cloudfoundry.tothought.entities.Tag;
import com.cloudfoundry.tothought.repositories.PostRepository;
import com.cloudfoundry.tothought.repositories.TagRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class TagRepositoryTest {

	@Autowired
	TagRepository repository;
	
	@Test
	@Transactional
	public void test() {


		Tag tag = new Tag();
		tag.setName("Java");

		Post post = new Post();
		post.setPostDate(new Date());
		post.setTitle("First Post");

		Post post2 = new Post();
		post2.setPostDate(new Date());
		post2.setTitle("First Post");


		tag.getPosts().add(post);
		tag.getPosts().add(post2);

		repository.save(tag);
		
		Tag dbTag = repository.findOne(tag.getTagId());
		assertNotNull(dbTag);

		List<Post> posts = dbTag.getPosts();
		assertTrue(posts.size() == 2);
		assertTrue(posts.contains(post));
		assertTrue(posts.contains(post2));
	}

}
