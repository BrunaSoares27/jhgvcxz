package atividade;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraysDinamicos {
        
        private List<Integer> numeros = new ArrayList<Integer>();
        
        public void SetNumeros(Integer newNumber) {
            this.numeros.add(newNumber);
        }

        public void ArrayNumeros(){
            for (int element : numeros){
                System.out.print(element + "");
            }
            System.out.println();
        }
        public void amostraEmOrdemCrecente(){
            numeros.sort(null);
            System.out.println(numeros.toString());
        }
        
        public void Buscarbinario(){
            System.out.print(Collections.binarySearch(numeros, 9));
            System.out.println();
        }




    }



