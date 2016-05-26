package com.cloudfoundry.tothought.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by will on 26/05/2016.
 */
@Entity
@Table(name="TAG")
public class Tag {

    @Id
    @Column(name = "TAG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    @Column(name="NAME")
    private String name;



    //points to the tags field on the Post object. Post is the owning entity
    @ManyToMany(mappedBy = "tags")
    private List<Post> posts = new ArrayList<Post>();


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
