package pe.I202224216.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.I202224216.cibertec.model.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Integer> {

}
