package com.belajar.springboot.repository;

import com.belajar.springboot.model.TemporaryToken;
import com.belajar.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TemporaryTokenRepository extends JpaRepository<TemporaryToken, Integer> {
    Optional<TemporaryToken> findByToken (String token);
    Optional<TemporaryToken> findByUserId (User userId);
    @Query(value = "SELECT a.* FROM temporary_token a WHERE a.token = :token AND a.expired_date < :expired", nativeQuery = true)

    Optional<TemporaryToken> assffafsa(String token, Date expired);
}
