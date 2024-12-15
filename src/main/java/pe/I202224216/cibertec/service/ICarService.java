package pe.I202224216.cibertec.service;

import java.util.List;
import java.util.Optional;

import pe.I202224216.cibertec.model.Car;
import pe.I202224216.cibertec.model.CarDTO;

public interface ICarService {

    List<CarDTO> getAll() throws Exception;

    Optional<CarDTO> getById(Integer id) throws Exception;

    boolean delete(Integer id) throws Exception;

    boolean update(CarDTO entity) throws Exception;

    boolean create(CarDTO entity) throws Exception;

}
