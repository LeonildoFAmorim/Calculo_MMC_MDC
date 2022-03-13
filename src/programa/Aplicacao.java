package programa;

import entidades.MMC_MDC;

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Calculo de MMC. Valores negativos serao considerados como positivos (regra MMC).");
        System.out.println();
        System.out.print("Quantos numeros para calcular o MMC e MDC? ");
        int qtdNumeros = scanner.nextInt();
        int[] numeros = new int[qtdNumeros];
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("digite o numero #" + (i + 1) + " = ");
            numeros[i] = scanner.nextInt();
        }
        System.out.println();
        System.out.println("numeros digitados: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + "  ");
        }
        System.out.println();
        MMC_MDC mmc_mdc = new MMC_MDC();
        int resultadoMMC = mmc_mdc.calculaMMC(numeros);
        System.out.println("MMC: " + resultadoMMC);
        System.out.println("Calculo MDC em breve!");
        scanner.close();
    }
}

