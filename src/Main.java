/*
Entrega de trabalho
Nós,
Fabricio Viana Belomo
Felype Carvalho de Oliveira
declaramos que
todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos à equipe e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou prejudicar outros.
*/
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Exception {
        float[][] matriz = lerEntradaTxt("entrada.txt");

        if (matriz.length > 0) {
            centroGravitacional(matriz);
        } else {
            System.out.println("Matriz inválida!");
        }
    }

    public static float[][] lerEntradaTxt(String nomeArquivo) throws Exception {
        FileReader arquivo = new FileReader(nomeArquivo);
        BufferedReader leitorArq = new BufferedReader(arquivo);
        String linhaArquivo = "";
        String[] tamanhoMatriz = new String[2];

        linhaArquivo = leitorArq.readLine();
        tamanhoMatriz = linhaArquivo.split(" ");

        int linhasMatriz = Integer.parseInt(tamanhoMatriz[0]);
        int colunasMatriz = Integer.parseInt(tamanhoMatriz[1]);

        if (linhasMatriz > 2 && colunasMatriz > 2){
            float[][] matriz = new float[linhasMatriz][colunasMatriz];
            String[] valoresMatriz = new String[colunasMatriz];

            do {
                for(int i = 0; i < matriz.length; i++) {
                    linhaArquivo = leitorArq.readLine();
                    if (linhaArquivo != null) {
                        valoresMatriz = linhaArquivo.split(" ");
                        for(int j = 0; j < matriz[i].length; j++) {
                            matriz[i][j] = Float.parseFloat(valoresMatriz[j]);
                        }
                    } else {
                    break;
                    }
                }
            } while (linhaArquivo != null);
            leitorArq.close();
            return matriz;
        } else {
            float[][] matrizErro = new float[0][0];
            return matrizErro;
        }
    }

    public static void centroGravitacional(float[][] matriz) {
        float menorDiferencaColunas = 0f;
        float menorDiferencaLinhas = 0f;
        int linhaCentroGravitacional = 0;
        int colunaCentroGravitacional = 0;

        for (int linhaAtual = 0; linhaAtual < matriz.length; linhaAtual++) {
            int numeroLinhasAbaixo = (matriz.length - 1);
            float somaValoresLinhasAcima = 0f;
            float somaValoresLinhasAbaixo = 0f;
            float diferencaLinhasAtual = 0f;

            for (int linhasAcima = linhaAtual - 1; linhasAcima >= 0; linhasAcima--) {
                for (int colunasAcima = 0; colunasAcima < matriz[linhasAcima].length; colunasAcima++) {
                    somaValoresLinhasAcima += matriz[linhasAcima][colunasAcima];
                }
            }

            int linhasAbaixo = linhaAtual + 1;

            if (linhasAbaixo <= numeroLinhasAbaixo) {
                do {
                    for (int colunasAbaixo = 0; colunasAbaixo < matriz[linhasAbaixo].length; colunasAbaixo++) {
                        somaValoresLinhasAbaixo += matriz[linhasAbaixo][colunasAbaixo];
                    }
                    linhasAbaixo++;
                } while(linhasAbaixo <= numeroLinhasAbaixo);
            }

            if (somaValoresLinhasAcima > somaValoresLinhasAbaixo) {
                diferencaLinhasAtual = (somaValoresLinhasAcima - somaValoresLinhasAbaixo);
            } else {
                diferencaLinhasAtual = (somaValoresLinhasAbaixo - somaValoresLinhasAcima);
            }

            for (int colunaAtual = 0; colunaAtual < matriz[linhaAtual].length; colunaAtual++) {
                int numeroColunasDireita = (matriz[linhaAtual].length - 1);
                float somaValoresColunasDireita = 0f;
                float somaValoresColunasEsquerda = 0f;
                float diferencaColunasAtual = 0f;

                int colunasDireita = colunaAtual + 1;

                if (colunasDireita <= numeroColunasDireita) {
                    do {
                        somaValoresColunasDireita += matriz[linhaAtual][colunasDireita];
                        colunasDireita++;
                    } while(colunasDireita <= numeroColunasDireita);
                }

                if (colunaAtual != 0) {
                    for (int colunasEsquerda = colunaAtual - 1; colunasEsquerda >= 0; colunasEsquerda--) {
                        somaValoresColunasEsquerda += matriz[linhaAtual][colunasEsquerda];
                    }
                }

                if (somaValoresColunasDireita > somaValoresColunasEsquerda) {
                    diferencaColunasAtual = (somaValoresColunasDireita - somaValoresColunasEsquerda);
                } else {
                    diferencaColunasAtual = (somaValoresColunasEsquerda - somaValoresColunasDireita);
                }

                if (diferencaColunasAtual != 0) {
                    if (linhaAtual != 0 || colunaAtual != 0) {
                        if (diferencaColunasAtual < menorDiferencaColunas) {
                            menorDiferencaColunas = diferencaColunasAtual;
                            colunaCentroGravitacional = colunaAtual + 1;
                        }
                    } else {
                        menorDiferencaColunas = diferencaColunasAtual;
                        menorDiferencaLinhas = diferencaLinhasAtual;
                        linhaCentroGravitacional = linhaAtual + 1;
                        colunaCentroGravitacional = colunaAtual + 1;
                    }
                }
            }

            if (diferencaLinhasAtual != 0) {
                if (diferencaLinhasAtual < menorDiferencaLinhas) {
                    menorDiferencaLinhas = diferencaLinhasAtual;
                    linhaCentroGravitacional = linhaAtual + 1;
                }
            }
        }
        System.out.println("Centro: " + linhaCentroGravitacional + ", " + colunaCentroGravitacional);
    }
}