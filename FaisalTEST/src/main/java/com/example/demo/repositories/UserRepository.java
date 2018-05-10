package com.example.demo.repositories;

import com.example.demo.domains.MyUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<MyUser, Long> {

}
