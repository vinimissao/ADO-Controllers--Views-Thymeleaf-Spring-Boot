package br.com.carstore.service;

import br.com.carstore.dto.CarDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements Carservice {

    private final List<CarDTO> carList;

    public CarServiceImpl() {
        this.carList = new ArrayList<>();
    }

    public List<CarDTO> findAll(){
        return this.carList;
    }

    public void save(CarDTO carDTO){
        if (carDTO.getid() == null){
            carDTO.setid(UUID.randomUUID().toString());
        }
        this.carList.add(carDTO);
    }

    public void deleteByID(String id){
        this.carList.removeIf(car -> car.getid().equals(id));
    }

    @Override
    public void UPDATE(String ID, CarDTO carDTO) {

    }

    public void update(String id, CarDTO carDTO) {
        this.carList.replaceAll(car -> car.getid().equals(id) ? carDTO : car);
    }

    public CarDTO findById(String id) {
        return this.carList.stream()
                .filter(car -> car.getid().equals(id))
                .findFirst()
                .orElse(null);
    }

}