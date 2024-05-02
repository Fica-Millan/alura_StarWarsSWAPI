import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        BuscarPelicula consulta = new BuscarPelicula();
        System.out.println("Escriba el número de la película de Star Wars que quiere consultar: ");
        try {
            var numeroPelicula = Integer.valueOf(teclado.nextLine());
            Pelicula pelicula = consulta.buscarPelicula(numeroPelicula);
            System.out.println(pelicula);
            GeneradorArchivo generador = new GeneradorArchivo();
            generador.guardarJson(pelicula);
        }catch (NumberFormatException e){
            System.out.println("Numero no encontrado "+e.getMessage());
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion");
        }
    }
}
