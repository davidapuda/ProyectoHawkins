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
        final double LIMITE_RIESGO = 150.0;
        String operadorActual;
        double sensorMedido;
        int codigoRiesgo;
        int porcentajeEstado;
        boolean portalAbierto;
        int opc;
        boolean valido;
<<<<<<< HEAD
        Scanner sc = new Scanner(System.in);   

        System.out.println("Ingresa tu nombre");
        operadorActual = sc.nextLine();

        do {
            mostrarEncabezado(operadorActual);
            opc = sc.nextInt();            

=======
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingresa tu nombre");
        operadorActual = sc.nextLine();
        sc.nextLine();
        
        do {
            mostrarEncabezado(operadorActual);
            opc = sc.nextInt();
            
>>>>>>> 72fc29c4e6c7c0cb12ce956e8799a92e6794cf8d
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
<<<<<<< HEAD

                case 2:
                    simularMuestreoContinuo(sc, LIMITE_RIESGO);
                    break;

                case 0:
                    System.out.println("Cerrando sesion");
                    break;

=======
                case 2:
                    simularMuestreoContinuo(sc, LIMITE_RIESGO);
                    break;
                case 0:
                    System.out.println("Cerrando sesion");
                    break;
>>>>>>> 72fc29c4e6c7c0cb12ce956e8799a92e6794cf8d
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opc != 0);
    }
<<<<<<< HEAD

=======
    
>>>>>>> 72fc29c4e6c7c0cb12ce956e8799a92e6794cf8d
    public static void mostrarEncabezado(String nombre){
        // HACER CON PRINTF // HACER CON PRINTF // HACER CON PRINTF
        System.out.println("Hola, " + nombre + "    SISTEMA HAWKINS");
        System.out.println("1. Inspeccionar Sensor Individual");
        System.out.println("2. Iniciar Muestreo Continuo");
        System.out.println("0. Salir de la Consola");
        System.out.println("Ingrese una opcion:");
    }
<<<<<<< HEAD

    public static double leerLecturaSegura(Scanner sc, String txt){
        boolean valido = false;
        double sensor = 0;
        
=======
    
    public static double leerLecturaSegura(Scanner sc, String txt){
        boolean valido = false;
        double sensor = 0;
>>>>>>> 72fc29c4e6c7c0cb12ce956e8799a92e6794cf8d
        while (!valido){
            try {
                System.out.println(txt);
                sensor = sc.nextDouble();
                valido = true;
            } catch (Exception e) {
<<<<<<< HEAD
                System.out.println("Error"); 
                sc.nextLine(); 
            }
        }

        System.out.println("Lectura completada.");
        return sensor;

    }

    

=======
                System.out.println("Error"); // Completar error
                sc.nextLine(); // Limpiar buffer
            }
        }
        System.out.println("Lectura completada.");
        return sensor;
    }
    
>>>>>>> 72fc29c4e6c7c0cb12ce956e8799a92e6794cf8d
    public static int evaluarNivelRiesgo(double microTeslas, double LIMITE_RIESGO){
        int codigo = 0;
        if (microTeslas < 50) {
            codigo = 1;
<<<<<<< HEAD
        } else if (microTeslas >= 50 && microTeslas <= LIMITE_RIESGO) {
=======
        } else if (microTeslas >= 50 || microTeslas <= LIMITE_RIESGO) {
>>>>>>> 72fc29c4e6c7c0cb12ce956e8799a92e6794cf8d
            codigo = 2;
        } else if (microTeslas > LIMITE_RIESGO) {
            codigo = 3;
        }
        String nivelRiesgo = (microTeslas < 50) ? "Seguro" :  (microTeslas > LIMITE_RIESGO) ? "CRITICO" : "de Alerta";
        System.out.println("El nivel de riesgo es " + nivelRiesgo);
        return codigo;
<<<<<<< HEAD

    }

    

    public static int calcularPorcentajeTruncado(double lectura, double maxEnergia){
        double porcentaje = (lectura / maxEnergia) * 100; // no compruebo maxEnergia porque siempre va a ser > 0
        return (int) porcentaje;

    }

    

=======
    }
    
    public static int calcularPorcentajeTruncado(double lectura, double maxEnergia){
        double porcentaje = (lectura / maxEnergia) * 100; // no compruebo maxEnergia porque siempre va a ser > 0
        return (int) porcentaje;
    }
    
>>>>>>> 72fc29c4e6c7c0cb12ce956e8799a92e6794cf8d
    public static boolean ejecutarProtocoloAccion(int codigo){
        switch (codigo) {
            case 1:
                System.out.println("Modo Estable");
                return false;
<<<<<<< HEAD

            case 2:
                System.out.println("Anomalia Detectada");
                return false;

            case 3:
                System.out.println("¡ALERTA MAXIMA!");
                return true;

            default:
                System.out.println("Codigo no valido");
                return false;

        }

    }

    

    public static void simularMuestreoContinuo(Scanner sc, double LIMITE_RIESGO){
        double lectura;
        double lecturaTotal = 0;
        int contador = 0;
        while(true){
            lectura = leerLecturaSegura(sc, "SIMULACRO      Introduce lectura μT: ");
            if (lectura < 0) {
                break;
            } else if (lectura == 0) {
                continue;
            } else if (lectura > LIMITE_RIESGO) {
                System.out.println("ADVERTENCIA: UMBRAL SUPERADO");
            }

            lecturaTotal = lecturaTotal + lectura;
            contador = contador + 1;
        }

        if (contador > 0) {
            System.out.printf("La media es de %.2f μT%n", (lecturaTotal / contador));

        } else {
            System.out.println("No se han ingresado datos"); 

        }
    }

    

}
=======
            case 2:
                System.out.println("Anomalia Detectada");
                return false;
            case 3:
                System.out.println("¡ALERTA MAXIMA!");
                return true;
            default:
                System.out.println("Codigo no valido");
                return false;
        }
    }
    
    public static void simularMuestreoContinuo(Scanner sc, double LIMITE_RIESGO){
        while(leerLecturaSegura(sc, "SIMULACRO      Introduce lectura μT: ") <= 0){
        }
    }
    
}
>>>>>>> 72fc29c4e6c7c0cb12ce956e8799a92e6794cf8d
