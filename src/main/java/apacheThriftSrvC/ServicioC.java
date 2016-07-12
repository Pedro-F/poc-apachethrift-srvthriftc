package apacheThriftSrvC;

import java.util.Map;

import javax.servlet.Servlet;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServlet;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



@EnableAutoConfiguration
@ComponentScan
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
    public Servlet servicioC(TProtocolFactory protocolFactory, ServicioCThrift handler) {
        return new TServlet(new ThriftServiceStock.Processor<ServicioCThrift>(handler), protocolFactory);
    }

	
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
			processor = new ThriftServiceStock.Processor(servicioC);
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
	
	public static void simple(ThriftServiceStock.Processor processor) {
		try {

			/*TServerTransport serverTransport = new TServerSocket(9092);
			//TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
			
			TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(serverTransport);
			serverArgs.processor(processor);
			TServer server =  new TThreadPoolServer(serverArgs);*/
			System.out.println("Arrancando servidor...");
			TServerTransport serverTransport = new TServerSocket(9095);
			System.out.println("soket creado servidor...");
			TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport)
			            .processor(processor).protocolFactory(new TJSONProtocol.Factory())
			            .inputTransportFactory(new TFramedTransport.Factory())
			            .outputTransportFactory(new TFramedTransport.Factory()));
			System.out.println("socketServer creado servidor...");
			server.serve();
			System.out.println("soket esperando peticiones");

			
			
			/**TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(9092);
			TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport)
					.processor(processor).transportFactory(new TFramedTransport.Factory(256 * 1024 * 1024))
                    .protocolFactory(new TBinaryProtocol.Factory()));
			
			server.serve();*/
		} catch (Exception e) {
			System.out.println("Error Arrancando servidor...");
			e.printStackTrace();
		}
	}
}
