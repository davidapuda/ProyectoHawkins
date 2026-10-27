package programacion.proyectohawkins;

import java.util.Scanner;

/**
 *
 * @author David Apud Amorin
 */
public class ProyectoHawkins {
    
    public static void main(String[] args) {
        //  DECLARACION DE VARIABLES
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
        
        do {
            mostrarEncabezado(operadorActual);
            opc = sc.nextInt();
            
            switch (opc) {
                case 1:
                    sensorMedido = leerLecturaSegura(sc, "Introduce lectura μT: ");
                    codigoRiesgo = evaluarNivelRiesgo(sensorMedido, LIMITE_RIESGO);
                    porcentajeEstado = calcularPorcentajeTruncado(sensorMedido, MAX_ENERGIA);
                    portalAbierto = ejecutarProtocoloAccion(codigoRiesgo);
                    System.out.println("Porcentaje de capacidad: " + porcentajeEstado);
                    String stringEstadoPortal = (portalAbierto) ? "ABIERTO" : "CERRADO"; // Revisar
                    System.out.println("El portal esta " + stringEstadoPortal);
                    break;
                case 2:
                    simularMuestreoContinuo(sc, LIMITE_RIESGO);
                    break;
                case 0:
                    System.out.println("Cerrando sesion");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opc != 0);
    }
    
    public static void mostrarEncabezado(String nombre){
        // HACER CON PRINTF // HACER CON PRINTF // HACER CON PRINTF
        System.out.println("Hola, " + nombre + "    SISTEMA HAWKINS");
        System.out.println("1. Inspeccionar Sensor Individual");
        System.out.println("2. Iniciar Muestreo Continuo");
        System.out.println("0. Salir de la Consola");
        System.out.println("Ingrese una opcion:");
    }
    
    public static double leerLecturaSegura(Scanner sc, String txt){
        return 0;
    }
    
    public static int evaluarNivelRiesgo(double sensorMedido, int LIMITE_RIESGO){
        return 0;
    }
    
    public static int calcularPorcentajeTruncado(double sensorMedido, double MAX_ENERGIA){
        return 0;
    }
    
    public static boolean ejecutarProtocoloAccion(int codigoRiesgo){
        boolean ejecutar = false;
        return ejecutar;
    }
    
    public static void simularMuestreoContinuo(Scanner sc, int LIMITE_RIESGO){
    
    }
    
}
