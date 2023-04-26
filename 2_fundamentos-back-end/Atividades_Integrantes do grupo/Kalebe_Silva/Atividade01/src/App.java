public class App {

    public static void main(String[] args) throws Exception {

        ArraysDinamicos numeros = new ArraysDinamicos();


        numeros.setNumeros(5);
        numeros.setNumeros(2);
        numeros.setNumeros(9);
        numeros.setNumeros(7);
        numeros.setNumeros(1);

        System.out.println("Imprimindo o array");
        numeros.imprimeArrayNumeros();
        System.out.println("Em ordem crescente com toString:");
        numeros.imprimeEmOrdemCrescente();
        System.out.println("Busca binaria: ");
        numeros.imprimeBuscaBinaria();
        System.out.println("OS tres maiores numeros:");
        numeros.pegaOsMaioresIndexDeNumeros();
        System.out.println("Compara os dois arrays, numeros e maiores");
        numeros.comparaArrays();
        System.out.println("Array numerosCopia descrecente");
        numeros.ImprimeNovoArrayContendoNumerosDescrecente(); 
    }
}
