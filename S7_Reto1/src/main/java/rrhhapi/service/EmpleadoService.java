package rrhhapi.service;

import rrhhapi.model.Empleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que maneja la lógica de negocio de empleados.
 */
@Service
public class EmpleadoService {

    private final List<Empleado> empleados = new ArrayList<>();

    public EmpleadoService() {
        empleados.add(new Empleado(1L, "Ana Gómez", "Gerente de Marketing", 55000));
        empleados.add(new Empleado(2L, "Carlos Pérez", "Desarrollador Backend", 45000));
    }

    public List<Empleado> obtenerTodos() {
        return empleados;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Empleado> buscarPorPuesto(String puesto) {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e.getPuesto().equalsIgnoreCase(puesto)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public boolean eliminarEmpleado(Long id) {
        return empleados.removeIf(e -> e.getId().equals(id));
    }
}
