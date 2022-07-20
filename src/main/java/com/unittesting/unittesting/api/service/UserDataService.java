package com.unittesting.unittesting.api.service;

import com.unittesting.unittesting.api.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

public interface UserDataService {
    Page<Users> getUsers(Specification specification, PageRequest pageRequest);
}
