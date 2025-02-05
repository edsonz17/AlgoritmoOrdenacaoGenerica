import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import CriarVetores.*;


public class Main {
    public static void main(String[] args) {
        int op = 0;
        int[] tamanhoVetor = {10,100000,1000000};
        int tamanhoDoVetor = 0;
        int tipoDeVetor = 0;
        KeyStringValueDouble[] copiaStringsValueDouble = {};
        KeyDoubleValueString[] copiaDoubleValueString = {};
        KeyDoubleValueInteger[] copiaDoubleValueInteger = {};
        boolean existeVetor = false;
        Scanner ler = new Scanner(System.in);
        System.out.println("\n----------------------");
        System.out.println("Ordenação de vetores");
        System.out.println("----------------------");
        
        String[] opOrder = {"1 - Ordenar o vetor em ordem crecente","2 - Ordenar o vetor em ordem decrecente\n"};
        String[] opAlg = {"\nEscolha o algoritmo para ordenar o vetor\n","1 - Merge Insert","2 - Quick Sort","3 - Heap Sort","4 - Tree Sort"};
        String[] opTipoDeVetor = {"\nEscolha o tipo de vetor para ordenar","1- Key String - value Double","2- Key Double - value Integer","3- Key Double - value Integer"};
        String[] opTamanhoDoVetor = {"\nEscolha o tamanho do vetor","1-1000","2-100000","3-1000000"};
        String[] opExisteVetor = {"\nEscolha uma opção","1-Continuar com o mesmo vetor","2-Criar outro vetor"};
        
        // Criando o objeto context que se comunica com a StrategeySort(interface) para executar o algoritmo escolhido pelo TipoAlg(enum)
        Context ordenar = new Context();

        do {
            // Passa uma String para validar valores com quantidade máximas de entradas
            int order = validarValores(opOrder, 2);
        
            int alg = validarValores(opAlg, 4);
            alg = 2*alg+order;
            
            
            if (existeVetor) {
                if (validarValores(opExisteVetor, 2) == 1) {
                   existeVetor = false; 
                }
            }
            
            if (!existeVetor) {
                tamanhoDoVetor = tamanhoVetor[validarValores(opTamanhoDoVetor, 3)];
                
                tipoDeVetor = validarValores(opTipoDeVetor, 3);
            }

            
            // Cria o TipoAlg(enum) para escolher o algoritmo
            TipoAlg tipoAlg = TipoAlg.values()[alg];
            // tipoAlg.obeterAlg() executa a função abstrata do tipo escolhido
            ordenar.trocarDeEstrategia(tipoAlg.obterAlg());

            // Ordena o o tipo de vetor escolhido com a estratégia escolhida
            if (tipoDeVetor == 0) {
                KeyStringValueDouble[] arrayKeyStringValueDouble = new KeyStringValueDouble[tamanhoDoVetor];
                if (!existeVetor) {
                    GeraVetores.createArrayKeyStringValueDouble(arrayKeyStringValueDouble);
                    copiaStringsValueDouble = arrayKeyStringValueDouble.clone();
                } else {
                    arrayKeyStringValueDouble = copiaStringsValueDouble.clone();
                }
                System.out.println("\n\nOrdenando Strings: " + Arrays.toString(arrayKeyStringValueDouble));
                ordenar.ordenarVet(arrayKeyStringValueDouble);
                System.out.println("\n\nOrdenando Strings: " + Arrays.toString(arrayKeyStringValueDouble));
            }
            
            if (tipoDeVetor == 1) {
                KeyDoubleValueString[] arrayKeyDoubleValueString = new KeyDoubleValueString[tamanhoDoVetor];
                if (!existeVetor) {
                    GeraVetores.createArrayKeyDoubleValueString(arrayKeyDoubleValueString);
                    copiaDoubleValueString = arrayKeyDoubleValueString.clone();
                } else {
                    arrayKeyDoubleValueString = copiaDoubleValueString.clone();
                }
                System.out.println("Ordenando Integers: " + Arrays.toString(arrayKeyDoubleValueString));
                ordenar.ordenarVet(arrayKeyDoubleValueString);
                System.out.println("Ordenando Integers: " + Arrays.toString(arrayKeyDoubleValueString));
            }
            
            if (tipoDeVetor == 2) {
                KeyDoubleValueInteger[] arrayKeyDoubleValueIntegers = new KeyDoubleValueInteger[tamanhoDoVetor];
                if (!existeVetor) {
                    GeraVetores.createArrayKeyDoubleValueInteger(arrayKeyDoubleValueIntegers);
                    copiaDoubleValueInteger = arrayKeyDoubleValueIntegers.clone();
                } else {
                    arrayKeyDoubleValueIntegers = copiaDoubleValueInteger.clone();
                }
                System.out.println("Ordenando Doubles: " + Arrays.toString(arrayKeyDoubleValueIntegers));
                ordenar.ordenarVet(arrayKeyDoubleValueIntegers);
                System.out.println("Ordenando Doubles: " + Arrays.toString(arrayKeyDoubleValueIntegers));
            }
            existeVetor = true;           

            System.out.println("\nSe deseja continuar digite um número maior que 0");
            try {
                op = ler.nextInt();
            } catch (InputMismatchException exception) {
                op = -1;
            }
            
        } while (op > 0);
        ler.close();
    }

    public static int validarValores(String[] frase, int quantidadeEntradas) {
        int opction = 0;
        Scanner read = new Scanner(System.in);
        try {
            for (String t : frase) {
                System.out.println(t);
            }
            opction = read.nextInt()-1;
            while (opction >= quantidadeEntradas || opction < 0) {
                System.out.println("Digite uma opção válida");
                opction = read.nextInt()-1;
            }
        } catch (InputMismatchException exception) {
            System.out.println("\nDigite um número por favor\n");
            opction = validarValores(frase, quantidadeEntradas);
        }
        // read.close();
        return opction;
    }
}
    