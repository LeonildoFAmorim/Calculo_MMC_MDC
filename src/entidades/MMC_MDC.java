package entidades;

public class MMC_MDC {

    private boolean statusCalculoMMC(int[] numeros) {
        int somaDosNumeros = 0;
        boolean MMCNaoCalculado = false;
        for (int i = 0; i < numeros.length; i++) {
            somaDosNumeros += numeros[i];
        }
        if (somaDosNumeros != numeros.length) {
            MMCNaoCalculado = true;
        }
        return MMCNaoCalculado;
    }

    private int[] validaNumeros(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] < 0) {
                numeros[i] = numeros[i] * -1 ;
            }
        }
        return numeros;
    }

    public int calculaMMC(int[] numeros) {
        int [] numerosValidados = validaNumeros(numeros);
        int divisorAtual = 2;
        int MMC = 1;
        boolean MMCNaoCalculado = true;
        while (MMCNaoCalculado) {
            boolean houveOperacao = false;
            for (int posicaoAtual = 0; posicaoAtual < numerosValidados.length; posicaoAtual++) {
                if (numerosValidados[posicaoAtual] % divisorAtual == 0) {
                    numerosValidados[posicaoAtual] = numerosValidados[posicaoAtual] / divisorAtual;
                    houveOperacao = true;
                }
            }
            if (houveOperacao == true) {
                MMC *= divisorAtual;
            } else {
                divisorAtual++;
            }
            MMCNaoCalculado = statusCalculoMMC(numerosValidados);
        }
        return MMC;
    }
}
