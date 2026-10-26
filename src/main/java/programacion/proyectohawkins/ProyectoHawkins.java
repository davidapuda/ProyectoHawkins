package programacion.proyectohawkins;

import java.util.Scanner;

/**
 *
 * @author dav
 */
public class ProyectoHawkins {
    
    public static void main(String[] args) {
        final double MAX_ENERGIA = 100.0;
        final int LIMITE_RIESGO = 150;
        String operadorActual;
        double sensorMedido;
        int codigoRiesgo;
        int porcentajeEstado;
        boolean portalAbierto;
        String opc;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu nombre");
        operadorActual = sc.nextLine();
        mostrarEncabezado(operadorActual);
    }
}
