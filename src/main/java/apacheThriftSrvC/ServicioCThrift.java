package apacheThriftSrvC;

import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;



public class ServicioCThrift implements ThriftService.Iface {

	public static ServicioCThrift servicioC;

	public static ThriftServiceStock.Processor processor;

	public static void main(String[] args) {
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
	}

	public static void simple(ThriftServiceStock.Processor processor) {
		try {

			/*TServerTransport serverTransport = new TServerSocket(9092);
			//TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
			
			TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(serverTransport);
			serverArgs.processor(processor);
			TServer server =  new TThreadPoolServer(serverArgs);*/
			TServerTransport serverTransport = new TServerSocket(9093);
			TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport)
			            .processor(processor).protocolFactory(new TJSONProtocol.Factory())
			            .inputTransportFactory(new TFramedTransport.Factory())
			            .outputTransportFactory(new TFramedTransport.Factory()));
			System.out.println("Arrancando servidor...");
			server.serve();
			
			
			/**TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(9092);
			TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport)
					.processor(processor).transportFactory(new TFramedTransport.Factory(256 * 1024 * 1024))
                    .protocolFactory(new TBinaryProtocol.Factory()));
			
			server.serve();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
