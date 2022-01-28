package lab1p2_cesarnunez_12141019;
import java.util.Random;
import java.util.Scanner;

public class Lab1P2_CesarNunez_12141019 {
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    
    public static void main(String[] args) {
        System.out.print("Ingrese la cantidad de filas: ");
        int n = input.nextInt();
        System.out.print("Ingrese la cantidad de columnas: ");
        int m = input.nextInt();
        System.out.print("Ingrese el valor de epsilon: ");
        double epsilon = input.nextInt();
        while(epsilon > 5 || epsilon < 1){
            System.out.println("\nDebe ingresar un valor entre 1 y 5!");
            System.out.print("Ingrese el valor de epsilon: ");
            epsilon = input.nextInt();
        }
        double delta = Math.pow(10, -epsilon); // error
        
        double[][] matriz = new double[n][m];
        llenarMatriz(matriz);
        
        System.out.println("\n************** Matriz Generada **************");
        imprimirMatriz(matriz);
        
        double[][] nMatriz = new double[n][m]; 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                double x = matriz[i][j];                
                nMatriz[i][j] = raizCuadrada(x, 0, x, delta);
            }
        }
        
        System.out.println("\n*************** Raíz Generada ***************");
        imprimirMatriz(nMatriz);
    } // fin de main
    
    public static void llenarMatriz(double[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 1 + rand.nextInt(100);
            }
        }
    } // llenarMatriz
    
    public static void imprimirMatriz(double[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "] ");
            }
            System.out.println();
        }
    } // Imprimrir matriz
    
    public static double raizCuadrada(double x, double rmin, double rmax, double error){ // búsqueda binaria
        double rmed = (rmax + rmin) / 2;
        if(x - error <= (Math.pow(rmed, 2)) && (Math.pow(rmed, 2)) <= x + error){
            return rmed;
        }else if(Math.pow(rmed, 2) > x + error){
            rmax = rmed;
            return raizCuadrada(x, rmin, rmax, error);
        }else{ //if(Math.pow(rmed, 2) < x - error){
            rmin = rmed;
            return raizCuadrada(x, rmin, rmax, error);
        }
    }        
} // fin de clase