package tradearea.warehouse;

import tradearea.model.WarehouseData;
import tradearea.model.WarehouseProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WarehouseSimulation {




	private double getRandomDouble( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		double rounded = Math.round(number * 100.0) / 100.0; 
		return rounded;
		
	}

	private int getRandomInt( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		Long rounded = Math.round(number); 
		return rounded.intValue();

	}
	
	public WarehouseData getData( String inID ) {
		WarehouseData wd = new WarehouseData();
        WarehouseData wd2 = new WarehouseData();
		WarehouseData wd3 = new WarehouseData();

		wd.setWarehouseID("001");
        wd2.setWarehouseID("002");
        wd3.setWarehouseID("003");

        wd.setWarehouseName("Lagerhaus Wien");
        wd2.setWarehouseName("Lagerhaus Salzburg");
        wd3.setWarehouseName("Lagerhaus Graz");

        wd.setWarehouseAddress("Effingergasse 18");
        wd2.setWarehouseAddress("Fanny-von-Lehnert-Straße 5");
        wd3.setWarehouseAddress("Anzengrubergasse 1");

        wd.setWarehousePostalCode("1170");
        wd2.setWarehousePostalCode("5020");
        wd3.setWarehousePostalCode("8010");

        wd.setWarehouseCity("Wien");
        wd2.setWarehouseCity("Salzburg");
        wd3.setWarehouseCity("Graz");

        wd.setWarehouseCountry("Österreich");
        wd2.setWarehouseCountry("Österreich");
        wd3.setWarehouseCountry("Österreich");

        List<WarehouseProduct> products = new ArrayList<>();

        WarehouseProduct wp = new WarehouseProduct("P001", "Laptop", "Electronics", getRandomInt(10, 100), "pcs");
        WarehouseProduct wp2 = new WarehouseProduct("P002", "Smartphone", "Electronics", getRandomInt(20, 200), "pcs");
        WarehouseProduct wp3 = new WarehouseProduct("P003", "Tablet", "Electronics", getRandomInt(15, 150), "pcs");
        WarehouseProduct wp4 = new WarehouseProduct("P004", "Headphones", "Accessories", getRandomInt(30, 300), "pcs");
        WarehouseProduct wp5 = new WarehouseProduct("P005", "Smartwatch", "Wearables", getRandomInt(5, 50), "pcs");
        WarehouseProduct wp6 = new WarehouseProduct("P006", "Camera", "Photography", getRandomInt(8, 80), "pcs");
        WarehouseProduct wp7 = new WarehouseProduct("P007", "Printer", "Office Supplies", getRandomInt(12, 120), "pcs");
        WarehouseProduct wp8 = new WarehouseProduct("P008", "Monitor", "Electronics", getRandomInt(7, 70), "pcs");
        WarehouseProduct wp9 = new WarehouseProduct("P009", "Keyboard", "Accessories", getRandomInt(25, 250), "pcs");
        WarehouseProduct wp10 = new WarehouseProduct("P010", "Mouse", "Accessories", getRandomInt(30, 300), "pcs");

        products.add(wp);
        products.add(wp2);
        products.add(wp3);
        products.add(wp4);
        products.add(wp5);
        products.add(wp6);
        products.add(wp7);
        products.add(wp8);
        products.add(wp9);
        products.add(wp10);

        Collections.shuffle(products);
        for(int i=0; i<5; i++) {
            products.remove(i);
        }
        products.sort((a, b) -> a.getProductID().compareTo(b.getProductID()));
        System.out.println(wd.getTimestamp());
        switch (inID) {
            case "001":
                wd.addProductList(products);
                return wd;
            case "002":
                wd2.addProductList(products);
                return wd2;
            case "003":
                wd3.addProductList(products);
                return wd3;
            default:
                break;
        }
        return null;
	}


}
