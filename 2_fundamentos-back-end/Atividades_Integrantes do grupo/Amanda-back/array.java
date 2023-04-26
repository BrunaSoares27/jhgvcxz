import java.util.*;

class ArraysDinamicos {
    public static void main(String args []) {
        Integer [] numeros = {5, 2, 9, 7, 1};

        System.out.println("Elementos do Array Numeros: ");
        for(int i=0; i<5; i++){
            System.out.println(numeros[i]);
        }

        System.out.println("=========");

        System.out.println("Ordenação Crescente - sort(): ");
        Arrays.sort(numeros);
        for(int i=0; i<5; i++){
            System.out.println(numeros[i]);
        }

        System.out.println("=========");

        System.out.println("O número 9 está na posição - " + Arrays.binarySearch(numeros, 9) + " - do Array");
        System.out.println("=========");

        List<Integer> lista = Arrays.asList(numeros);
        Collections.sort(lista, Collections.reverseOrder());
        List<Integer> maiores = lista.subList(0, 3);
        System.out.println("ArrayList com os três maiores valores: " + maiores);

        System.out.println("=========");

        System.out.println("Resultado do uso da função equals(): " + Arrays.toString(numeros).equals(maiores));
        System.out.println("=========");
        
        System.out.println("Array em ordem decrescente: ");
        for(int i=4; i>=0; i--){
            System.out.println(numeros[i]);
        }
    }
}