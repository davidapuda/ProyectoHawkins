package programacion.proyectohawkins;

import java.util.Scanner;

/**
 * <h1>Proyecto Hawkins</h1>
 * Aplicación de consola en Java orientada a la simulación y monitorización 
 * de niveles de energía electromagnética (medida en microTeslas, μT).
 * Permite realizar inspecciones individuales de sensores y muestreos continuos
 * para evaluar riesgos y activar protocolos de seguridad.
 *
 * @author David Apud Amorin
 * @version 1.0
 */
public class ProyectoHawkins {

    /**
     * Método principal que controla el flujo de ejecución de la aplicación.
     * Muestra un menú interactivo mediante un bucle do-while y gestiona 
     * las opciones seleccionadas por el operador.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        
        //  DECLARACION DE VARIABLES
        // ================================
        final double MAX_ENERGIA = 200.0;
        final double LIMITE_RIESGO = 150.0;
        String operadorActual;
        double sensorMedido;
        int codigoRiesgo;
        int porcentajeEstado;
        boolean portalAbierto;
        int opc;
        Scanner sc = new Scanner(System.in);
        // ================================
        System.out.println("Ingresa tu nombre");
        operadorActual = sc.nextLine();
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
                    String stringEstadoPortal = (portalAbierto) ? "ABIERTO" : "CERRADO";
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

    /**
     * Muestra por pantalla el encabezado principal de la consola con un saludo
     * personalizado al operador y las opciones disponibles del menú.
     *
     * @param nombre Nombre del operador actual que sessiona en el sistema.
     */
    public static void mostrarEncabezado(String nombre){
        System.out.printf("Hola, %-12s %35s%n" +
                          "-------------------------------------------------------------------%n" +
                          "1. Inspeccionar Sensor Individual%n" +
                          "2. Iniciar Muestreo Continuo%n" +
                          "0. Salir de la Consola%n" +
                          "Ingrese una opcion:%n", nombre, "S I S T E M A   H A W K I N S");
    }

    /**
     * Lee un valor de tipo double introducido por consola de forma segura,
     * controlando excepciones en caso de que el usuario introduzca datos no numéricos.
     *
     * @param sc Objeto Scanner para la lectura de datos por consola.
     * @param txt Texto o mensaje que se mostrará al usuario antes de pedir el valor.
     * @return El valor numérico de tipo double introducido de forma válida.
     */
    public static double leerLecturaSegura(Scanner sc, String txt){
        boolean valido = false;
        double sensor = 0;
        while (!valido){
            try {
                System.out.println(txt);
                sensor = sc.nextDouble();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error"); 
                sc.nextLine(); 
            }
        }
        System.out.println("Lectura completada.");
        return sensor;
    }

    /**
     * Evalúa el nivel de riesgo en base al valor de la lectura en microTeslas
     * y al límite de riesgo establecido.
     *
     * @param microTeslas Valor numérico de la lectura del sensor en μT.
     * @param LIMITE_RIESGO Valor límite permitido antes de considerarse crítico.
     * @return Un código entero que representa el nivel de riesgo (1: Seguro, 2: Alerta, 3: Crítico).
     */
    public static int evaluarNivelRiesgo(double microTeslas, double LIMITE_RIESGO){
        int codigo = 0;
        if (microTeslas < 50) {
            codigo = 1;
        } else if (microTeslas >= 50 && microTeslas <= LIMITE_RIESGO) {
            codigo = 2;
        } else if (microTeslas > LIMITE_RIESGO) {
            codigo = 3;
        }
        String nivelRiesgo = (microTeslas < 50) ? "Seguro" :  (microTeslas > LIMITE_RIESGO) ? "CRITICO" : "de Alerta";
        System.out.println("El nivel de riesgo es " + nivelRiesgo);
        return codigo;

    }

    /**
     * Calcula el porcentaje entero truncado que representa la lectura actual 
     * respecto a la energía máxima permitida del sistema.
     *
     * @param lectura Valor actual medido por el sensor.
     * @param maxEnergia Valor máximo de energía soportado.
     * @return El porcentaje en formato entero (truncado).
     */
    public static int calcularPorcentajeTruncado(double lectura, double maxEnergia){
        double porcentaje = (lectura / maxEnergia) * 100; // no compruebo maxEnergia porque siempre va a ser > 0
        return (int) porcentaje;
    }

    /**
     * Ejecuta el protocolo de acción correspondiente según el código de riesgo recibido.
     *
     * @param codigo Código numérico indicador del nivel de riesgo.
     * @return true si se activa la alerta máxima (portal abierto), false en caso contrario.
     */
    public static boolean ejecutarProtocoloAccion(int codigo){
        switch (codigo) {
            case 1:
                System.out.println("Modo Estable");
                return false;
                
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

    /**
     * Realiza un muestreo continuo de lecturas en un bucle interactivo de simulacro.
     * Permite introducir múltiples valores hasta recibir un número negativo para finalizar,
     * ignorando los ceros y advirtiendo si se supera el límite de riesgo. 
     * Al finalizar, muestra la media de las lecturas válidas ingresadas.
     *
     * @param sc Objeto Scanner para la lectura de datos por consola.
     * @param LIMITE_RIESGO Valor límite permitido para emitir advertencias de umbral superado.
     */
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