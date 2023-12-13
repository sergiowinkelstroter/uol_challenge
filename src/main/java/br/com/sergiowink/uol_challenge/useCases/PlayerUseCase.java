package br.com.sergiowink.uol_challenge.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.uol_challenge.GroupType;
import br.com.sergiowink.uol_challenge.dto.PlayerDTO;
import br.com.sergiowink.uol_challenge.entity.PlayerEntity;
import br.com.sergiowink.uol_challenge.infra.CodiNameHandler;
import br.com.sergiowink.uol_challenge.repositories.PlayerRepository;

@Service
public class PlayerUseCase {
    
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CodiNameHandler handler;

    public PlayerEntity createPlayer(PlayerDTO dto) {
        PlayerEntity newPlayer = new PlayerEntity(dto);
        String codiname = getCodiname(dto.groupType());
        newPlayer.setCodiname(codiname);
        return playerRepository.save(newPlayer);
    }

    private String getCodiname(GroupType groupType){
        return handler.findCodiname(groupType);
    }

    public List<PlayerEntity> getAllPlayers() {
        return playerRepository.findAll();
    }
}
