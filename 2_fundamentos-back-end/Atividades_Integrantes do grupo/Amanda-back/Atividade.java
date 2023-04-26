import java.util.*;

    class DynamicArrayTest {
        public static void main(String args []){
        
            System.out.println("Apresentação do Array: ");
            Integer[] numeros = {5, 2, 9, 7, 1};
            for(int i=0; i<5; i++){
                System.out.println(i);
            }
            
            System.out.println("Array em Ordem Crescente: ");
            Arrays.sort(numeros);
            for(int i : numeros){
                System.out.println(i);
            }

            System.out.println("A posição do número nove no Array é: " + Arrays.binarySearch(numeros, 9));
            
           List<Integer> lista = Arrays.asList(numeros);
           Collections.sort(lista, Collections.reverseOrder());
           List<Integer> maiores = lista.subList(0, 3);
           System.out.println("ArrayList com valores maiores: " + maiores);
           System.out.println(Arrays.toString(numeros).equals(maiores));
           System.out.println("ArrayList com valores decrescentes: " + lista);
           
        
        }
}




