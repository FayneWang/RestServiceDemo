package com.wzz.bookmark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Created by WangZezhou(301255) on 2017/7/20.
 */

@RestController
@RequestMapping("/bookmarks")
public class BookmarkRestController {

    @Autowired
    private String user;
    private final AccountRepository accountRepository;
    private final BookmarkRepository bookmarkRepository;

    BookmarkRestController(AccountRepository accountRepository,
                           BookmarkRepository bookmarkRepository){
        this.accountRepository = accountRepository;
        this.bookmarkRepository = bookmarkRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Bookmark> readBookmarks(@PathVariable String userId){

        return null;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    ResponseEntity<?> add(@PathVariable("{id}") String userId, @RequestBody Bookmark input) {
        this.validateUser(userId);

        return this.accountRepository
                .findByUserName(userId)
                .map(account -> {
                    Bookmark result = bookmarkRepository.save(new Bookmark(account,
                            input.uri, input.description));

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(result.getId()).toUri();

                    return ResponseEntity.created(location).build();
                })
                .orElse(ResponseEntity.noContent().build());

    }

    private void validateUser(String userId){
        this.accountRepository.findByUserName(userId).orElseThrow(
                ()->new UserNotFoundException(userId));
    }
}
