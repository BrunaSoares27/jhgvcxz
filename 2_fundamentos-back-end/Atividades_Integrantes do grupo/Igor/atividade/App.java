package atividade;

public class App {

    public static void main(String[] args) throws Exception {
        
        ArraysDinamicos numeros = new ArraysDinamicos();

        numeros.SetNumeros(5);
        numeros.SetNumeros(2);
        numeros.SetNumeros(9);
        numeros.SetNumeros(7);
        numeros.SetNumeros(1);

        System.out.println("imprimindo as Array");
        numeros.ArrayNumeros();
        System.out.println("Em ordem crecente");
        numeros.amostraEmOrdemCrecente();
        System.out.println("busca binario");
        numeros.Buscarbinario();

    }
    
}
