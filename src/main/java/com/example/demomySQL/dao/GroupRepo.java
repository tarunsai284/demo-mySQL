package com.example.demomySQL.dao;

import com.example.demomySQL.model.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepo extends JpaRepository<GroupModel, String> {

    @Override
    Optional<GroupModel> findById(String s);
}
