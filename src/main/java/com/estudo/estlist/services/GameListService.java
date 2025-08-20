package com.estudo.estlist.services;

import com.estudo.estlist.dtos.GameListDTO;
import com.estudo.estlist.entities.GameList;
import com.estudo.estlist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        var result = gameListRepository.findAll();
//        return result.stream().map(GameListDTO::new).toList();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList result = gameListRepository.findById(id).get();
        return new GameListDTO(result);
    }
}
