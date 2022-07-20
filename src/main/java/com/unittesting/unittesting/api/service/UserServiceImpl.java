package com.unittesting.unittesting.api.service;

import com.unittesting.unittesting.api.domain.Users;
import com.unittesting.unittesting.api.repository.UsersRepository;
import com.unittesting.unittesting.api.service.exceptions.BadRequestException;
import com.unittesting.unittesting.api.service.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Override
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users addUsers(Users user) {
        Boolean existsEmail = usersRepository.selectExistsEmail(user.getEmail());

        if (existsEmail) {
            throw new BadRequestException("Email " + user.getEmail() + " taken");
        }

        return usersRepository.save(user);
    }

    public void deleteUser(Integer id) {
        if (!usersRepository.existsById(id)) {
            throw new UserNotFoundException("User with id " + id + " does not exists");
        }
        usersRepository.deleteById(id);
    }

}
