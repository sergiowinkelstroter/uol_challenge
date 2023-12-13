package br.com.sergiowink.uol_challenge.useCases;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Service
@Getter
public class CodiNameUseCase {
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;


    private List<String> avangersCodinameList = new ArrayList<>();
    private List<String> justiceLeagueList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void loadJsonData(){
        try{
            String codinameResponse = restTemplate.getForObject(env.getProperty("avangers"), String.class);
            JsonNode jsonNode = objectMapper.readTree(codinameResponse);

            ArrayNode avangers = (ArrayNode) jsonNode.get("vingadores");

            for(JsonNode item: avangers){
                this.avangersCodinameList.add(item.get("codinome").asText());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadXmlData(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =  factory.newDocumentBuilder();
            Document document = builder.parse(env.getProperty("justice.league"));

            NodeList codinameList = document.getElementsByTagName("codinome");

            for(int i = 0; i < codinameList.getLength(); i++){
                Element codinameElement = (Element) codinameList.item(i);
                String codiname = codinameElement.getTextContent();
                this.justiceLeagueList.add(codiname);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
