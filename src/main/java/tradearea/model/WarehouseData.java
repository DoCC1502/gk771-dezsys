package tradearea.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JacksonXmlRootElement(localName = "warehouse")
public class WarehouseData {
	
	private String warehouseID;
	private String warehouseName;
	private String timestamp;
    private String warehouseAddress;
    private String warehousePostalCode;
    private String warehouseCity;
    private String warehouseCountry;

    List<WarehouseProduct>  products;

	/**
	 * Constructor
	 */
	public WarehouseData() {
		
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

	}






	/**
	 * Setter and Getter Methods
	 */
    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehousePostalCode() {
        return warehousePostalCode;
    }

    public void setWarehousePostalCode(String warehousePostalCode) {
        this.warehousePostalCode = warehousePostalCode;
    }

    public String getWarehouseCity() {
        return warehouseCity;
    }

    public void setWarehouseCity(String warehouseCity) {
        this.warehouseCity = warehouseCity;
    }

    public String getWarehouseCountry() {
        return warehouseCountry;
    }

    public void setWarehouseCountry(String warehouseCountry) {
        this.warehouseCountry = warehouseCountry;
    }

	public String getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

    public void addProductList(List<WarehouseProduct> products) {
        if ( this.products == null ) {
            this.products = products;
            return;
        }
        this.products.addAll(products);
    }

    public List<WarehouseProduct> getProducts() {
        return products;
    }


	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Warehouse Info: ID = %s, timestamp = %s", warehouseID, timestamp );
		return info;
	}
}
