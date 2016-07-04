package apacheThriftSrvC;

public class RespuestaNoThriftStock {
  
  public String stock; // required

  public RespuestaNoThriftStock() {
  }

  public RespuestaNoThriftStock(String stock)
  {
    this();
    this.stock = stock;
  }

  public String getStock() {
    return this.stock;
  }

  public RespuestaNoThriftStock setStock(String stock) {
    this.stock = stock;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RespuestaThrift(");
    sb.append("stock:");
    sb.append(this.stock);
    sb.append(")");
    return sb.toString();
  }
}
