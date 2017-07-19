package com.wzz.bookmark;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by WangZezhou(301255) on 2017/7/19.
 */
public interface AccountRepository extends JpaRepository<Account,Long>{
    Optional<Account> findByUserName(String userName);
}
