package vista;
import modelo.Empleado;

import java.util.List;
import java.util.Scanner;

public class EmpleadoVista {
    private Scanner scanner;
    public EmpleadoVista (){
        this.scanner = new Scanner(System.in);
    }
    public void mostrarEmpleados(List<Empleado>empleados){
        System.out.println("Lista de empleados:");
        if (empleados.isEmpty()){
            System.out.println("No hay empleados registrados");
        } else {
            System.out.printf("%-5s %-25s %-15s %-10s %-10s %-10s %-5s\n", "ID", "NOMBRE", "APELLIDO", "PUESTO", "TELEFONO", "EMAIL", "FECHA_CONTRATACION");
            for (Empleado empleado : empleados){
                System.out.printf("%-5d %-25s %-15s %-10d %-10s %-10.2f %-5d\n", empleado.getEmpleadoID(), empleado.getNombre(), empleado.getApellido(), empleado.getPuesto(), empleado.getTelefono(), empleado.getEmail(), empleado.getFechaContratacion());
            }
        }
    }
}
