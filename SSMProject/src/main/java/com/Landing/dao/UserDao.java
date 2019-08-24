package com.Landing.dao;

import com.Landing.entity.User;

public interface UserDao {
    public abstract User findByUsername(String username);
}
