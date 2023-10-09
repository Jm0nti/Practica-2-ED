package Clases;

import Estructuras.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Mensajeria {
        private DoubleList empleados = new DoubleList();
        private DoubleList contraseñas = new DoubleList();

        public DoubleList getEmpleados(){
            return this.empleados;
        }
        
        public DoubleList getContraseñas(){
            return this.contraseñas;
        }

        public void importarEmpleados() {
        try {
            FileReader Empleados = new FileReader("Archivos/Empleados.txt");
            BufferedReader lector = new BufferedReader(Empleados);
            if (Empleados.ready()) {
                String dataAux;
                while ((dataAux = lector.readLine()) != null) {
                    String data[] = dataAux.split(" ");
                    Fecha fecha = new Fecha(Integer.valueOf(data[2]), Integer.valueOf(data[3]),
                            Integer.valueOf(data[4]));
                    Direccion direccion = new Direccion(data[8], data[9], data[10], data[11], data[12], data[13]);
                    Usuario usuario = new Usuario(data[0], Long.parseLong(data[1]), fecha, data[5],
                            Long.parseLong(data[6]), data[7], direccion);
                    empleados.addLast(usuario);
                }
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void importarContraseñas() {
        try {
            FileReader Password = new FileReader("Archivos/Password.txt");
            BufferedReader lector = new BufferedReader(Password);
            if (Password.ready()) {
                String dataAux;
                while ((dataAux = lector.readLine()) != null) {
                    String data[] = dataAux.split(" ");
                    contraseñas.addLast(data);
                }
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    

}