package pe.I202224216.cibertec.model;

import java.time.LocalDate;

public record CarDTO(
	 Integer carId,
	     String make,
	     String model,
	     Integer year,
	     String vin,
	     String licensePlate,
	     String ownerName,
	     String ownerContact,
	     LocalDate purchaseDate,
	     Integer mileage,
	     String engineType,
	     String color,
	     String insuranceCompany,
	     String insurancePolicyNumber
	) {

}
