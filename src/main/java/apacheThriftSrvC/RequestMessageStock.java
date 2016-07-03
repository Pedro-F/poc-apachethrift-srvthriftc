package apacheThriftSrvC;

import java.util.Map;

public class RequestMessageStock {

	public Map<String, String> cabecera; // required
	public Map<String, String> cuerpo; // required
	
	public RequestMessageStock(){
		super();
	}

	public RequestMessageStock(Map<String,String> cabecera, Map<String,String> cuerpo){
		    super();
		    this.cabecera = cabecera;
		    this.cuerpo = cuerpo;
	}

	public Map<String,String> getCabecera() {
	    return this.cabecera;
	}
	
	public Map<String,String> getCuerpo() {
	    return this.cuerpo;
	}

	@Override
	public String toString() {
		return "[nombre=" + cuerpo.get("nombre") + ", color=" + cuerpo.get("color") + ", talla=" + cuerpo.get("talla") + "]";
	}

}
