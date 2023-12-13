package br.com.sergiowink.uol_challenge.dto;

import br.com.sergiowink.uol_challenge.GroupType;

public record PlayerDTO( String name,String email, String phoneNumber, GroupType groupType) {
    
}
