/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConexionBD;
import modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conexion;
    public UsuarioDAO(){
        conexion = ConexionBD.getInstancia().getConexion();
    }
    //CRUD
    //1.- CREATE
    public void crearUsuario(Usuario iusuario){
        String sql ="INSERT INTO Usuarios (nombre, correo, password) VALUES(?,?,?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql))
        {
            ps.setString(1,iusuario.getNombre());
            ps.setString(2,iusuario.getCorreo());
            ps.setString(3,iusuario.getPassword());
            ps.executeUpdate();
            
           
        }catch(SQLException e){
                e.printStackTrace();
       }
    }
    // PARTE DEL READ
    public List<Usuario> listarUsuarios(){
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)){       
             
            while (rs.next()){
                Usuario u = new Usuario(
               rs.getInt("id"),
               rs.getString("nombre"),
               rs.getString("correo"),
               rs.getString("password")
            );
            lista.add(u);
        }
        }catch(SQLException e){
            e.printStackTrace();
    
        }
        return lista;
    
    }   
    //Actulizacion de datos (UPDATE)
    public void actualizarUsuario(Usuario user){
       
        
        String sql="UPDATE Usuarios SET correo = ?, nombre = ?, password = ? WHERE id = ?";
        try(PreparedStatement ps= conexion.prepareStatement(sql)) {
            ps.setString(1,user.getCorreo());
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());
            int filas=ps.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Eliminar datos uwu (DELETE)
    public void eliminarUsuarios(int id){
        String sql= "DELETE FROM Usuarios WHERE id = ?";
        try(PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //FIN DEL CRUD

   //BUSCAR USUARIO EXISTENTE
    
    /*PreparedStatement: Envia comandos sql al bd y que se ejecuten de ese lado nada mas*/
    /*Resultset: obtiene los datos de una ejecicion (ps) y los guarda con un comando rs.get"TIPODATO"*/
   public boolean existeUsuarioPorId(int id){
       String sql="SELECT id FROM Usuarios WHERE id = ?";
        /*prepara el envio de string sql para su ejecucion en bd*/
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, id);
            /*resultset obtiene los resultados de ps*/
            ResultSet rs = ps.executeQuery();
            /*rs tiene que empezar a caminar para opntemer los datos*/
            /*como solo tiene un dato conque halla dado uno solo basta y sobra*/
            /*rs.next es boolean*/
            return rs.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
   }

}

   