package com.game.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.game.demo.model.*;

public interface GameNameRepo extends JpaRepository<GameNames,String>{

}
