import java.util.Arrays;

public class ArraysDinamicos {
   
    int[] numeros = {5, 2, 9, 7, 1};
    
    public void imprimeArrayNum(){

        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
    }
    
    Arrays.sort(numeros);
    System.out.println();
    System.out.println(Arrays.toString(numeros));
 
    int posicao = Arrays.binarySearch(numeros, 9);
    if (posicao >= 0) {
        System.out.println("O número 9 foi encontrado na posição " + posicao + " do array numeros.");
    } else {
        System.out.println("O número 9 não foi encontrado no array numeros.");
    }

    int[] maiores = new int[3];

  
    maiores = Arrays.copyOfRange(numeros, numeros.length - 3, numeros.length);
    System.out.println("Os três maiores números do array numeros:");
    System.out.println(Arrays.toString(maiores));

    
    boolean saoIguais = Arrays.equals(numeros, maiores);
    if (saoIguais) {
        System.out.println("Os arrays numeros e maiores são iguais.");
    } else {
        System.out.println("Os arrays numeros e maiores são diferentes.");
    }

    int[] numerosCopia = Arrays.copyOf(numeros, numeros.length);


    System.out.println("Elementos do array numerosCopia em ordem decrescente:");
    for (int i = numerosCopia.length - 1; i >= 0; i--) {
        System.out.print(numerosCopia[i] + " ");
    }
    System.out.println();
}
}

         

