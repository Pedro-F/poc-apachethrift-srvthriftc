package apacheThriftSrvC;

import java.util.Map;

import org.apache.thrift.TException;

public class ServicioCThrift implements ThriftServiceStock.Iface{
	
	Map<String, Map<String, Map<String,String>>> stock;

	public ServicioCThrift() {
		stock = StockDao.instance.getStock();
	}
	
	public String recuperaStock(String nombre, String color, String talla) throws TException {
		long iniTime = System.currentTimeMillis();
		
		String respuesta = "0";
		Map<String, Map<String,String>> stockPrenda = stock.get(nombre);
		if(stockPrenda!=null){
			Map<String, String> stockColor = stockPrenda.get(color);
			if(stockColor!=null){
				String cantidad = stockColor.get(talla);
				if(cantidad!=null) respuesta = cantidad;
			}
		}
		System.out.println("FIN ServicioCThrift.  ts = {" + (System.currentTimeMillis() - iniTime) + "}");
		return respuesta;
	}
}
