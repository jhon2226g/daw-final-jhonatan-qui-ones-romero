package pe.I202224216.cibertec.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.I202224216.cibertec.model.Car;
import pe.I202224216.cibertec.model.CarDTO;
import pe.I202224216.cibertec.repository.ICarRepository;
import pe.I202224216.cibertec.service.ICarService;

@Service
public class CarServiceImpl implements ICarService{
    @Autowired
    private ICarRepository _CarRepository;

    @Override
    public List<CarDTO> getAll() throws Exception {		
	return _CarRepository.findAll().stream().map(c -> 	
	   new CarDTO(c.getCarId(),
		   c.getMake(),
		   c.getModel(),
		   c.getYear(),
		   c.getVin(), 
		   c.getLicensePlate(),
		   c.getOwnerName(),
		   c.getOwnerContact(),
		   c.getPurchaseDate(),
		   c.getMileage(),
		   c.getEngineType(),
		   c.getColor(),
		   c.getInsuranceCompany(),
		   c.getInsurancePolicyNumber())
		).collect(Collectors.toList());
    }

    @Override
    public Optional<CarDTO> getById(Integer id) throws Exception {
	return _CarRepository.findById(id).map(c -> new CarDTO(c.getCarId(),
		   c.getMake(),
		   c.getModel(),
		   c.getYear(),
		   c.getVin(), 
		   c.getLicensePlate(),
		   c.getOwnerName(),
		   c.getOwnerContact(),
		   c.getPurchaseDate(),
		   c.getMileage(),
		   c.getEngineType(),
		   c.getColor(),
		   c.getInsuranceCompany(),
		   c.getInsurancePolicyNumber()));
    }

    @Override
    public boolean delete(Integer id) throws Exception {
	if (_CarRepository.existsById(id)) {
	    _CarRepository.deleteById(id);
	    return true;
	}
	return false;
    }

    @Override
    public boolean update(CarDTO c) throws Exception {
	return _CarRepository.findById(c.carId()).map(car ->{
	    car.setMake(c.make());
	    car.setModel( c.model());
	    car.setYear( c.year());
	    car.setLicensePlate(c.licensePlate());
	    car.setOwnerName(c.ownerName());
	    car.setOwnerContact(c.ownerContact());
	    car.setPurchaseDate(c.purchaseDate());
	    car.setMileage(c.mileage());
	    car.setEngineType(c.engineType());
	    car.setColor(c.color());
	    car.setInsuranceCompany(c.insuranceCompany());
	    car.setInsurancePolicyNumber(c.insurancePolicyNumber());
	    _CarRepository.save(car);
	    return true;
	}).orElse(false);
		   
    }

    @Override
    public boolean create(CarDTO c) throws Exception {
	Car car = new Car();
	car.setMake(c.make());
	    car.setModel( c.model());
	    car.setYear( c.year());
	    car.setLicensePlate(c.licensePlate());
	    car.setOwnerName(c.ownerName());
	    car.setOwnerContact(c.ownerContact());
	    car.setPurchaseDate(c.purchaseDate());
	    car.setMileage(c.mileage());
	    car.setEngineType(c.engineType());
	    car.setColor(c.color());
	    car.setInsuranceCompany(c.insuranceCompany());
	    car.setInsurancePolicyNumber(c.insurancePolicyNumber());
	if (_CarRepository.save(car)!=null) {
	    return true;
	}
	return false;
    }

}
