//code from
//João Arthur Brunet
//Computação @ UFCG

public class MergeSort extends Sorting{
    private void merge(int[] v, int left, int middle, int right) {
        // transfere os elementos entre left e right para um array auxiliar.
        int[] helper = new int[v.length];

        for (int i = left; i <= right; i++) {
            helper[i] = v[i];
        }
        int i = left;
        int j = middle + 1;
        int k = left;
        
        while (i <= middle && j <= right) {
            if (helper[i] <= helper[j]) {
                v[k] = helper[i];
                i++;
            } else {
                v[k] = helper[j];
                j++;
            }
            k++;
            super.addComparacao();
            super.addTroca();
        }
        // se a metade inicial não foi toda consumida, faz o append.
        while (i <= middle) {
            v[k] = helper[i];
            i++;
            k++;
            super.addTroca();
        }
        // Não precisamos nos preocupar se a metade final foi 
        // toda consumida, já que, se esse foi o caso, ela já está
        // no array final.
    }

    private void mergeSort(int[] v, int left, int right) {   
        if (left >= right)
            return;
        else {
            int middle = (left + right) / 2;
            mergeSort(v, left, middle);
            mergeSort(v, middle + 1, right);
            merge(v, left, middle, right);
        } 
    }

    @Override
    public void sort(int[] vetor){
        mergeSort(vetor, 0, vetor.length-1);
    }
}
