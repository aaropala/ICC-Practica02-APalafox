import java.util.Scanner;

/**
 * Clase que representa una fecha del calendario gregoriano (a partir de 1582)
 * y proporciona métodos para su manipulación, validación, comparación y cálculo
 * de diferencias o días transcurridos.
 *
 * @author Aarón Palafox Solís
 * @version 1.0
 */
public class Fecha{
	private String fechaIni;
	private int dia;
	private int mes;
	private int anio;
	private String mesPalabra;
	private String fechaFinal;

	Scanner scanner = new Scanner(System.in);

	/**
	 * Inicializa los atributos de la fecha con valores por defecto (1/1/2026).
	 */
	public void fechaInicial(){
		dia = 1;
		mes = 1;
		anio = 2026;
	}

	/**
	 * Inicializa los atributos de la fecha utilizando valores numéricos específicos.
	 *
	 * @param d El día del mes.
	 * @param m El mes en formato numérico (1-12).
	 * @param a El año.
	 */
	public void fechaInicial(int d, int m, int a){
		dia = d;
		mes = m;
		anio = a;
	}

	/**
	 * Inicializa los atributos de la fecha recibiendo el mes como cadena de texto.
	 *
	 * @param d  El día del mes.
	 * @param mp El nombre del mes en español.
	 * @param a  El año.
	 */
	public void fechaInicial(int d, String mp, int a){
		dia = d;
		mesPalabra = mp;
		anio = a;
	}

	/**
	 * Solicita y valida el día por consola considerando la duración del mes
	 * previamente asignado (30 o 31 días).
	 */
	public void setDia(){
		System.out.println("Ingrese un valor para día.");
		dia = scanner.nextInt();
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
			while (dia < 1 || dia > 30){
				System.out.println("Error ingrese un valor válido para día");
				dia = scanner.nextInt();
			}
		}
		while (dia > 31 || dia < 1) {
			System.out.println("Error ingrese un valor válido para día");
			dia = scanner.nextInt();
		}

		scanner.nextLine();
	}

	/**
	 * Solicita y valida el número de mes por consola dentro del rango de 1 a 12.
	 */
	public void setMes(){
		do{
		System.out.println("Ingrese un valor para mes.");
		mes = scanner.nextInt();
		if (mes > 12 || mes < 1) {
			System.out.println("Error ingrese un valor válido para mes.");
		}
		}while (mes > 12 || mes < 1);

		scanner.nextLine();
	}

	/**
	 * Solicita y valida el nombre del mes en español por consola,
	 * convirtiendo la entrada a minúsculas.
	 */
	public void setMesPalabra(){
		do{
		System.out.println("Ingrese un valor para mes.");
		mesPalabra = scanner.nextLine();
		mesPalabra = mesPalabra.toLowerCase();
		if (!mesPalabra.equals("enero") && !mesPalabra.equals("febrero") && !mesPalabra.equals("marzo") && !mesPalabra.equals("abril") && !mesPalabra.equals("mayo") && !mesPalabra.equals("junio") && !mesPalabra.equals("julio") && !mesPalabra.equals("agosto") && !mesPalabra.equals("septiembre") && !mesPalabra.equals("octubre") && !mesPalabra.equals("noviembre") && !mesPalabra.equals("diciembre")){
			System.out.println("Error ingrese un valor válido para mes.");
		}
		}while (!mesPalabra.equals("enero") && !mesPalabra.equals("febrero") && !mesPalabra.equals("marzo") && !mesPalabra.equals("abril") && !mesPalabra.equals("mayo") && !mesPalabra.equals("junio") && !mesPalabra.equals("julio") && !mesPalabra.equals("agosto") && !mesPalabra.equals("septiembre") && !mesPalabra.equals("octubre") && !mesPalabra.equals("noviembre") && !mesPalabra.equals("diciembre"));
	}

	/**
	 * Solicita y valida el año por consola exigiendo que sea mayor o igual a 1582.
	 */
	public void setAnio(){
		do{
		System.out.println("Ingrese un valor para año. Desde 1582.");
		anio = scanner.nextInt();
		if (anio < 1582){
			System.out.println("Ingrese un valor válido para año");
			anio = scanner.nextInt();
		}
		}while (anio < 1582);
	}

	/**
	 * Obtiene el día almacenado en la fecha.
	 *
	 * @return El día del mes.
	 */
	public int getDia(){
		return dia;
	}

	/**
	 * Obtiene el mes numérico almacenado en la fecha.
	 *
	 * @return El número de mes (1-12).
	 */
	public int getMes(){
		return mes;
	}

	/**
	 * Obtiene el nombre del mes almacenado en formato texto.
	 *
	 * @return El nombre del mes.
	 */
	public String getMesPalabra(){
		return mesPalabra;
	}

	/**
	 * Obtiene el año almacenado en la fecha.
	 *
	 * @return El año.
	 */
	public int getAnio(){
		return anio;
	}

	/**
	 * Verifica si el día actual es válido para el mes de febrero
	 * considerando si el año es bisiesto.
	 *
	 * @return El día evaluado.
	 */
	public int mesFebreroParam(){
		if (anioBiciesto() && dia > 29){
			System.out.println("Error ingrese un valor válido para día");
		}
		if (dia > 28){
			System.out.println("Error ingrese un valor válido para día");
		}
		return dia;
	}

	/**
	 * Solicita y valida por consola un día correspondiente al mes de febrero
	 * (hasta 29 en año bisiesto, o hasta 28 en año común).
	 *
	 * @return El día válido asignado para febrero.
	 */
	public int mesFebrero(){
		
		System.out.println("Ingrese un valor para día.");
		dia = scanner.nextInt();
		if (anioBiciesto()){
			while(dia > 29){
				System.out.println("Error ingrese un valor válido para día");
				dia = scanner.nextInt();
			}
		}else{
			while (dia > 28){
			System.out.println("Error ingrese un valor válido para día");
			dia = scanner.nextInt();
		}
		}
		return dia;
	}

	/**
	 * Determina si un año específico es bisiesto según las reglas del calendario gregoriano.
	 *
	 * @param a El año a evaluar.
	 * @return {@code true} si el año es bisiesto; {@code false} en caso contrario.
	 */
	public boolean anioBiciesto(int a) {
    	return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
	}

	/**
	 * Determina si el año de la instancia actual es bisiesto.
	 *
	 * @return {@code true} si el año del objeto es bisiesto; {@code false} en caso contrario.
	 */
	public boolean anioBiciesto() {
    	return anioBiciesto(getAnio());
	}

	/**
	 * Calcula la cantidad total de días que tiene un mes en un año determinado.
	 *
	 * @param m El número de mes (1-12).
	 * @param a El año correspondiente.
	 * @return El número de días del mes (28, 29, 30 o 31).
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
	 * @return El número de días del mes actual.
	 */
	public int mesDias() {
    	return diasDelMes(getMes(), getAnio());
	}

	/**
	 * Devuelve la cantidad total de días del año de la instancia actual.
	 *
	 * @return 366 si el año es bisiesto, o 365 si es año común.
	 */
	public int aniosDias(){
		if (anioBiciesto()){
			return 366;
		}
		return 365;
	}

	/**
	 * Calcula la diferencia absoluta en días entre dos objetos {@code Fecha}.
	 *
	 * @param fecha1 La primera fecha a comparar.
	 * @param fecha2 La segunda fecha a comparar.
	 * @return La cantidad de días transcurridos entre ambas fechas.
	 */
	public int diferenciaDias(Fecha fecha1, Fecha fecha2) {
    	int d1 = fecha1.getDia(), m1 = fecha1.getMes(), a1 = fecha1.getAnio();
    	int d2 = fecha2.getDia(), m2 = fecha2.getMes(), a2 = fecha2.getAnio();
    	if (a1 > a2 || (a1 == a2 && m1 > m2) || (a1 == a2 && m1 == m2 && d1 > d2)) {
        	int D = d1, M = m1, A = a1;
        	d1 = d2; m1 = m2; a1 = a2;
        	d2 = D; m2 = M; a2 = A;
    	}
    	int diferencia = 0;
    	while (a1 < a2 || m1 < m2 || d1 < d2) {
        	d1++;
        	diferencia++;
        	if (d1 > diasDelMes(m1, a1)) {
            	d1 = 1;
            	m1++;
            	if (m1 > 12) {
                	m1 = 1;
                	a1++;
            	}
        	}
		}
    return diferencia;
	}

	/**
	 * Solicita por consola una cantidad de días (positiva o negativa) y la suma
	 * o resta a la fecha actual ajustando meses y años automáticamente.
	 *
	 * @return El día resultante tras la operación.
	 */
	public int sumarDias(){
	System.out.println("Ingrese la cantidad de días a sumar.");
	int diasSumar = scanner.nextInt();
	while (diasSumar > 0) {
		dia++;
		diasSumar--;
		if (dia > diasDelMes(mes, anio)) {
				dia = 1;
				mes++;
				if (mes > 12) {
					mes = 1;
					anio++;
				}
			}
		}
		while (diasSumar < 0) {
			dia--;
			diasSumar++;
			if (dia < 1) {
				mes--;
				if (mes < 1) {
					mes = 12;
					anio--;
				}
				dia = diasDelMes(mes, anio);
			}
		}
		return dia;
	}

	/**
	 * Solicita por consola una fecha inicial completa y una cantidad de días a sumar
	 * o restar, actualizando los atributos de la instancia con la fecha resultante.
	 */
	public void sumarDiasIn(){
		System.out.println("Ingrese una fecha inicial.");
		do{
		System.out.println("Ingrese un valor para año.");
		anio = scanner.nextInt();
		if (anio < 1582) {
			System.out.println("Error ingrese un valor válido para año");
		}
		}while(anio < 1582);
		System.out.println("Ingrese un valor para mes.");
		mes = scanner.nextInt();
		while (mes > 12 || mes < 1) {
			System.out.println("Error ingrese un valor válido para mes");
			mes = scanner.nextInt();
		}
		scanner.nextLine();
		System.out.println("Ingrese un valor para día.");
		dia = scanner.nextInt();
		if (mes == 2 && anioBiciesto() && dia > 29) {
			while (dia < 1 || dia > 29){
				System.out.println("Error ingrese un valor válido para día");
				dia = scanner.nextInt();
			}
		}
		if (mes == 2 && !anioBiciesto() && dia > 28) {
			while (dia < 1 || dia > 28){
				System.out.println("Error ingrese un valor válido para día");
				dia = scanner.nextInt();
			}
		}
		while (dia > 31 || dia < 1) {
			System.out.println("Error ingrese un valor válido para día");
		}
		System.out.println("Ingrese la cantidad de días a sumar.");
		int diasSumar = scanner.nextInt();
		while (diasSumar > 0) {
			dia++;
			diasSumar--;
			if (dia > diasDelMes(mes, anio)) {
					dia = 1;
					mes++;
					if (mes > 12) {
						mes = 1;
						anio++;
					}
			}
		}
		while (diasSumar < 0) {
			dia--;
			diasSumar++;
			if (dia < 1) {
				mes--;
				if (mes < 1) {
					mes = 12;
					anio--;
				}
					dia = diasDelMes(mes, anio);
			}
		}
	}

	/**
	 * Compara si la fecha actual coincide exactamente en día, mes y año con otra fecha.
	 *
	 * @param fecha2 El objeto {@code Fecha} con el que se va a comparar.
	 * @return {@code true} si ambas fechas son idénticas; {@code false} en caso contrario.
	 */
	public boolean fechasIguales(Fecha fecha2) {
		this.getDia();
		this.getMes();
		this.getAnio();
		fecha2.getDia();
		fecha2.getMes();
		fecha2.getAnio();
		return (this.dia == fecha2.dia && this.mes == fecha2.mes && this.anio == fecha2.anio);
	}

	/**
	 * Convierte un número de mes (1-12) a su nombre correspondiente en español.
	 *
	 * @param m El número de mes.
	 * @return El nombre del mes en minúsculas, o {@code "mes inválido"} si está fuera de rango.
	 */
	public String numeroMes(int m){
		if (m == 1){
			return "enero";
		}else if (m == 2){
			return "febrero";
		}else if (m == 3){
			return "marzo";
		}else if (m == 4){
			return "abril";
		}else if (m == 5){
			return "mayo";
		}else if (m == 6){
			return "junio";
		}else if (m == 7){
			return "julio";
		}else if (m == 8){
			return "agosto";
		}else if (m == 9){
			return "septiembre";
		}else if (m == 10){
			return "octubre";
		}else if (m == 11){
			return "noviembre";
		}else if (m == 12){
			return "diciembre";
		}
		return "mes inválido";
	}

	/**
	 * Convierte el nombre de un mes en español (en minúsculas) a su número equivalente (1-12).
	 *
	 * @param mp El nombre del mes.
	 * @return El número del mes correspondiente, o {@code -1} si el nombre no es válido.
	 */
	public int palabraMes(String mp){
		if (mp.equals("enero")){
			return 1;
		}else if (mp.equals("febrero")){
			return 2;
		}else if (mp.equals("marzo")){
			return 3;
		}else if (mp.equals("abril")){
			return 4;
		}else if (mp.equals("mayo")){
			return 5;
		}else if (mp.equals("junio")){
			return 6;
		}else if (mp.equals("julio")){
			return 7;
		}else if (mp.equals("agosto")){
			return 8;
		}else if (mp.equals("septiembre")){
			return 9;
		}else if (mp.equals("octubre")){
			return 10;
		}else if (mp.equals("noviembre")){
			return 11;
		}else if (mp.equals("diciembre")){
			return 12;
		}
		return -1;
	}

	/**
	 * Calcula el total de días transcurridos desde el 1 de enero hasta la fecha
	 * almacenada en la instancia actual.
	 *
	 * @return El número del día del año (de 1 a 365 o 366 en año bisiesto).
	 */
	public int diasTranscurridos(){
		int diasT = 0;
		int mesActual = 1;
		while (mesActual < mes){
			if (mesActual == 2){
				if (anioBiciesto()){
					diasT += 29;
				}else{
					diasT += 28;
				}
			}else if (mesActual == 4 || mesActual == 6 || mesActual == 9 || mesActual == 11){
				diasT += 30;
			}else{
				diasT += 31;
			}
			mesActual++;
		}

		diasT += dia;
		return diasT;
	}

	/**
	 * Devuelve una representación en cadena de la fecha con formato {@code dd/mm/aaaa}.
	 *
	 * @return La fecha formateada con ceros a la izquierda para día y mes menores a 10.
	 */
	public String toString() {
		String diaP = "" + dia;
		String mesP = "" + mes;
		if (dia < 10){
			diaP = "0" + dia;
		}
		if (mes < 10){
			mesP = "0" + mes;	
		}
		return diaP + "/" + mesP + "/" + anio;
	}

	/**
	 * Método principal que ejecuta pruebas interactivas de todos los métodos de la clase {@code Fecha}.
	 *
	 * @param args Argumentos de la línea de comandos (no utilizados).
	 */
	public static void main(String [] args){
		System.out.println("Vamos a calcular la diferencia de días entre dos fechas.");
		Fecha fecha1 = new Fecha();
		fecha1.setAnio();
		fecha1.setMes();
		if (fecha1.getMes() == 2){
			fecha1.mesFebrero();
		}else{
			fecha1.setDia();
		}
		Fecha fecha2 = new Fecha();
		fecha2.setAnio();
		fecha2.setMes();
		if (fecha2.getMes() == 2){
			fecha2.mesFebrero();
		}else{	
			fecha2.setDia();
		}
		System.out.println("La diferencia de días es: " + fecha1.diferenciaDias(fecha1, fecha2));
		
		System.out.println("Vamos a sumar días a una fecha, con una fecha con parámetros.");
		Fecha fecha3 = new Fecha();
		fecha3.fechaInicial(1, 1, 2026);
		fecha3.sumarDias();
		System.out.println("La fecha resultante es: " + fecha3.toString());

		System.out.println("Vamos a sumar días a una fecha, usando scanner.");
		Fecha fecha4 = new Fecha();
		fecha4.sumarDiasIn();
		fecha4.getDia();
		fecha4.getMes();
		fecha4.getAnio();
		System.out.println("La fecha resultante es: " + fecha4.toString());

		System.out.println("Vamos a determinar si dos fechas son iguales");
		Fecha fecha5 = new Fecha();
		fecha5.fechaInicial(1, 1, 2026);
		Fecha fecha6 = new Fecha();
		fecha6.fechaInicial(1, 1, 2026);
		if (fecha5.fechasIguales(fecha6)){
			System.out.println("Las fechas son iguales.");
		}else{
			System.out.println("Las fechas no son iguales.");
		}

		System.out.println("Vamos a determinar en cadena, dado el mes en formato entero");
		Fecha fecha7 = new Fecha();
		fecha7.setAnio();
		fecha7.setMes();
		if (fecha7.getMes() == 2){
			fecha7.mesFebrero();
		}else{	
			fecha7.setDia();
		}
		System.out.println("El mes en palabra es: " + fecha7.numeroMes(fecha7.getMes()));

		System.out.println("Vamos a determinar el número de mes, dado un mes en formato cadena.");
		Fecha fecha8 = new Fecha();
		fecha8.setAnio();
		fecha8.setMesPalabra();
		if ("febrero".equals(fecha8.getMesPalabra())){
			fecha8.mesFebrero();
		}else{	
			fecha2.setDia();
		}
		System.out.println("El mes en número es: " + fecha8.palabraMes(fecha8.getMesPalabra()));

		System.out.println("Vamos a calcular los días transcurridos del año");
		Fecha fecha9 = new Fecha();
		fecha9.setAnio();
		fecha9.setMes();
		if (fecha9.getMes() == 2){
			fecha9.mesFebrero();
		}else{
			fecha9.setDia();
		}
		System.out.println("Días transcurridos: " + fecha9.diasTranscurridos());
		
		System.out.println("Vamos a imprimir una fecha en el formato dd/mm/aa");
		Fecha fecha10 = new Fecha();
		fecha10.fechaInicial(1,9,2000);
		System.out.println(fecha10.toString());
	}
}
