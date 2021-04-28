import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Taller02UnitTesting {

    public static final String path = "cadena.txt";
    public static Scanner lector;
    public static Scanner tec = new Scanner(System.in);

    public static boolean validarExistenciaArchivo(String path){
        Scanner lector;
        boolean existe;
        try{
            File archivo = new File(path);
            lector = new Scanner(archivo);
            existe = true;
        }catch(FileNotFoundException e){
            existe = false;
            System.out.println("El archivo no existe");
        }

        return existe;
    }


    public static String leerPath(){
        var tec = new Scanner(System.in);
        System.out.println("Ingrese el path del archivo:");

        String path = tec.nextLine();
        return path;
    }

    public static boolean validarFormatoPath(String path){
        boolean validacion = path.endsWith(".txt");
        if(!validacion){
            System.out.println("Formato erroneo");

        }
        return validacion;
    }

    public static String obtenerPathValido(String path){
        do{
            path = leerPath();
        }while(!validarFormatoPath(path) ||  !validarExistenciaArchivo(path));

        return path;
    }


    public static void leerDatosArchivo(String path, ArrayList<String> datosArchivo){
        Scanner lector;
        try {
            lector = new Scanner(new File(path));

            while (lector.hasNextLine()) {
                String[] data = lector.nextLine().split("");
                for(String x : data){
                    datosArchivo.add(x);
                }

            }
            lector.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

    public static void mostrarItems(ArrayList<String> datosArchivo){
        for(int i = 0; i < datosArchivo.size(); i+=2 ){
            int indice = i/2 +1;
            System.out.println("["+indice+"] Producto: "+datosArchivo.get(i)+" Precio: "+datosArchivo.get(i+1));
        }

    }



    public static void revertirPalabra(ArrayList<String> datosArchivo) {
        int cont =0;
        ArrayList<String> palindromo = null;

        String palabra = "";

        for (int i = 0; i < datosArchivo.size(); i++) {
          palindromo.set(i, formatPalabra(datosArchivo.get(i)));
          palabra = palindromo.get(i);

          palindromo.set(i,new StringBuilder(palabra).reverse().toString());
          cont+=esPalindromo(palindromo.get(i),datosArchivo.get(i));


        }

        System.out.println("La cantidad de palindromos es: "+cont);

    }

    private static int esPalindromo(String s, String s1) {

        s1 = formatPalabra(s1);
        if(s.equals(s1)){
            return 1;
        }else{
            return 0;
        }
    }



    public static String formatPalabra(String palabra) {
        String[] quitar = {" ", ",", "."};
        palabra = palabra.toLowerCase();
        for (int i = 0; i < quitar.length; i++) {
            palabra = palabra.replace(quitar[i], "");
        }
        return palabra;
    }


}


