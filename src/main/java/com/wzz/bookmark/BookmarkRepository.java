package com.wzz.bookmark;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by WangZezhou(301255) on 2017/7/19.
 */
public interface BookmarkRepository extends JpaRepository<Bookmark,Long>{

    Collection<Bookmark> findByAccoutUserName(String userName);

}
