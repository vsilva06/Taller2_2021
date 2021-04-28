import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Taller02UnitTesting {



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


   /* public static int leerIndiceEleccion(){
        var tec = new Scanner(System.in);
        System.out.println("Ingrese el indice a buscar:");
        int eleccion = tec.nextInt();
        return eleccion;
    }



    public static int excepcionLeerIndice(){
        var tec = new Scanner(System.in);
        int eleccion;
        try{
            eleccion = leerIndiceEleccion();
        }catch(InputMismatchException e){
            eleccion = -2;
            tec.next();
        }
        return eleccion;
    } */

    public static boolean validarNumeroRango(int numero, int limiteInferior, int limiteSuperior){
        boolean validacion;
        if(numero < limiteInferior || numero > limiteSuperior){
            System.out.println("Respuesta invalida");
            validacion = false;
        }
        else{
            validacion = true;
        }
        return validacion;

    }

  /*  public static int obtenerEleccionValida(ArrayList<String> datosArchivo){
        int eleccion;
        do{
            eleccion = excepcionLeerIndice();
        }while((!validarNumeroRango(eleccion, 1, (datosArchivo.size()/2))));

        return eleccion;
    }   */

    public static void leerDatosArchivo(String path, ArrayList<String> datosArchivo){
        Scanner lector;
        try {
            lector = new Scanner(new File(path));

            while (lector.hasNextLine()) {
                String[] data = lector.nextLine().split(",");
                for(String x : data){
                    datosArchivo.add(x);
                }

            }
            lector.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

  /*  public static int sumaValorTotal(){
        int total = 0;
        for(int i = 1; i < datosArchivo.size(); i+=2){
            total += validarParseInt(datosArchivo.get(i), i);
        }
        return total;
    }*/

   /* public static int validarParseInt(String numeroString, int indice){
        int numero;
        try{
            numero = Integer.parseInt(numeroString);

        }catch(NumberFormatException e){
            System.out.println("El producto ["+datosArchivo.get(indice-1)+"] presenta error en el formato del precio: "+numeroString);
            numero = 0;
        }
        return numero;
    } */

   /* public static void mostrarIndiceSeleccionado(int indice){
        int indiceReal = indice-1;
        System.out.println("El producto del indice ["+indice+"] corresponde a: "+datosArchivo.get(indiceReal*2));
        System.out.println("El precio es: "+datosArchivo.get(indiceReal*2+1));

    }*/

    public static void mostrarItems(ArrayList<String> datosArchivo){
        for(int i = 0; i < datosArchivo.size(); i+=2 ){
            int indice = i/2 +1;
            System.out.println("["+indice+"] Producto: "+datosArchivo.get(i)+" Precio: "+datosArchivo.get(i+1));
        }

    }
}
