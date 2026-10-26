package programacion.proyectohawkins;

import java.util.Scanner;

/**
 *
 * @author dav
 */
public class ProyectoHawkins {
    
    public static void main(String[] args) {
        final double MAX_ENERGIA = 200.0;
        final int LIMITE_RIESGO = 150;
        String operadorActual;
        double sensorMedido;
        int codigoRiesgo;
        int porcentajeEstado;
        boolean portalAbierto;
        int opc;
        boolean valido;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu nombre");
        operadorActual = sc.nextLine();
        sc.nextLine();
        mostrarEncabezado(operadorActual);
        do {
            System.out.println("Hola, " + operadorActual + "    SISTEMA HAWKINS");
            System.out.println("1. Inspeccionar Sensor Individual");
            System.out.println("2. Iniciar Muestreo Continuo");
            System.out.println("0. Salir de la Consola");
            System.out.println("Ingrese una opcion:");
            opc = 1;
            do {
                valido = false;
                try {
                    opc = sc.nextInt();
                    sc.nextLine();
                    valido = true;
                } catch (Exception e){
                }
            } while (!valido);
        } while (opc != 0);
    }
    
    public static void mostrarEncabezado(String nombre){
    
    }
}
