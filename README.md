# Middleware Engineering "REST and Data Formats"

## Aufgabenstellung
Entwickeln Sie einen Simulator, der die Daten eines Lagerstandortes (WHx) generiert.
Es ist dabei zu achten, dass die Daten realistisch sind und im Zusammenhang mit entsprechenden Einheiten erzeugt werden.
Diese Daten sollen gemeinsam mit einigen Details zu dem Standort ueber eine REST Schnittstelle veroeffentlicht werden.
Die Schnittstelle verwendet standardmaessig das JSON Format und kann optional auf XML umgestellt werden.

## Implementierung

### GK

Implementierung eines Generator zur Erzeugung der Standort- und Warendaten

```java
WarehouseData wd = new WarehouseData();
WarehouseData wd2 = new WarehouseData();
WarehouseData wd3 = new WarehouseData();

List<WarehouseProduct> products = new ArrayList<>();

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
```

Implementierung der REST Schnittstelle & Daten im JSON und XML Format zur Verfuegung stellen

```java
@RequestMapping(value="/{inID}/json", produces = MediaType.APPLICATION_JSON_VALUE)
public WarehouseData warehouseData( @PathVariable String inID ) {
    return service.getWarehouseData( inID );
}

@RequestMapping(value="/{inID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
public WarehouseData warehouseDataXML( @PathVariable String inID ) {
    return service.getWarehouseData(inID);
}
```

### EK


Implementation eines "Consumer" und Darstellung der Daten in einer Tabelle
Daten koennen nach folgenden Kriterien gefiltert werden:
* Standort
* Produktname

HTML
```html
<!-- Dropdown für Warehouse Auswahl -->
<label for="warehouseSelect">Warehouse auswählen:</label>
<select id="warehouseSelect">
    <option value="001">Lagerhaus Wien</option>
    <option value="002">Lagerhaus Salzburg</option>
    <option value="003">Lagerhaus Graz</option>
</select>

<!-- Standort-Infos -->
<div id="warehouseInfo"></div>

<!-- Filter -->
<label for="productName">Produktname:</label>
<input type="text" id="productName" placeholder="z.B. Mouse">

<table id="productTable">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Kategorie</th>
        <th>Menge</th>
        <th>Einheit</th>
    </tr>
    </thead>
    <tbody></tbody>
</table>
```
JS
```javascript
async function loadData() {
    const selectedWarehouse = document.getElementById("warehouseSelect").value;
    const url = `/warehouse/${selectedWarehouse}/json`; // dynamisch
    ...
}

function renderData() {
    if (!warehouseData) return;

    const tbody = document.querySelector("#productTable tbody");
    tbody.innerHTML = "";

    // Standort-Infos anzeigen
    document.getElementById("warehouseInfo").innerHTML = `
                <h2>${warehouseData.warehouseName}</h2>
                <p>${warehouseData.warehouseAddress}, ${warehouseData.warehousePostalCode} ${warehouseData.warehouseCity}, ${warehouseData.warehouseCountry}</p>
                <p><b>Timestamp:</b> ${warehouseData.timestamp}</p>
            `;

    // Produkte rendern mit Filter
    warehouseData.products
        .filter(p => !productFilter || p.productName.toLowerCase().includes(productFilter))
        .forEach(p => {
            const row = `
                        <tr>
                            <td>${p.productID}</td>
                            <td>${p.productName}</td>
                            <td>${p.productCategory}</td>
                            <td>${p.productQuantity}</td>
                            <td>${p.productUnit}</td>
                        </tr>`;
            tbody.innerHTML += row;
        });
}

```

## Quellen

* XML Daten - Timing Station (Example) warehouse.xml
* Spring Boot https://spring.io/projects/spring-boot
* Building an Application with Spring Boot https://spring.io/guides/gs/spring-boot/
* Spring Initializr https://start.spring.io/
* Building a RESTful Web Service https://spring.io/guides/gs/rest-service/
* Consuming a RESTful Web Service https://spring.io/guides/gs/consuming-rest/
