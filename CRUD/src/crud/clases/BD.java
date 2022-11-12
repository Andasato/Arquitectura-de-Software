package crud.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class BD {

    private static Connection Conection;
    private static Statement Consulta;
    private static ResultSet Resultado;
    private final String bd;
    private final String user;
    private final String password;

    public BD(String bd, String user, String password) {
        Conection = null;
        Consulta = null;
        Resultado = null;
        this.bd = bd;
        this.user = user;
        this.password = password;
    }

    public boolean conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Conection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/" + bd, user, password);
            return Conection != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void desconectar() {
        try {
            this.Conection.close();
        } catch (Exception e) {
        }
    }

    public boolean AgregarProducto(Producto mProducto) {
      try {
          Consulta = Conection.createStatement();
          Consulta.execute("INSERT INTO producto (nombre, precio, tipo, cantidad, clave) VALUES ('"+ mProducto.getNombre() +"',"+ mProducto.getPrecio() 
                  + ",'"+ mProducto.getTipo()+"',"+ mProducto.getCantidad()+",'"+ mProducto.getClave()+"')");
          return true;
      }catch(SQLException e){
          return false;
      }
    }
    
    
    public ArrayList GetProductos(){
        ArrayList Productos = new ArrayList();
        
        try {
            Consulta = Conection.createStatement();
            Resultado = Consulta.executeQuery("SELECT * FROM producto");
            while (Resultado.next()){
                Producto mProducto = new Producto();
                mProducto.setProducto_id(Resultado.getInt("producto_id"));
                mProducto.setNombre(Resultado.getString("nombre"));
                mProducto.setPrecio(Resultado.getFloat("precio"));
                mProducto.setTipo(Resultado.getString("tipo"));
                mProducto.setClave(Resultado.getString("clave"));
                mProducto.setCantidad(Resultado.getInt("cantidad"));
                Productos.add(mProducto);
            }
           
        } catch (SQLException e) {
            return null;
        }
        
        return Productos;
    }
    
    public void EliminarProsucto(int Producto_id){
        try {
          Consulta = Conection.createStatement();
          Consulta.execute("DELETE FROM producto WHERE producto_id = " + Producto_id);
      }catch(SQLException e){
      }
    
    }
    
    public boolean ModificarProducto(Producto mProducto) {
      try {
          Consulta = Conection.createStatement();
          Consulta.execute("UPDATE producto SET nombre= '"+ mProducto.getNombre() +"',"
                  + "precio = "+ mProducto.getPrecio() + ","
                  + "tipo  = '" + mProducto.getTipo()+ "',"
                  + "cantidad ="+ mProducto.getCantidad()+ ","
                  + "clave = '"+ mProducto.getClave()+ "'"
                  + " WHERE producto_id = " + mProducto.getProducto_id());
          return true;
      }catch(SQLException e){
          return false;
      }
    }
    
    
     public ArrayList Filtrado(String busqueda){
        ArrayList Productos = new ArrayList();
        
        try {
            Consulta = Conection.createStatement();
            Resultado = Consulta.executeQuery("SELECT * FROM producto WHERE producto_id LIKE " + "'%" +  busqueda +"%' or nombre LIKE " + "'%" +  busqueda +"%' "
                    + " or precio LIKE " + "'%" +  busqueda +"%' or tipo LIKE " + "'%" +  busqueda +"%' or clave LIKE " + "'%" +  busqueda +"%' or cantidad LIKE " + "'%" +  busqueda +"%'");
            while (Resultado.next()){
                Producto mProducto = new Producto();
                mProducto.setProducto_id(Resultado.getInt("producto_id"));
                mProducto.setNombre(Resultado.getString("nombre"));
                mProducto.setPrecio(Resultado.getFloat("precio"));
                mProducto.setTipo(Resultado.getString("tipo"));
                mProducto.setClave(Resultado.getString("clave"));
                mProducto.setCantidad(Resultado.getInt("cantidad"));
                Productos.add(mProducto);
            }
           
        } catch (SQLException e) {
            return null;
        }
        
        return Productos;
    }

}
