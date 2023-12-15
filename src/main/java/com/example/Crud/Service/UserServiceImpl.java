package com.example.Crud.Service;

import com.example.Crud.Model.User;
import com.example.Crud.Repository.IUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    private final IUserRepo userRepo;
    public UserServiceImpl(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
    @Override
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }
    @Override
    public User save(User user) {
        return userRepo.save(user);
    }
    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }
    @Override
    public void update(User user) {
        userRepo.save(user);
    }
}
