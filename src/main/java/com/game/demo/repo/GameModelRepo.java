package com.game.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.demo.model.GameModel;

public interface GameModelRepo extends JpaRepository<GameModel,Integer> {

}
