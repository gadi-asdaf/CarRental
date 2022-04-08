package CarRentalApp;

import java.util.ArrayList;

public class CarsRepository {
	private ArrayList<Car> carsRepo=new ArrayList<Car>();
	private static CarsRepository cars=null;

	private CarsRepository() {
		carsRepo.add(new Economy( "Coupe","Mazda","2011 Rx-8",18));
		carsRepo.add(new Economy( "Coupe","Porsche","2022 718 Cayman",20));
		carsRepo.add(new Economy( "Coupe","Mercedes-Benz","2017 E-class",23));
		carsRepo.add(new Intermediate( "Sedan","BMW","2022 M5",17));
		carsRepo.add(new Intermediate( "Sedan","Hyundai","2020 Elantra",35));
		carsRepo.add(new Intermediate("Sedan","Toyota","2022 Avalon",26));
		carsRepo.add(new Intermediate("Hybird","Kia","2020 Optima Hybird",42));
		carsRepo.add(new Intermediate( "Hybird","Volvo","2022 S60",69));
		carsRepo.add(new Intermediate("Hybird","Mitsubishi","2021 outlander",74));
		carsRepo.add(new Standard("Truck","Ford","2022 F150 Supercrew Cab",21));
		carsRepo.add(new Standard("Truck","Rivian","2021 R1T",70));
		carsRepo.add(new Standard("Truck","Chevrolet","2021 Silverado 2500 HD Crew Cab",14));
		carsRepo.add(new Standard( "SUV","Kia","2022 Seltos",29));
		carsRepo.add(new Standard( "SUV","Genesis","2022 GV80",23));
		carsRepo.add(new Standard("SUV","BMW","2021 X5",23));
		carsRepo.add(new Standard("Crossover","Audi","2022 Q5",23));
		carsRepo.add(new Standard("Crossover","Dodge","2021 Journey",19));
		carsRepo.add(new Standard("Crossover","Lexus","2022 RX",24));
		carsRepo.add(new Van(  "Van","Honda","2020 Odyssey",24));
		carsRepo.add(new Van( "Van","Nissan","2019 NV200",25));
		carsRepo.add(new Van( "Van","Chrysler","2017 Pacifica",22));
					
	}
	
	 static CarsRepository getCarsRepo() {
		if(cars==null) {
			cars=new CarsRepository();		}
		return cars;
	}

	 
	 ArrayList<Car> findSuitableCars(int noOfPassangers,double approxMilage,int rentalDays){
		 //find cars with suitable noOfPassangers
	 ArrayList<Car> suitableCars=new ArrayList<Car>();
	 for(Car car:carsRepo) {
		 if(noOfPassangers<=car.getMaxPassengers()) {
			 suitableCars.add(car);
		 }
	 }
	 //find cars with cheapest cost 
	 ArrayList<Car> selectedCars=new ArrayList<Car>();
	 double minimumCost = Double.MAX_VALUE;
	 
	 for(Car car:suitableCars) {
		 double totalCost=car.calculatecost(approxMilage, rentalDays);
		 if(totalCost<minimumCost)	{
			 selectedCars.removeAll(selectedCars);
			 minimumCost=totalCost;
			 selectedCars.add(car);
		 }
		 else if(totalCost==minimumCost){
			 selectedCars.add(car);
		 }
			 
		 }

	 return selectedCars;
 
 }
	 }
	 
	


