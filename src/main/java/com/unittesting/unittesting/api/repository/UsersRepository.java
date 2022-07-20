package com.unittesting.unittesting.api.repository;

import com.unittesting.unittesting.api.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {
    Boolean selectExistsEmail(String email);

}
