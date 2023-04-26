import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysDinamicos {

    private List<Integer> numeros = new ArrayList<Integer>();
    private List<Integer> maiores =  new ArrayList<Integer>();
    private List<Integer> numerosCopia = new ArrayList<Integer>();
    



    public void setNumeros(Integer newNumber) {
        this.numeros.add(newNumber);
    }

    public void imprimeArrayNumeros() {

        for (int element : numeros) {
            System.out.print(element + " ");
        }
        System.out.println();

    }

    public void imprimeEmOrdemCrescente() {
        numeros.sort(null);
        System.out.print(numeros.toString() + " ");
        System.out.println();
    }

    public void imprimeBuscaBinaria() {

        System.out.print(Collections.binarySearch(numeros, 9));

        System.out.println();
    }

    //O método copyOfArrays não funciona em listas, apenas em arrays com tipo primitivo.
    public void pegaOsMaioresIndexDeNumeros() {
        maiores = numeros.subList(2, 5);
        System.out.println(maiores);
    }

    public void comparaArrays() {
        Boolean saoIguais = numeros.equals(maiores);
        System.out.println("São iguais? " + saoIguais);
    }

    public void ImprimeNovoArrayContendoNumerosDescrecente() {
        numerosCopia.addAll(numeros); // nao é possivel usar o método copyOf em list de arrays
        for(int i  = (numerosCopia.size() - 1); i >= 0; i--) {
            System.out.print(numerosCopia.get(i) + " ");
        }
        System.out.println();
    }
}
