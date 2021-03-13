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

    public static void main(String[] args) throws Exception {
        double[][] matriz = lerEntradaTxt("entrada.txt");

        if (matriz.length > 0) {
            for(int i = 0; i < matriz.length; i++) {
                for(int j = 0; j < matriz[i].length; j++) {
                    System.out.println("M[" + i + "][" + j + "]: " + matriz[i][j]);
                }
            }
        } else {
            System.out.println("Matriz inválida!");
        }
    }
}