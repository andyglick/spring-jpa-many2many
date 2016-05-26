package com.cloudfoundry.tothought.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="POST")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POST_ID")
	private Integer postId;
	
	@Column(name="TITLE")
	private String title;

	@Column(name="POST_DATE")
	private Date postDate;

	@ManyToMany
	@JoinTable(name = "POST_TAG",
			joinColumns = {@JoinColumn(name="POST_ID")},
			inverseJoinColumns = { @JoinColumn(name="TAG_ID")})
	private List<Tag> tags = new ArrayList<Tag>();


	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
