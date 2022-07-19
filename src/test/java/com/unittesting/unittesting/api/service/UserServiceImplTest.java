package com.unittesting.unittesting.api.service;

import com.unittesting.unittesting.api.domain.Users;
import com.unittesting.unittesting.api.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UsersRepository userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        //initialize mock
        userService = new UserServiceImpl(userRepository);
    }

//    @AfterEach
//    void tearDown() {
//        //delete all users after each test
//        userRepository.deleteAll();
//    }

    @Test
    void getUsers() {
        userService.getUsers();
        verify(userRepository).findAll();
    }

    @Test
    void addUsers() {
        //create a user in  h2
        Users users = new Users(1, "mercy", "mercyjemosop@gmail.com");
        userService.addUsers(users);

        // captures the actual value of the student passed to the save method
        ArgumentCaptor<Users> studentArgumentCaptor = ArgumentCaptor.forClass(Users.class);
        verify(userRepository).save(studentArgumentCaptor.capture());

        Users capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(users);

    }

    @Test
    @DirtiesContext
    void deleteUsers() {
        Integer id = 1;
        given(userRepository.existsById(id)).willReturn(true);

        userService.deleteUser(id);

        verify(userRepository).deleteById(1);
    }

    @Test
    void throwEmailExists() {
        //check if email exit and if the save method is called
        //if email exist, the save method should not be called
        //create a user in  h2
        String email = "mercyjemosop@gmail.com";
        Users users = new Users("mercy", email);

        given(userRepository.selectExistsEmail(users.getEmail())).willReturn(true);

        assertThatThrownBy(() -> userService.addUsers(users)).isInstanceOf(BadRequestException.class).hasMessageContaining("Email " + users.getEmail() + " taken");

        verify(userRepository, never()).save(any());
    }

    @Test
    void throwIdExists() {
        //check if user id exit
        //if email exist, the save method should not be called
        //create a user in  h2
        Integer id = 1;

        given(userRepository.existsById(id)).willReturn(false);

        assertThatThrownBy(() -> userService.deleteUser(id)).isInstanceOf(UserNotFoundException.class).hasMessageContaining("User with id " + id + " does not exists");

        verify(userRepository, never()).deleteById(id);
    }

}