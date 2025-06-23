package rrhhapi.controller;

import rrhhapi.model.Empleado;
import rrhhapi.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar solicitudes relacionadas con empleados.
 */
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    // ✅ GET: Listar todos los empleados
    @GetMapping
    public List<Empleado> obtenerEmpleados() {
        return empleadoService.obtenerTodos();
    }

    // ➕ POST: Agregar nuevo empleado
    @PostMapping
    public void agregarEmpleado(@RequestBody Empleado empleado) {
        empleadoService.agregarEmpleado(empleado);
    }

    // 🔍 GET: Buscar por puesto
    @GetMapping("/puesto/{puesto}")
    public List<Empleado> buscarPorPuesto(@PathVariable String puesto) {
        return empleadoService.buscarPorPuesto(puesto);
    }

    // 🗑️ DELETE: Eliminar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable Long id) {
        boolean eliminado = empleadoService.eliminarEmpleado(id);
        if (eliminado) {
            return ResponseEntity.ok("✅ Empleado con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("❌ Empleado con ID " + id + " no existe.");
        }
    }
}
