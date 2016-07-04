package apacheThriftSrvC;

public class RequestMessageStock{

	private String nombre;
	private String color;
	private String talla;

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}
	
	public void setTalla(String talla) {
		this.talla = talla;
	}

	@Override
	public String toString(){
		return "[nombre=" + nombre + ", color=" + color + ", talla=" + talla+ "]";
	}
	
}