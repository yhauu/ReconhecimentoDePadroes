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

    public static double[][] lerEntradaTxt(String nomeArquivo) throws Exception {
        FileReader arquivo = new FileReader(nomeArquivo);
        BufferedReader leitorArq = new BufferedReader(arquivo);
        String linhaArquivo = "";
        String[] tamanhoMatriz = new String[2];

        linhaArquivo = leitorArq.readLine();
        tamanhoMatriz = linhaArquivo.split(" ");

        int linhasMatriz = Integer.parseInt(tamanhoMatriz[0]);
        int colunasMatriz = Integer.parseInt(tamanhoMatriz[1]);

        if (linhasMatriz > 2 && colunasMatriz > 2){
            double[][] matriz = new double[linhasMatriz][colunasMatriz];
            String[] valoresMatriz = new String[colunasMatriz];

            do {
                for(int i = 0; i < matriz.length; i++) {
                    linhaArquivo = leitorArq.readLine();
                    if (linhaArquivo != null) {
                        valoresMatriz = linhaArquivo.split(" ");
                        for(int j = 0; j < matriz[i].length; j++) {
                            matriz[i][j] = Double.parseDouble(valoresMatriz[j]);
                        }
                    } else {
                    break;
                    }
                }
            }
            while (linhaArquivo != null);
            leitorArq.close();
            return matriz;
        } else {
            double[][] matrizErro = new double[0][0];
            return matrizErro;
        }
    }

    public static void centroGravitacional(double[][] matriz) {
        double menorDiferencaColunas = 0f;
        double menorDiferencaLinhas = 0f;
        for (int linhaAtual = 0; linhaAtual < matriz.length; linhaAtual++) {
            int numeroLinhasAbaixo = (matriz.length - 1) - linhaAtual;
            double somaValoresLinhasAcima = 0f;
            double somaValoresLinhasAbaixo = 0f;
            double diferencaLinhasAtual = 0f;

            for (int linhasAcima = linhaAtual - 1; linhasAcima >= 0; linhasAcima--) {
                for (int colunasAcima = 0; colunasAcima < matriz[linhasAcima].length; colunasAcima++) {
                    somaValoresLinhasAcima += matriz[linhasAcima][colunasAcima];
                }
            }

            for (int linhasAbaixo = linhaAtual + 1; linhasAbaixo <= numeroLinhasAbaixo; linhasAbaixo++) {
                for (int colunasAbaixo = 0; colunasAbaixo < matriz[linhasAbaixo].length; colunasAbaixo++) {
                    somaValoresLinhasAbaixo += matriz[linhasAbaixo][colunasAbaixo];
                }
            }

            if (somaValoresLinhasAcima > somaValoresLinhasAbaixo) {
                diferencaLinhasAtual = somaValoresLinhasAcima - somaValoresLinhasAbaixo;
            } else {
                diferencaLinhasAtual = somaValoresLinhasAbaixo - somaValoresLinhasAcima;
            }

            for (int colunaAtual = 0; colunaAtual < matriz[linhaAtual].length; colunaAtual++) {
                int numeroColunasDireita = (matriz[linhaAtual].length - 1) - colunaAtual;
                double somaValoresColunasDireita = 0f;
                double somaValoresColunasEsquerda = 0f;
                double diferencaColunasAtual = 0f;

                if (colunaAtual != matriz[linhaAtual].length) {
                    for (int colunasDireita = colunaAtual + 1; colunasDireita <= numeroColunasDireita; colunasDireita++) {
                        somaValoresColunasDireita += matriz[linhaAtual][colunasDireita];
                    }
                }

                if (colunaAtual != 0) {
                    for (int colunasEsquerda = colunaAtual - 1; colunasEsquerda >= 0; colunasEsquerda--) {
                        somaValoresColunasEsquerda += matriz[linhaAtual][colunasEsquerda];
                    }
                }

                if (somaValoresColunasDireita > somaValoresColunasEsquerda) {
                    diferencaColunasAtual = somaValoresColunasDireita - somaValoresColunasEsquerda;
                } else {
                    diferencaColunasAtual = somaValoresColunasEsquerda - somaValoresColunasDireita;
                }

                if (linhaAtual != 0 && colunaAtual != 0) {
                    if (diferencaColunasAtual < menorDiferencaColunas && diferencaLinhasAtual < menorDiferencaColunas) {
                        menorDiferencaColunas = diferencaColunasAtual;
                        menorDiferencaLinhas = diferencaLinhasAtual;
                    }
                } else {
                    menorDiferencaColunas = diferencaColunasAtual;
                    menorDiferencaLinhas = diferencaLinhasAtual;
                }

                //coluna; //numero de colunas para a esquerda
                //matriz[linha].length - coluna - 1;//numero de colunas para a direita

            }
        }
    }

    public static void main(String[] args) throws Exception {
        double[][] matriz = lerEntradaTxt("entrada.txt");

        if (matriz.length > 0) {
            // for(int i = 0; i < matriz.length; i++) {
            //     for(int j = 0; j < matriz[i].length; j++) {
            //         System.out.println("M[" + i + "][" + j + "]: " + matriz[i][j]);
            //     }
            // }

            // l = numero de colunas para a esquerda
            // m[k].length = numero de colunas
            // m[k].length - l - 1 = numero de colunas para a direita
            centroGravitacional(matriz);
        } else {
            System.out.println("Matriz inválida!");
        }
    }
}