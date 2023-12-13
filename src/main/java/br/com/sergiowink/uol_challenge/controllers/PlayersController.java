package br.com.sergiowink.uol_challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sergiowink.uol_challenge.dto.PlayerDTO;
import br.com.sergiowink.uol_challenge.entity.PlayerEntity;
import br.com.sergiowink.uol_challenge.useCases.PlayerUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/players")
public class PlayersController {
    

    @Autowired
    private PlayerUseCase playerUseCase;

    @PostMapping
    public ResponseEntity<PlayerEntity> createPlayer(@RequestBody @Valid PlayerDTO playeDto){
        var newPlayer = this.playerUseCase.createPlayer(playeDto);
        return ResponseEntity.ok().body(newPlayer);
    }

    @GetMapping
    public ResponseEntity<List<PlayerEntity>> getAllPlayers(){
        var players = this.playerUseCase.getAllPlayers();
        return ResponseEntity.ok().body(players);
    }
}
