package com.unittesting.unittesting.api.repository;

import com.unittesting.unittesting.api.domain.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UsersRepositoryTest {

    @Autowired
    private UsersRepository userRepository;

    @Test
    void selectExistsEmail() {

        String email = "mercyjemosop@gmail.com";

        //create a user in  h2
        Users Users = new Users(

                "mercy",
                "mercyjemosop@gmail.com"
        );
        userRepository.save(Users);

        //check if the user exists by email
        boolean exist = userRepository.selectExistsEmail(email);

        //check if our boolean value matches the expected value
        assertThat(exist).isTrue();

    }
}