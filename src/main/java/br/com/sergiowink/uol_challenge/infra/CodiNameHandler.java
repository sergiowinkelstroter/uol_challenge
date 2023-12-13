package br.com.sergiowink.uol_challenge.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sergiowink.uol_challenge.GroupType;
import br.com.sergiowink.uol_challenge.useCases.CodiNameUseCase;

@Component
public class CodiNameHandler {
    @Autowired
    private CodiNameUseCase codiNameUseCase;

    public String findCodiname(GroupType groupType) {
        if(groupType == GroupType.AVANGERS){
            String firstMatch = codiNameUseCase.getAvangersCodinameList().stream().findFirst().orElseThrow();
            this.codiNameUseCase.getAvangersCodinameList().remove(firstMatch);
            return firstMatch;
        }
        String firstMatch = codiNameUseCase.getJusticeLeagueList().stream().findFirst().orElseThrow();
        this.codiNameUseCase.getJusticeLeagueList().remove(firstMatch);
        return firstMatch;
    }
}
