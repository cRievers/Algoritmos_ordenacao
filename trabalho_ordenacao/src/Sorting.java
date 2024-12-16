public abstract class Sorting {

    private int trocas=0;
    private int comparacoes=0;

    public int getComparacaoes(){
        return comparacoes;
    }

    public void addComparacao(){
        comparacoes++;
    }

    public int getTrocas(){
        return trocas;
    }

    public void addTroca(){
        trocas++;
    }

    public abstract void sort(int[] vet);
}
