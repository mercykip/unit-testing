package com.unittesting.unittesting.globals;

import com.unittesting.unittesting.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GlobalRepository {
    public static UsersRepository userRepository;

    @Autowired
    public static void setUserRepository(UsersRepository userRepository) {
        GlobalRepository.userRepository = userRepository;
    }
}
