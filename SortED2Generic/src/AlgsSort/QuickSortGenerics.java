package AlgsSort;

public class QuickSortGenerics <T extends Comparable<? super T>> implements StrategeySort<T> {
    
    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length-1);   
    }

    void quickSort(T []vet, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particiona(vet, inicio, fim);

            quickSort(vet,  inicio, posicaoPivo - 1);
            quickSort(vet,  posicaoPivo + 1, fim);
        }
    }

    int particiona (T []vet, int inicio, int fim) {
        T pivo = vet[inicio];
        int i = inicio + 1, f = fim;

        while (i <= f) {

            // Se o valor da parte esquerda do vetor for menor que o pivô.
            if (vet[i].compareTo(pivo) < 0) {
                i++;
            } 
            // Se o valor da parte direita do vetor for maior que o pivô.
            else if (vet[f].compareTo(pivo) > 0) {
                f--;
            } else {
                T troca = vet[i];
                vet[i] = vet[f];
                vet[f] = troca;
                i++;
                f--;
            }           
        }
        // Troca o pivo com o elemento mais a direita que é menor que ele.
        vet[inicio] = vet[f];
        vet[f] = pivo;
        return f;
    }
}
