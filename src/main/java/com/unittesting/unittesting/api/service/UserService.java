package com.unittesting.unittesting.api.service;

import com.unittesting.unittesting.api.domain.Users;

import java.util.List;

public interface UserService {
    List<Users> getUsers();
    Users addUsers(Users student);
}
