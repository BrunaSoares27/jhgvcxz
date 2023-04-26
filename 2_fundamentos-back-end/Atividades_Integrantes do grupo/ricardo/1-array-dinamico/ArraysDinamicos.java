import java.util.ArrayList;
import java.util.Collections;

public class ArraysDinamicos {
  public static void main(String[] args) {
    // Cria o array dinâmico
    ArrayList<Integer> numeros = new ArrayList<Integer>();

    // Adicionando os valores
    numeros.add(5);
    numeros.add(2);
    numeros.add(9);
    numeros.add(7);
    numeros.add(1);

    // Imprimindo os elementos
    System.out.print("Array numeros: ");
    for (int numero : numeros) {
        System.out.print(numero + " ");
    }
    
    // Transforma e imprime array em ordem crescente
    Collections.sort(numeros);
    System.out.println();
    System.out.print("Array em ordem crescente: " + numeros);

    // Busca número 9
    int busca = Collections.binarySearch(numeros, 9);
    System.out.println();
    System.out.print("Busca: " + busca); //Retorna o índice que o número 9 está

    // Copia e imprime 3 maiores numeros do array
    ArrayList<Integer> maiores = new ArrayList<Integer>();
    maiores.addAll(numeros.subList(2, 5));

    System.out.println();
    System.out.print("3 maiores elementos do array numeros: " + maiores);

    // Método equals
    boolean igualdade = numeros.equals(maiores);
    System.out.println();
    System.out.print("Resultado equals: " + igualdade);

    //Imprime array numeros em ordem decrescente
    Collections.sort(numeros, Collections.reverseOrder());
    System.out.println();
    System.out.print("Array numeros em ordem decrescente: " + numeros);
  }
}
