package com.duoc.heartless.service;

import com.duoc.heartless.model.Resena;
import com.duoc.heartless.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;
    
    public List<Resena> getResenas() {
        return resenaRepository.findAll();
    }

    public Resena saveResena(Resena resena) {
        return resenaRepository.save(resena);
    }

    public Resena getResenaId(Integer id) {
        return resenaRepository.findById(id).orElse(null);
    }

    public Resena updateResena(Resena resena) {
    if (!resenaRepository.existsById(resena.getId_resena())) {
        return null;
    }
    return resenaRepository.save(resena);
}

    public boolean deleteResena(Integer id) {
        if (resenaRepository.existsById(id)) {
            resenaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
