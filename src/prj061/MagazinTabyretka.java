package prj061;

import prj061.model.Basket;
import prj061.model.Product;

public class MagazinTabyretka {

	public static void main(String[] args) {
		
		Product prod1=new Product("Technic", "TV", 5, 12000);
		prod1.printP();
		System.out.println("-------------------------------------");
		Basket basket1 = new Basket();
		//basket1.generate10products();
		basket1.createBasketFromFile("E:\\in\\Products.txt");
		basket1.printB();
		basket1.findMaxWeight();
		basket1.findAllApples();
		basket1.saveToDirectory("basket1");
		
		
		
		
		
		
		
		
	}

}
