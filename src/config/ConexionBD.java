/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Crear una instancia estática de la clase Singleton
    //al poner static hace independite del obejeto
    private static ConexionBD instancia;
    //guarda la Conexion en la variable conexion
    private Connection conexion;
    //datos para el driverManager
    private final String URL="jdbc:mysql://localhost:3306/bdventas";
    private final String USER="root";
    private final String PASSWORD="tallarinesrojos";
    
    private ConexionBD(){
        try{
            conexion = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conexion exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    // Método público para obtener la única instancia de la clase
    //get de insatancia, el get permite solo obetener datos mas no afectarlos
    //si la variable instancia esta vacia se llama al contructor por unica ves
    //si instancia si esta llena entos solo se retorna ese valor
    
    public static synchronized ConexionBD getInstancia(){
    if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }
    //metodo para obtener conexion
    public Connection getConexion(){
        return conexion;
    }

    
}
