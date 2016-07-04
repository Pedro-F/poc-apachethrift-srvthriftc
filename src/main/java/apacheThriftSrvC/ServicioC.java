package apacheThriftSrvC;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import apacheThriftSrvB.ServicioBThrift;
import apacheThriftSrvB.ThriftService;
import apacheThriftSrvC.ServicioCThrift;
import apacheThriftSrvC.ThriftServiceStock;

@RestController
@EnableAutoConfiguration
public class ServicioC {

	Map<String, Map<String, Map<String,String>>> stock;

	public static ServicioCThrift servicioC;

	public static ThriftServiceStock.Processor processor;

	public ServicioC() {
		stock = StockDao.instance.getStock();
	}
	
	

    @Bean
    public TProtocolFactory tProtocolFactory() {
        //We will use binary protocol, but it's possible to use JSON and few others as well
        return new TCompactProtocol.Factory();
//        return new TJSONProtocol.Factory();
    }
    
    @Bean
    public Servlet servicioB(TProtocolFactory protocolFactory, ServicioCThrift handler) {
        return new TServlet(new ThriftServiceStock.Processor<ServicioCThrift>(handler), protocolFactory);
    }

	
	
//	@RequestMapping(value = "/servicioC", method = RequestMethod.POST)
//	public @ResponseBody RespuestaNoThriftStock servicioC(@RequestBody RequestMessageStock requestMessageStock) {
//		
//		// Variables
//		long iniTime = System.currentTimeMillis();
//		RespuestaNoThriftStock respuestaNoThriftStock = new RespuestaNoThriftStock();
//		respuestaNoThriftStock.setStock("0");
//
//		// Obtenemos el mapa de prendas filtrado por el nombre y color solicitados para retornar el stock
//		Map<String, Map<String,String>> stockPrenda = stock.get(requestMessageStock.getNombre());
//		if(stockPrenda!=null){
//			Map<String, String> stockColor = stockPrenda.get(requestMessageStock.getColor());
//			if(stockColor!=null){
//				String cantidad = stockColor.get(requestMessageStock.getTalla());
//				if(cantidad!=null){
//					respuestaNoThriftStock.setStock(cantidad);
//				}
//			}
//		}
//		
//		// Traza de fin del servicio
//		System.out.println("FIN ServicioC.  ts = {" + (System.currentTimeMillis() - iniTime) + "}");
//		
//		return respuestaNoThriftStock;
//	}
	
	/*******************************************
	 * MAIN *
	 * 
	 * @param args
	 *            *
	 * @throws Exception
	 *             *
	 ******************************************/
	public static void main(String[] args) throws Exception {
		
		try {
			servicioC = new ServicioCThrift();
			processor = new ThriftService.Processor(servicioC);
			Runnable simple = new Runnable() {
				public void run() {
					simple(processor);
				}
			};
			new Thread(simple).start();
		} catch (Exception x) {
			x.printStackTrace();
		}
		
		SpringApplication.run(ServicioC.class, args);
	}
}
