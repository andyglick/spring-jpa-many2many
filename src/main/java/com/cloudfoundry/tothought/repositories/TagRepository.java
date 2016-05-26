package com.cloudfoundry.tothought.repositories;

import com.cloudfoundry.tothought.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by will on 26/05/2016.
 */
public interface TagRepository extends JpaRepository<Tag, Integer> {
}
