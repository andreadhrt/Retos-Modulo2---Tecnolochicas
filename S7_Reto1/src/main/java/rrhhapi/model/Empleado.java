package rrhhapi.model;

/**
 * Modelo de datos para representar un empleado.
 */
public class Empleado {
    private Long id;
    private String nombre;
    private String puesto;
    private double salario;

    public Empleado(Long id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    // Getters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public void setSalario(double salario) { this.salario = salario; }
}
