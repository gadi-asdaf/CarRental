package CarRentalApp;

public class Car {
	
	private double rentalCost; 
	private int maxPassengers;
	private String comfortLevel;
	private String carCategory;
	private String carMaker;
	private String carModel;
	private int MPG;
	Car(double rentalCost, int maxPassengers, String comfortLevel, String carCategory, String carMaker, String carModel,
			int MPG) {
		super();
		this.rentalCost = rentalCost;
		this.maxPassengers = maxPassengers;
		this.comfortLevel = comfortLevel;
		this.carCategory = carCategory;
		this.carMaker = carMaker;
		this.carModel = carModel;
		this.MPG = MPG;
	}
	
	double calculatecost(double approxMilage , int rentalDays) {
		double mile=(approxMilage/MPG)*2.25;
		double totalCost=mile+(rentalCost*rentalDays); 
		return totalCost;
	}
	
	int getMPG() {
		return MPG;
	}

	void setMPG(int MPG) {
		this.MPG = MPG;
	}

	double getRentalCost() {
		return rentalCost;
	}
	void setRentalCost(double rentalCost) {
		this.rentalCost = rentalCost;
	}
	int getMaxPassengers() {
		return maxPassengers;
	}
	void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
	String getComfortLevel() {
		return comfortLevel;
	}
	void setComfortLevel(String comfortLevel) {
		this.comfortLevel = comfortLevel;
	}
	String getCarCategory() {
		return carCategory;
	}
	void setCarCategory(String carCategory) {
		this.carCategory = carCategory;
	}
	String getCarMaker() {
		return carMaker;
	}
	void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}
	String getCarModel() {
		return carModel;
	}
	void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	String getCarInfo(){
		// able to see the car make and model, the number of passengers it could fit, and the total cost associated with the trip. 
	     return "\n Car Maker :" + this.carMaker
		 	     	+ "\n Car Model :" + this.carModel
		 	     	+ "\n Comfort Level :" + this.comfortLevel
			     	+ "\n The Number of Passengers:" + this.maxPassengers+"\nTotal Cost: ";
	     
    }
	
	
	
	
	



}
