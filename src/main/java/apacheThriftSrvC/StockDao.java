package apacheThriftSrvC;


import java.util.HashMap;
import java.util.Map;

public enum StockDao{
	instance;

	private Map<String, Map<String, Map<String,String>>> stock;

	private StockDao() {
		this.stock = new HashMap<String, Map<String, Map<String,String>>>();
		Map<String, Map<String,String>> prenda1 =  new HashMap<String, Map<String,String>>();
		Map<String, String> azul =  new HashMap<String, String>();
		azul.put("36", "5");
		azul.put("38", "10");
		azul.put("40", "15");
		azul.put("42", "20");
		Map<String, String> negro =  new HashMap<String, String>();
		negro.put("36", "6");
		negro.put("38", "11");
		negro.put("40", "16");
		negro.put("42", "21");
		Map<String, String> verde =  new HashMap<String, String>();
		verde.put("36", "20");
		verde.put("38", "15");
		verde.put("40", "10");
		verde.put("42", "5");
		Map<String, String> rojo =  new HashMap<String, String>();
		rojo.put("36", "21");
		rojo.put("38", "16");
		rojo.put("40", "11");
		rojo.put("42", "6");
		Map<String, String> blanco =  new HashMap<String, String>();
		blanco.put("36", "3");
		blanco.put("38", "3");
		blanco.put("40", "3");
		blanco.put("42", "3");
		prenda1.put("Azul", azul);
		prenda1.put("Rojo", rojo);
		prenda1.put("Verde", verde);
		prenda1.put("Negro", negro);
		prenda1.put("Blanco", blanco);
		this.stock.put("Prenda1", prenda1);
		Map<String, Map<String,String>> prenda2 =  new HashMap<String, Map<String,String>>();
		prenda2.put("Azul", azul);
		prenda2.put("Rojo", rojo);
		prenda2.put("Verde", verde);
		prenda2.put("Negro", negro);
		prenda2.put("Blanco", blanco);
		this.stock.put("Prenda2", prenda2);
		Map<String, Map<String,String>> prenda3 =  new HashMap<String, Map<String,String>>();
		prenda3.put("Azul", azul);
		prenda3.put("Rojo", rojo);
		prenda3.put("Verde", verde);
		prenda3.put("Negro", negro);
		prenda3.put("Blanco", blanco);
		this.stock.put("Prenda3", prenda3);
		Map<String, Map<String,String>> prenda4 =  new HashMap<String, Map<String,String>>();
		prenda4.put("Azul", azul);
		prenda4.put("Rojo", rojo);
		prenda4.put("Verde", verde);
		prenda4.put("Negro", negro);
		prenda4.put("Blanco", blanco);
		this.stock.put("Prenda4", prenda4);
		Map<String, Map<String,String>> prenda5 =  new HashMap<String, Map<String,String>>();
		prenda5.put("Azul", azul);
		prenda5.put("Rojo", rojo);
		prenda5.put("Verde", verde);
		prenda5.put("Negro", negro);
		prenda5.put("Blanco", blanco);
		this.stock.put("Prenda5", prenda5);
	}

	public Map<String, Map<String, Map<String,String>>> getStock() {
		return stock;
	}

}