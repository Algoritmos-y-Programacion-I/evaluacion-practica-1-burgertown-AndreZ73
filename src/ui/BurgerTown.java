package ui;

import java.util.Scanner;

public class BurgerTown {

    public static Scanner reader;
    public static double[] precios;
    public static int[] unidades;
    

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a BurgerTown!");

        int totalUnidades = establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada plato vendido en el dia");
            System.out.println("2. Calcular la cantidad total de platos vendidos en el dia");
            System.out.println("3. Calcular el precio promedio de los platos vendidos en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de platos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de platos vendidos en el dia fue de: "+calcularTotalPlatosVendidos());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de los platos vendidos en el dia fue de: "+calcularPrecioPromedio(totalUnidades));
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales(totalUnidades));
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarPlatosSobreLimite(limite)+" superaron o igualaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpcion invalida, intenta nuevamente.");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de platos diferentes 
     * vendidos en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static int establecerCantidadVendida() {

        System.out.println("\nDigite el numero de platos diferentes vendidos en el dia ");
        int platos = reader.nextInt();

        precios = new double[platos];
        unidades = new int[platos];

        return platos;

    }
    /**
     * Description: This method asks the user for the price of the dishes and the amount he sold of that dish
     * pre: The Scanner must be initialized
     * pre: The arrays price and units must be declared
     * pos: The arrays price and units are initialized
     */
    public static void solicitarDatos(){
        for (int i = 0; i < precios.length; i++) {
        System.out.println("\nDigite el precio del plato: ");
        precios[i] = reader.nextInt();

        System.out.println("\nDigite la cantidad que vendio de ese plato: ");
        unidades[i] = reader.nextInt();
        }
    }
    /**
     * Description: This method calculates the total of dishes sold in a day
     * pre: The Scanner must be initialized
     * pre: The array price must be declared
     * pos: The array price is initialized
     */
    public static int calcularTotalPlatosVendidos(){
        int totalUnidades = 0;
        for (int j = 0; j < unidades.length; j++) {
            totalUnidades += unidades[j];
        }
        return totalUnidades;
    }
    /**
     * Description: This method calculates the average price of the dished the clients ordered in a day
     * pre: The Scanner must be initialized
     * pre: The array price must be declared
     * pos: The array price is initialized
     * @param int dishes is the amount of dishes that the clients ordered in a day
     */
    public static double calcularPrecioPromedio(int platos){
        double averagePrice = 0;
        double totalPrices = 0;
        for (int x = 0; x < precios.length; x++) {
            totalPrices += precios[x];
        }
        averagePrice = totalPrices / platos;
        return averagePrice;
        
    }
    /**
     * Description: This method calculates the total in sales he made in a day
     * pre: The Scanner must be initialized
     * pre: The array price must be declared
     * pos: The array price is initialized
     * @param int totalUnits is the amount of units of each dish he sold in a day
     */
    public static double calcularVentasTotales(int totalUnidades){
        double totalPriceDish = 0;
        double totalSales = 0;

        for (int a = 0; a < precios.length; a++){
            totalPriceDish = precios[a]*unidades[a];
            totalSales += totalPriceDish;
        }

        return totalSales;

    }
    /**
     * Description: This method checks if a dish exceeded a limit of sales
     * pre: The Scanner must be initialized
     * pre: The array price must be declared
     * pos: The array price is initialized
     * @param double limite is the limit or minimum price
     */
    public static int consultarPlatosSobreLimite(double limite){
        int dishesOverLimit = 0;
        double totalPriceDish = 0;
        for (int b = 0; b < precios.length; b++){
            totalPriceDish = precios[b] * unidades [b];
            if (totalPriceDish >= limite){
                dishesOverLimit +=1;
            }
        }
        return dishesOverLimit;

    }

}