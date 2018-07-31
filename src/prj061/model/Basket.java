package prj061.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Basket {
	Product [] productBasket;
	//------------------------------------Creating basket-----------------------\\
	public Basket () {
		productBasket = new Product[10];
	}
	public Basket (int count) {
		productBasket = new Product[count];
	}
	//--------------------------------REad from file and SAve to file-----------------------------------------\\
	public void createBasketFromFile(String fileName) {
			try {
				BufferedReader bf = new BufferedReader(new FileReader(fileName));
				int countProduct;
				try {
					countProduct = Integer.parseInt(bf.readLine());
					productBasket = new Product[countProduct];
						for (int i = 0; i < productBasket.length; i++) {
							String prodSrtFeats;
							prodSrtFeats = bf.readLine();
							String [] prodFeats=prodSrtFeats.split(" ");
								if(prodFeats.length!=4) {						
									throw new IllegalArgumentException("error format product");
								}
								String type = prodFeats[0];
								String name = prodFeats[1];
								double weight = Double.parseDouble(prodFeats[2]);
								double price = Double.parseDouble(prodFeats[3]);
								productBasket[i]= new Product(type, name, weight, price);
								if(i==productBasket.length-1) {
									bf.close();	
								}
					}
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
				
			} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}	
		}
	public void saveToDirectory(String fileNameBasket) {
		File basketDir = new File("res\\"+fileNameBasket);
		basketDir.mkdir();
		for (int i = 0; i < productBasket.length; i++) {
			productBasket[i].saveToFile("res\\"+fileNameBasket+"\\Product"+i+".std");
		}
	}
	//---------------------------------------------------------------------------------------------------------\\
	public void findAllApples() {
		for (int i = 0; i < productBasket.length; i++) {
			if(productBasket[i].getName().equals("Apple")) {
				productBasket[i].printP();
			}	
		}
	}
	public void findMaxWeight () {
		double maxWeight=0;
		String nameMaxW="";
		int countMax = 0;
		for (int i = 0; i < productBasket.length; i++) {
			if(productBasket[i].getWeight()>maxWeight && productBasket[i].getPrice()<10) {
				maxWeight=productBasket[i].getWeight();
				nameMaxW=productBasket[i].getName();
				countMax=countMax+1;
			}
		}
		if(countMax==1) {
		System.out.println(countMax+" "+nameMaxW);}
		else System.out.println(countMax+" "+nameMaxW+"s");
	}
	
	public void generate10products () {
		productBasket[0]=new Product ("Fruits","Apple",1,8.5);
		productBasket[1]=new Product ("Fruits","Apple",1,14.5);
		productBasket[2]=new Product ("Vegetables","Potato",5,30);
		productBasket[3]=new Product ("Technic","TV",13,10000);
		productBasket[4]=new Product ("Technic","Laptop",4.2,15000);
		productBasket[5]=new Product ("Vegetables","Onion",13,56);
		productBasket[6]=new Product ("Fruits","Banana",3,78);
		productBasket[7]=new Product ("household chemicals","powder",0.5,24.8);
		productBasket[8]=new Product ("household chemicals","soap",0.3,23.5);
		productBasket[9]=new Product ("Technic","Phone",0.4,2420);
	}
	public void printB() {
		for (int i = 0; i < productBasket.length; i++) {
			productBasket[i].printP();
		}
	}
}
