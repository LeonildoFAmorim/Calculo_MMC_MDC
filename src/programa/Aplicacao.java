package programa;

import entidades.MMC_MDC;

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Calculo de MMC. Valores negativos serao considerados como positivos (regra MMC). O valor zero não sera considerado.");
        System.out.println();
        System.out.print("Quantos numeros para calcular o MMC e MDC? ");
        int qtdNumeros = scanner.nextInt();
        int[] numerosMMC = new int[qtdNumeros];
        int[] numerosMDC = new int[qtdNumeros];

        for (int i = 0; i < numerosMMC.length; i++) {
            System.out.print("digite o numero #" + (i + 1) + " = ");
            numerosMMC[i] = scanner.nextInt();
            numerosMDC[i] = numerosMMC[i];
        }

        System.out.println();
        System.out.println("numeros digitados: ");
        for (int i = 0; i < numerosMMC.length; i++) {
            System.out.println(numerosMMC[i] + "  ");
        }
        System.out.println();
        MMC_MDC mmc_mdc = new MMC_MDC();
        int resultadoMMC = mmc_mdc.calculaMMC(numerosMMC);
        System.out.println("MMC: " + resultadoMMC);
        int resultadoMDC = mmc_mdc.caluculaMDC(numerosMDC);
        System.out.println("MDC: " + resultadoMDC);
        scanner.close();
    }
}

