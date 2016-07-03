package apacheThriftSrvC;

import java.util.HashMap;
import java.util.Map;

public class RespuestaNoThriftStock {
  
//public String stock; // required
	public Map<String, String> cabecera; // required
	public Map<String, String> cuerpo; // required
	
  public RespuestaNoThriftStock() {
  }

  public RespuestaNoThriftStock(Map<String,String> cabecera, Map<String,String> cuerpo)
  {
    super();
    this.cabecera = cabecera;
    this.cuerpo = cuerpo;
  }
  public RespuestaNoThriftStock(Map<String,String> cabecera, String stock)
  {
    super();
    this.cabecera = cabecera;
    
    Map<String, String> cuerpo = new HashMap<String, String>();
    cuerpo.put("stock", stock);
    
    this.cuerpo = cuerpo;
  }



  public Map<String, String> getCabecera() {
	return cabecera;
}

public void setCabecera(Map<String, String> cabecera) {
	this.cabecera = cabecera;
}

public Map<String, String> getCuerpo() {
	return cuerpo;
}

public void setCuerpo(Map<String, String> cuerpo) {
	this.cuerpo = cuerpo;
}

@Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RespuestaThrift(");
    sb.append("stock:");
    sb.append(cuerpo.get("stock"));
    sb.append(")");
    return sb.toString();
  }
}

