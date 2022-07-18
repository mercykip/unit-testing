package com.unittesting.unittesting.api.repository;

import com.unittesting.unittesting.api.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query("" +
            "SELECT CASE WHEN COUNT(c) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Users c " +
            "WHERE c.email = ?1"
    )
    Boolean selectExistsEmail(String email);
}
