import java.util.Scanner;

/**
 * Clase que simula el cálculo de plazos y rendimientos financieros de una inversión
 * a partir de un monto inicial, una tasa de interés anual y un rango de fechas.
 *
 * @author Aarón Palafox Solís
 * @version 1.0
 */
public class TiempoDeInversion{
    private String nombre;
    private float monto;
    private String fechaInicio;
    private int dia, mes, anio;
    private float rendimientoPesos;
    private float valorFinal;

    Scanner scanner = new Scanner(System.in);

    /**
     * Lee desde la consola y asigna el nombre del inversionista.
     */
    public void setNombre(){
        nombre = scanner.nextLine();
    }

    /**
     * Lee desde la consola y valida el monto a invertir, exigiendo que sea mayor o igual a 0.
     */
    public void setMonto(){
        monto = scanner.nextFloat();
       while (monto < 0){
        System.out.println("Error. Ingrese un número mayor que 0.");
        monto = scanner.nextFloat();
       }
       scanner.nextLine();
    }

    /**
     * Solicita y valida por consola el año, mes y día de inicio de la inversión,
     * considerando años bisiestos y la duración de cada mes.
     */
    public void setFechaInicial(){
        do { 
            System.out.println("Ingrese el año");
            anio = scanner.nextInt();
            if (anio < 1582){
                System.out.println("Error ingrese un valor válido.");
            }
        } while (anio < 1582);

        do{
        System.out.println("Ingrese el mes");
        mes = scanner.nextInt();
        if (mes > 12 || mes < 1){
            System.out.println("Error ingrese un valor válido.");
        }
        }while(mes > 12 || mes < 1);

        System.out.println("Ingrese el día");
        dia = scanner.nextInt();
        if (mes == 2 && anioBisiesto()){
            while (dia > 29 || dia < 1){
                System.out.println("Error ingrese un valor válido.");
                dia = scanner.nextInt();
            }
        }else if (mes == 2 && !anioBisiesto()){
            while(dia > 28 || dia < 1){
                System.out.println("Error ingrese un valor válido.");
                dia = scanner.nextInt();
            }
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
            while(dia > 30 || dia < 1){
                System.out.println("Error ingrese un valor válido.");
                dia = scanner.nextInt();
            }
        }else{
            while (dia > 31 || dia < 1){
                System.out.println("Error ingrese un valor válido.");
                dia = scanner.nextInt();  
            }
        }

    }

    /**
     * Solicita y valida por consola la fecha de término de la inversión,
     * verificando que el año no sea anterior al de la fecha inicial.
     *
     * @param fechaInicial Objeto {@code TiempoDeInversion} que contiene la fecha de inicio.
     */
     public void setFechaFinal(TiempoDeInversion fechaInicial){
        do { 
            System.out.println("Ingrese el año");
            anio = scanner.nextInt();
            if (anio < 1582 || anio < fechaInicial.getAnio()){
                System.out.println("Error ingrese un valor válido.");
            }
        } while (anio < 1582 || anio < fechaInicial.getAnio());

        do{
        System.out.println("Ingrese el mes");
        mes = scanner.nextInt();
        if (mes > 12 || mes < 1){
            System.out.println("Error ingrese un valor válido.");
        }
        }while(mes > 12 || mes < 1);

        System.out.println("Ingrese el día");
        dia = scanner.nextInt();
        if (mes == 2 && anioBisiesto()){
            while (dia > 29 || dia < 1){
                System.out.println("Error ingrese un valor válido.");
                dia = scanner.nextInt();
            }
        }else if (mes == 2 && !anioBisiesto()){
            while(dia > 28 || dia < 1){
                System.out.println("Error ingrese un valor válido.");
                dia = scanner.nextInt();
            }
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
            while(dia > 30 || dia < 1){
                System.out.println("Error ingrese un valor válido.");
                dia = scanner.nextInt();
            }
        }else{
            while (dia > 31 || dia < 1){
                System.out.println("Error ingrese un valor válido.");
                dia = scanner.nextInt();  
            }
        }

    }

    /**
     * Obtiene el nombre del usuario inversionista.
     *
     * @return El nombre registrado.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene el monto de capital invertido.
     *
     * @return El monto en pesos.
     */
    public float getMonto(){
        return monto;
    }

    /**
     * Obtiene el día almacenado en el objeto.
     *
     * @return El día del mes.
     */
    public int getDia(){
        return dia;
    }

    /**
     * Obtiene el mes almacenado en el objeto.
     *
     * @return El número de mes (1-12).
     */
    public int getMes(){
        return mes;
    }

    /**
     * Obtiene el año almacenado en el objeto.
     *
     * @return El año.
     */
    public int getAnio(){
        return anio;
    }

    /**
     * Imprime un mensaje de bienvenida personalizado y solicita el monto a invertir.
     *
     * @param nombre El nombre del usuario a saludar.
     */
    public void saludar(String nombre){
        System.out.println("Hola señor/a " + nombre + " ¿Cuánto desea invertir?");
    }

    /**
     * Determina si un año específico es bisiesto.
     *
     * @param a El año a evaluar.
     * @return {@code true} si el año es bisiesto; {@code false} en caso contrario.
     */
    public boolean anioBisiesto(int a){
        return (a%4 == 0 && a%100 != 0) || (a%400 == 0);
    }

    /**
     * Determina si el año de la instancia actual es bisiesto.
     *
     * @return {@code true} si el año del objeto es bisiesto; {@code false} en caso contrario.
     */
    public boolean anioBisiesto(){
        return anioBisiesto(getAnio());
    }

    /**
     * Calcula la cantidad de días que tiene un mes dado en un año específico.
     *
     * @param m El número de mes (1-12).
     * @param a El año correspondiente.
     * @return El total de días del mes (28, 29, 30 o 31).
     */
    public int diasDelMes(int m, int a) {
        if (m == 4 || m == 6 || m == 9 || m == 11) {
                return 30;
        } else if (m == 2) {
                if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)) {
	        return 29;
	        } else {
		return 28;
                }
	} else {
                return 31;
	}
	}

	/**
	 * Obtiene la cantidad de días del mes y año almacenados en la instancia actual.
	 *
	 * @return El total de días del mes actual.
	 */
	public int mesDias() {
	return diasDelMes(getMes(), getAnio());
	}

    /**
     * Calcula el número total de días de duración entre una fecha inicial y una fecha final.
     *
     * @param fechaInicial Objeto con la fecha de inicio de la inversión.
     * @param fechaFinal   Objeto con la fecha de término de la inversión.
     * @return La cantidad de días transcurridos entre ambas fechas.
     */
    public int diasInversion(TiempoDeInversion fechaInicial,TiempoDeInversion fechaFinal){
        int dia1 = fechaInicial.getDia(), mes1 = fechaInicial.getMes(), anio1 = fechaInicial.getAnio();
        int dia2 = fechaFinal.getDia(), mes2 = fechaFinal.getMes(), anio2 = fechaFinal.getAnio();
        if (mes1 > mes2 || (mes1 == mes2 && dia1 > dia2)){
            int D = dia1, M = mes;
            dia1 = dia2; mes1 = mes2;
            dia2 = D ; mes2 = M;
        }
        int diasInversion = 0;
        while (anio1 < anio2 || mes1 < mes2 || dia1 < dia2){
            dia1++;
            diasInversion++;
            if (dia1 > diasDelMes(mes1, anio1)){
                dia1 = 1;
                mes1++;
            }
            if (mes1 > 12){
                mes1 = 1;
                anio1++;
            }
        }
        return diasInversion;
    }

    /**
     * Calcula el valor final de la inversión aplicando interés simple con base anual de 365 días.
     *
     * @param m El monto inicial invertido.
     * @param t La tasa de interés anual en porcentaje.
     * @param d El plazo de la inversión en días.
     * @return El monto final (capital inicial más los rendimientos generados).
     */
    public float rendimientoInversion(float m, float t, int d){
        rendimientoPesos = m*(t/100.0f)*(d/365.0f);
        valorFinal = m + rendimientoPesos;
        return valorFinal;
    }
    
    /**
     * Calcula el valor final de la inversión utilizando el monto de la instancia actual,
     * una tasa anual fija del 12% y el plazo en días entre dos fechas.
     *
     * @param fechaInicial Objeto con la fecha de inicio de la inversión.
     * @param fechaFinal   Objeto con la fecha de término de la inversión.
     * @return El monto final acumulado al término del plazo.
     */
    public float rendimientoInversion(TiempoDeInversion fechaInicial, TiempoDeInversion fechaFinal){
        int dias = diasInversion(fechaInicial, fechaFinal);
        rendimientoInversion(getMonto(), 12.0f, dias);
        return valorFinal;
    }

    /**
     * Método principal que ejecuta el simulador interactivo de inversiones en consola,
     * permitiendo realizar múltiples simulaciones consecutivas.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        String respuesta;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido, ingrese su nombre.");
        TiempoDeInversion usuario = new TiempoDeInversion();
        usuario.setNombre();
        do { 
        TiempoDeInversion maquina = new TiempoDeInversion();
        maquina.saludar(usuario.getNombre());
        usuario.setMonto();
        TiempoDeInversion fechaInicial = new TiempoDeInversion();
        System.out.println("¿Desde cuándo le gustaría empezar su inversión?");
        fechaInicial.setFechaInicial();
        TiempoDeInversion fechaFinal = new TiempoDeInversion();
        System.out.println("¿Cuándo le gustaría terminar su inversión?");
        fechaFinal.setFechaFinal(fechaInicial);
        System.out.println("Los días de su inversión serán: " + maquina.diasInversion(fechaInicial, fechaFinal) + " y su rendimiento será de: " + usuario.rendimientoInversion(fechaInicial, fechaFinal));
        System.out.println("¿Desea hacer otra simulación?");
        respuesta = scanner.nextLine().toLowerCase().trim();
        while ( !respuesta.equals("no") && !respuesta.equals("si") && !respuesta.equals("sí")){
            System.out.println("Responda sí o no");
            respuesta = scanner.nextLine();
        } 
        } while (respuesta.equals("si") || respuesta.equals("sí"));
    }
}
