package controlador;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.ClienteVista;

import java.sql.SQLException;
import java.util.Scanner;
public class EmpleadoControlador {
    private ClienteDAO clienteDAO;
    private ClienteVista clienteVista;

    public EmpleadoControlador(ClienteDAO clienteDAO, ClienteVista clienteVista) {
        this.clienteDAO = clienteDAO;
        this.clienteVista = clienteVista;
    }

}
