package com.wzz.bookmark;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by WangZezhou(301255) on 2017/7/19.
 */

@Entity
public class Account {

    @OneToMany(mappedBy = "account")
    private Set<Bookmark> bookmarks = new HashSet<Bookmark>();

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    public String password;
    public String userName;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<Bookmark> getBookmarks(){
        return bookmarks;
    }
    public Account(String name, String password) {
        this.userName = name;
        this.password = password;
    }

    Account() { // jpa only
    }

}
