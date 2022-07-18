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

    @AfterEach
    void tearDown() {
        //delete all users after each test
        userRepository.deleteAll();
    }

    @Test
    void selectEmailExists() {
        //create a user in  h2
        String email = "mercyjemosop@gmail.com";
        Users Users = new Users(
                "mercy",
                email
        );
        userRepository.save(Users);

        //check if the user exists by email in your Users table
        boolean exist = userRepository.selectExistsEmail(email);

        //check if our boolean value matches the expected value
        assertThat(exist).isTrue();
    }

    @Test
    void selectEmailNotExist() {
        //create a user in  h2
        String email = "mercyjemosops@gmail.com";

        //check if the user exists by email in your Users table()
        boolean exist = userRepository.selectExistsEmail(email);

        //check if our boolean value matches the expected value
        assertThat(exist).isFalse();
    }


}