
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

    public static int[][] lerEntradaTxt(String nomeArquivo) throws Exception {
        FileReader arquivo = new FileReader(nomeArquivo);
        BufferedReader leitorArq = new BufferedReader(arquivo);
        String linhaArquivo = "";

        do {
            linhaArquivo = leitorArq.readLine();
            if (linhaArquivo != null) {
                System.out.println("Linhas: " + linhaArquivo);
            }
        }
        while (linhaArquivo != null);

        leitorArq.close();
        return null;
    }

    public static void main(String[] args) throws Exception {
        int[][] matriz = lerEntradaTxt("entrada.txt");
    }
}
