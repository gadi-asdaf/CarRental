package CarRentalApp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CarRentalApplication {
	private static JLabel label1, label2, label3;
	private static JTextField field1, field2, field3;
	private static boolean validInput = false;
	private static int numberOfPassengers;
	private static int rentalDays;
	private static double approxMileage;
	private static JButton searchButton;
	private static double cost;

	public static void main(String[] args) {
		startAPP();

	}
	
	static void startAPP(){
		JFrame frame = new JFrame();
		frame.setTitle("Cars Rental Application");
		frame.getContentPane().setBackground(Color.decode("#E5E3C9"));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 474, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/////// no of passengers
		label1 = new JLabel("Enter number of passengers: ");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label1.setForeground(Color.decode("#789395"));
		label1.setBounds(23, 35, 340, 14);
		frame.getContentPane().add(label1);

		field1 = new JTextField();
		field1.setColumns(10);
		field1.setBounds(200, 35, 180, 20);
		frame.getContentPane().add(field1);
		
		
	/////// no of days
		label2 = new JLabel("Enter number of rental days: ");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label2.setForeground(Color.decode("#789395"));
		label2.setBounds(23, 77, 340, 14);
		frame.getContentPane().add(label2);

		field2 = new JTextField();
		field2.setColumns(10);
		field2.setBounds(200, 77, 180, 20);
		frame.getContentPane().add(field2);
		
		//approximate milage
		label3 = new JLabel("Enter approximate milage: ");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label3.setForeground(Color.decode("#789395"));
		label3.setBounds(23, 118, 340, 14);
		frame.getContentPane().add(label3);

		field3 = new JTextField();
		field3.setColumns(10);
		field3.setBounds(200, 118, 180, 20);
		frame.getContentPane().add(field3);

		searchButton = new JButton("Search");
		searchButton.setForeground(Color.decode("#E5E3C9"));
		searchButton.setBackground(Color.decode("#789395"));
		searchButton.setBounds(181, 200, 89, 23);
		frame.getContentPane().add(searchButton);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					checkInput();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (validInput) {
					search();
				}

			}
		});
		frame.setVisible(true);
		
	}

	static void search() {
		CarsRepository carsRepo = CarsRepository.getCarsRepo();
		ArrayList<Car> suitableCars = carsRepo.findSuitableCars(numberOfPassengers,approxMileage, rentalDays);
		JFrame frame = new JFrame();
		frame.setTitle("Cars Rental Application");
		frame.getContentPane().setBackground(Color.decode("#E5E3C9"));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 474, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String result="";


		if (suitableCars.isEmpty()) {

			result+="Sorry there is no available car with more than 7 passengers.";

		}
		
		NumberFormat formater = new DecimalFormat("#0.00");
		for (Car car : suitableCars) {
			cost = car.calculatecost(approxMileage, rentalDays);
			result+=car.getCarInfo() + formater.format(cost)+(" \n\n------------------ ");

		}
		

	        frame.setSize(500, 500);  
	        frame.setVisible(true);
	  
	        frame.getContentPane().setLayout(new FlowLayout());
	  
	        JTextArea textArea = new JTextArea(20, 20);  
	        textArea.setText(result);
	        textArea.setEditable(false);
	        textArea.setBackground(Color.decode("#E5E3C9"));
	        textArea.setForeground(Color.decode("#789395"));
	        frame.getContentPane().add(textArea);  
		

		
	}

	static void checkInput() {

		try {
			numberOfPassengers = Integer.parseInt(field1.getText());
			
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Number Of Passengers must be an integer");
			return;
		}
		try {
			rentalDays = Integer.parseInt(field2.getText());
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "Rental days must be an integer");
			return;
		}
		try {
			approxMileage = Double.parseDouble(field3.getText());
		} catch (NumberFormatException e3) {
			JOptionPane.showMessageDialog(null, "Approximate milage must be a double");
			return;
		}
		
		try 
		{
			
			if(numberOfPassengers <= 0 || rentalDays <= 0 || approxMileage <= 0 ) 
			{
				throw new IllegalArgumentException();
			
			}

			else
			{
			
				validInput = true;
			
			}
		}
		
		catch (IllegalArgumentException e)
		{
			JOptionPane.showMessageDialog(null, "You must input a positive number in all fields");
		}
		

		

	}
}
