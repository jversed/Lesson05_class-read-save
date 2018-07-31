package prj061.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Product {
	private String type;
	private String name;
	private double weight;
	private double price;

	public Product (String type, String name, double weight, double price) {
		this.type=type;
		this.name=name;
		this.weight=weight;
		this.price=price;
	}
	public double getWeight() {
		return weight;
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	public void saveToFile(String fileName) {    	
    	try {
    		File file=new File(fileName);
			FileWriter fw = new FileWriter(file, false);			
			fw.write(type+" ");
			fw.write(name+" ");
			fw.write(Double.toString(weight)+" ");
			fw.write(Double.toString(price));
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	public void printP() {
		System.out.println("Product features: [ "+type+" "+name+" "+weight+" "+price+" ]");
	}
	
}
