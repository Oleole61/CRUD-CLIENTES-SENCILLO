
package Verificaciones;


import dao.UsuarioDAO;

import java.util.List;
import modelo.Usuario;
public class usuarioServicios {
    private UsuarioDAO dao;

    public usuarioServicios(UsuarioDAO dao) {
        this.dao = dao;
    }

    
    public boolean verificacionCreacionUser(Usuario user){
        if(!(verificacionesgenerales(user))){
            return false;
        }
        return true;
    }
    
    public boolean verficacionesUpdate(Usuario user){
        if(!(dao.existeUsuarioPorId(user.getId()))){
            
            return false;
        }
        
        if(!(verificacionesgenerales(user))){
            return false;
        }
        
        return true;
    }
    
    public boolean verificacionesDelete(int id){
        if(!(dao.existeUsuarioPorId(id))){
            return false;
        }
        return true;
    }
    
    /*VERIFICACIONES PRIVADAS*/
    
    /*PreparedStatement: Envia comandos sql al bd y que se ejecuten de ese lado nada mas*/
    /*Resultset: obtiene los datos de una ejecicion (ps) y los guarda con un comando rs.get"TIPODATO"*/
    
   
    
    private boolean verificacionesgenerales(Usuario user){
        /*/////////////////////////////////////////////////*/
        /*Verifivacion para saber si un campo esta vacio*/
        /*/////////////////////////////////////////////////*/
        
        if(user.getCorreo()== null || user.getCorreo().isEmpty()){
            System.out.println("Datos de gmail vacios");
            return false;
        }
        
        if(user.getNombre()== null || user.getNombre().isEmpty()){
            System.out.println("Datos de nombre vacios");
            return false;
        }
         
         if(user.getPassword()== null || user.getPassword().isEmpty()){
            System.out.println("Datos de password vacios");
            return false;
        }
         
         /*/////////////////////////////////////////////////////////////////*/
        /*Verifivacion para saber si un campo no tiene los datos adecuados*/
        /*/////////////////////////////////////////////////////////////////////*/
        
        if(!(user.getCorreo().contains("@")&& user.getCorreo().contains("."))){
            System.out.println("No es un correo electronico");
            return false;
        }
        
        return true;
    }
}
