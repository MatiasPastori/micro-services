package com.jamsvs.app.users.services;

import org.springframework.stereotype.Service;

import com.jamsvs.app.commons.users.models.entity.User;
import com.jamsvs.app.users.models.repository.UserRepository;
import com.jamsvs.commons.services.CommonServiceImpl;

@Service
public class UserServiceImpl extends CommonServiceImpl<User, UserRepository> implements UserService {

}
