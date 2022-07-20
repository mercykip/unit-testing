package com.unittesting.unittesting.api.service;

import com.unittesting.unittesting.api.domain.Users;
import com.unittesting.unittesting.api.repository.UsersRepository;
import com.unittesting.unittesting.api.specification.SearchCriteria;
import com.unittesting.unittesting.api.specification.UserPredicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDataServiceImplTest {

    @Mock
    private UsersRepository userRepository;
    @InjectMocks
    private UserDataServiceImpl userService;

    @BeforeEach
    void setUp() {
        //initialize mock
        userService = new UserDataServiceImpl(userRepository);
    }

    @Test
    void getUsers() {
        //given
        //create a list for the mock
        Users m1 = new Users("test test", "test@gmail.com");
        Users m2 = new Users("test1 test1", "test1@gmail.com");
        UserPredicate spec = new UserPredicate(new SearchCriteria("email", ":", "test"));
        Pageable pageable = PageRequest.of(0, 2);
        given(userRepository.findAll(spec,pageable)).willReturn(new PageImpl<>(List.of(m1, m2), pageable, 0));

        //when
        userService.getUsers(spec, PageRequest.ofSize(2));

        //then
        verify(userRepository).findAll(spec, pageable);
    }
}