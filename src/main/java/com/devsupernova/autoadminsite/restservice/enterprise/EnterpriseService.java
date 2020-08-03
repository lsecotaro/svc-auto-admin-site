package com.devsupernova.autoadminsite.restservice.enterprise;

import com.devsupernova.autoadminsite.restservice.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseService {
    private final EnterpriseRepository repository;

    public List<Enterprise> getEnterprises(){
        return repository.findAll();
    }

    public Enterprise getEnterprise(String id) {
        return repository.getOne(id);
    }

    public Enterprise upsert(Enterprise enterprise){
        if(enterprise.getId() == null || enterprise.getId().isEmpty()){
            enterprise.setId(IdGenerator.generate());
        }
        return repository.save(enterprise);
    }

    public void delete(String id){
        repository.delete(repository.getOne(id));
    }
}
