package pe.I202224216.cibertec.rest;

import org.springframework.web.bind.annotation.RestController;

import pe.I202224216.cibertec.model.Car;
import pe.I202224216.cibertec.model.CarDTO;
import pe.I202224216.cibertec.service.ICarService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class CarRestController {
    @Autowired
    private ICarService _CarService;
    
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
	try {
	    List<CarDTO> cars = _CarService.getAll();	    
	    return ResponseEntity.ok(cars) ;	    
	} catch (Exception e) {
	    e.printStackTrace();
	    return ResponseEntity.badRequest().body("error al obtener todos los registros");
	}
    }
    
    @GetMapping("/detail")
    public ResponseEntity<?> get(@RequestParam Integer id) {
          try {
          Optional<CarDTO> op = _CarService.getById(id);
          if (op.isPresent()) {              
              return ResponseEntity.ok().body(op.get());                    	    
          }
	    return ResponseEntity.badRequest().body("error al obtener");
	} catch (Exception e) {
	    e.printStackTrace();
	    return ResponseEntity.badRequest().body("error al obtener");
	}     
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> update( @RequestBody CarDTO entity) {        
        try {
	    return ResponseEntity.ok().body(_CarService.update(entity));
	} catch (Exception e) {
	    e.printStackTrace();
	    return ResponseEntity.badRequest().body("error al actualizar");
	}
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            _CarService.delete(id);
	   return  ResponseEntity.ok().body("se eliminó con éxito");
	} catch (Exception e) {
	    e.printStackTrace();
	    return ResponseEntity.badRequest().body("error al eliminar");
	}            
    }
    @PostMapping("/create")
    public ResponseEntity<?> postMethodName(@RequestBody CarDTO entity) {
	
	try {
	    return ResponseEntity.ok().body(_CarService.create(entity));
	} catch (Exception e) {
	    e.printStackTrace();
	    return ResponseEntity.badRequest().body("error al crear");		 
	}
    }
    
    
    
    
    
    
}
