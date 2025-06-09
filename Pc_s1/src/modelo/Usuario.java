package modelo;

public class Usuario {
	private String nombre;
    private int edad;
    private String ciudad;
	
    public Usuario(String nombre, int edad, String ciudad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
    
    
    
    
}
