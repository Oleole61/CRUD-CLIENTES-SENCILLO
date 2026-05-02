/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package singleton_bd;

import dao.UsuarioDAO;
import java.util.List;
import modelo.Usuario;
public class Singleton_BD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       UsuarioDAO dao = new UsuarioDAO();
       Usuario nuevo = new Usuario("Betty Perez","jimenez@gmail.com","123");
       dao.crearUsuario(nuevo);
       dao.actualizarUsuario(5, "Condorcanqui@gmail.com", "Condor Canqui", "Papa");
        List<Usuario> usuarios = dao.listarUsuarios();
        for(Usuario u : usuarios){
            System.out.println(u.getId()+" - "+u.getNombre());
        }
       
    }
    
}
