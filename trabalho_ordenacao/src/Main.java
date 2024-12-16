import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Sorting sorts[] = {new MergeSort(), new QuickSort()}; //metodos para ordenar
        String results = "";

        int vetor[] = {10,50,100,1000,10000,50000}; //quantidades de itens de cada arquivo
        int array[] = {}; //valores lidos do arquivo

        for(Sorting sorted : sorts){ //roda um metodo
            results += "\nMETODO: " + sorted.getClass().getCanonicalName();
            for(int i=0; i<vetor.length; i++){ //roda um arquivo
                String nome = "sequencia_" + Integer.toString(vetor[i]) + ".txt";
                try {
                    FileReader fr = new FileReader(nome);
                    BufferedReader bf = new BufferedReader(fr);

                    array = new int[vetor[i]];
                    String leitura = bf.readLine();
                    bf.close();
                    String numeros[] = leitura.split(",");
                    for(int j=0; j<vetor[i]; j++)
                        array[j] = Integer.parseInt(numeros[j]);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // System.out.println("Antes de ordenar:");
                // for(int pos: array){
                //     System.out.print(pos + " ");
                // }

                long tempoInicial = System.nanoTime();
                sorted.sort(array);
                long tempoFinal = System.nanoTime();

                // System.out.println("\nDepois de ordenar:");
                // for(int pos: array){
                //     System.out.print(pos+" ");
                // }

                long tempoTotal = tempoFinal - tempoInicial;
                double tempo = tempoTotal / 1000000.0; //converte ns -> ms
                results += "\nTamanho: " + vetor[i] + "\t Comparacoes: " + sorted.getComparacaoes() + "\t Trocas: " 
                        + sorted.getTrocas() + "\t Tempo: " + String.format("%.2f", tempo) + "ms";
            }
        }

        System.out.println(results);

    }
}
