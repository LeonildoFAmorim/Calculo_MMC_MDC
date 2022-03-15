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
                numeros[i] = numeros[i] * -1;
            }
            if (numeros[i] == 0) {
                numeros[i] = 1;
            }
        }
        return numeros;
    }

    public long calculaMMC(int[] numeros) {
        int[] numerosValidados = validaNumeros(numeros);
        int divisor = 2;
        long MMC = 1;
        boolean MMCNaoCalculado = true;
        while (MMCNaoCalculado) {
            boolean houveDivisao = false;
            for (int posicaoAtual = 0; posicaoAtual < numerosValidados.length; posicaoAtual++) {
                if (numerosValidados[posicaoAtual] % divisor == 0) {
                    numerosValidados[posicaoAtual] /= divisor;
                    houveDivisao = true;
                }
            }
            if (houveDivisao) {
                MMC *= divisor;
            } else {
                divisor++;
            }
            MMCNaoCalculado = statusCalculoMMC(numerosValidados);
        }
        return MMC;
    }

    public int calculaMDC(int[] numeros) {
        int[] numerosValidados = validaNumeros(numeros);
        int divisor = 2;
        int MDC = 1;
        boolean MDCNaoCalculado = true;
        while (MDCNaoCalculado) {
            boolean houveDivisao = false;
            int divisoesRealizadas = 0;
            for (int posicaoAtual = 0; posicaoAtual < numerosValidados.length; posicaoAtual++) {
                if (numerosValidados[posicaoAtual] % divisor == 0) {
                    numerosValidados[posicaoAtual] /= divisor;
                    divisoesRealizadas++;
                    houveDivisao = true;
                }
                if (numeroFoiTotalmenteFatorado(numerosValidados[posicaoAtual])) {
                    MDCNaoCalculado = false;
                    break;
                }
            }
            if (todosNumerosSaoDivisoresDoDivisor(numerosValidados.length, divisoesRealizadas)) {
                MDC *= divisor;
            }
            if (!houveDivisao) {
                divisor++;
            }
        }
        return MDC;
    }

    private boolean todosNumerosSaoDivisoresDoDivisor(int numero, int outroNumero) {
        return numero == outroNumero;
    }

    private boolean numeroFoiTotalmenteFatorado (int numero){
        return numero == 1;
    }
}
