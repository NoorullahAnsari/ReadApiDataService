package com.noor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noor.entity.ApiDataEntity;
import com.noor.repository.ApiEntryRepository;

@Service
public class ApiEntryService {
    private final ApiEntryRepository apiEntryRepository;

    @Autowired
    public ApiEntryService(ApiEntryRepository apiEntryRepository) {
        this.apiEntryRepository = apiEntryRepository;
    }

    public void saveApiEntriesFromApi() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.publicapis.org/entries";
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        String responseBody = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(responseBody);
            JsonNode entriesNode = rootNode.path("entries");
            List<ApiDataEntity> apiEntries = objectMapper.readValue(entriesNode.toString(), new TypeReference<List<ApiDataEntity>>() {});
            apiEntryRepository.saveAll(apiEntries);
            System.out.println(apiEntries);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    
    public List<ApiDataEntity> getApiData() {
    	
    	List<ApiDataEntity> list =null;
    	list = apiEntryRepository.findAll();
    	
    	if(list != null) {
    		return list;
    	}
    	return list;
    	
    }
    
    
 public void addApiData(ApiDataEntity apiDataEntity) {
    
	    	apiEntryRepository.save(apiDataEntity);
    }
    
    public void updateApiData(ApiDataEntity apiDataEntity, long id) {
    	
    	boolean bool = apiEntryRepository.existsById(id);
		if(bool) {
			
			apiDataEntity.setId(id);
	    	
	    	apiEntryRepository.save(apiDataEntity);
			
		}
		
		
    }
    public void deleteApiDataById(Long id) {
    	apiEntryRepository.deleteById(id);
    }
    
    
}
