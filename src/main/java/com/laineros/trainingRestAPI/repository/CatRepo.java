package com.laineros.trainingRestAPI.repository;

import com.laineros.trainingRestAPI.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends JpaRepository<Cat, Integer> {

}
