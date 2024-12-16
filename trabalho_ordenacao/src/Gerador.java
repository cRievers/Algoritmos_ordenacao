import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Gerador {

    public static void gerarArquivo(int[] tam) {
        // Caminho do arquivo
        for(int i=0; i<tam.length; i++){
            String caminhoDoArquivo = "sequencia_" + Integer.toString(tam[i]) + ".txt";
            
            try {
                // Cria um objeto File para o arquivo
                File arquivo = new File(caminhoDoArquivo);
                
                // Verifica se o arquivo já existe
                if (!arquivo.exists()) {
                    // Cria o arquivo se ele não existir
                    arquivo.createNewFile();
                    System.out.println("Arquivo criado: " + caminhoDoArquivo);
                }
                
                // Cria um FileWriter e um BufferedWriter para escrever no arquivo
                FileWriter fw = new FileWriter(arquivo);
                BufferedWriter bw = new BufferedWriter(fw);

                // Escreve no arquivo
                int number;
                Random rd = new Random(2);

                for(int j=0; j<tam[i]; j++){
                    number = rd.nextInt(tam[i]);
                    bw.write(number + ",");
                }
                
                // Fecha o BufferedWriter
                bw.close();
                System.out.println("Texto escrito no arquivo com sucesso.");
            } catch (IOException e) {
                // Em caso de erro ao criar ou escrever no arquivo
                e.printStackTrace();
            }
        }
    }

}
