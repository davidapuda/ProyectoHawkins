# Proyecto Hawkins - Upside Down Monitorización (UD2)

Aplicación desarrollada en Java SE para la monitorización de niveles de energía electromagnética (medida en microTeslas, $\mu T$) en el Laboratorio Nacional de Hawkins (1983). Este proyecto forma parte de la práctica evaluable de la Unidad Didáctica 2 del módulo de Programación (1º DAM).

## 📋 Descripción del Proyecto

El software se estructura en una única clase principal (`ProyectoHawkins.java`) que orquesta un menú interactivo mediante consola. Permite a los operadores realizar inspecciones individuales de sensores, calcular riesgos en función de umbrales críticos, y simular muestreos continuos con control de errores robusto.

---

## ⚙️ Estructura y Variables del Sistema

El método `main` gestiona las siguientes constantes y variables clave:
* `MAX_ENERGIA` (`final double`): Capacidad máxima de energía soportada por el sensor (valor de referencia: `200.0` $\mu T$).
* `LIMITE_RIESGO` (`final double`): Umbral crítico permitido antes de la brecha (valor de referencia: `150.0` $\mu T$).
* `operadorActual` (`String`): Identificador o nombre del usuario operario.
* `sensorMedido` (`double`): Almacena la última lectura decimal en $\mu T$.
* `codigoRiesgo` (`int`): Código numérico entero devuelto tras evaluar la lectura.
* `porcentajeEstado` (`int`): Porcentaje entero truncado respecto a la capacidad máxima.
* `portalAbierto` (`boolean`): Estado lógico de la brecha dimensional (`true` si está abierto, `false` si está cerrado).
* `opcionMenu` (`int`): Opción numérica seleccionada en el menú interactivo.

---

## 🛠️ Métodos Implementados

1. **`mostrarEncabezado(String nombre)`**: Muestra la cabecera del sistema mediante salida formateada (`System.out.printf`).
2. **`leerLecturaSegura(Scanner sc, String txt)`**: Lee un valor decimal controlando excepciones (`try-catch`) ante entradas no válidas y limpiando el búfer.
3. **`evaluarNivelRiesgo(double microTeslas, double LIMITE_RIESGO)`**: Devuelve un código de riesgo (`1` para $<50.0$, `2` entre $50.0$ y $150.0$, y `3` para $>150.0$) e incluye una etiqueta interna generada con el operador ternario (`?:`).
4. **`calcularPorcentajeTruncado(double lectura, double maxEnergia)`**: Calcula el porcentaje y aplica un *casting* explícito a `(int)` para truncar los decimales.
5. **`ejercutarProtocoloAccion(int codigo)`**: Ejecuta un `switch` para determinar la acción y el estado del portal según el riesgo.
6. **`simularMuestreoContinuo(Scanner sc, double LIMITE_RIESGO)`**: Mantiene un bucle interactivo de lectura continua (`break` para negativo, `continue` para cero) y calcula la media aritmética a dos decimales al finalizar.

---

## 🚀 Guía de Uso

1. Clona el repositorio en tu equipo local.
2. Abre el proyecto en tu entorno de desarrollo IDE (NetBeans, IntelliJ, Eclipse, etc.).
3. Ejecuta la clase `ProyectoHawkins.java`.
4. Introduce tu nombre de operario y selecciona una opción del menú:
   - **`1`**: Inspección individual de sensor.
   - **`2`**: Muestreo continuo (simulacro).
   - **`0`**: Salir de la consola.

---

## 📦 Control de Versiones (Git & GitHub)

El proyecto incluye un flujo de trabajo basado en Git con commits periódicos orientados a funcionalidades (`feat: ...`) y un archivo `.gitignore` adecuado para entornos Java.

* **Autor:** David Apud Amorín
* **Módulo:** Programación - 1º DAM