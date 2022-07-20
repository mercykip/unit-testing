package com.unittesting.unittesting.api.service;

import com.unittesting.unittesting.api.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDataServiceImpl implements UserDataService {

    private final UsersRepository usersRepository;

    @Override
    public Page getUsers(Specification specification, PageRequest pageRequest) {
        return usersRepository.findAll(specification,pageRequest);
    }


}
