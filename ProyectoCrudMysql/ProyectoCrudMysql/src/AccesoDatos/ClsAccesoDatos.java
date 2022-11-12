
package AccesoDatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lennys Mina
 */
public final class ClsAccesoDatos {

    //Constantes de conexion a Base de Datos
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String URL = "jdbc:mysql://localhost:3306/db_basepruebas";

    //Variables Privadas
    private DefaultTableModel ObjDefaultTableModel;
    private Connection ObjConnection;
    private ResultSet ObjResultSet;
    private CallableStatement ObjCallableStatement;
    private ResultSetMetaData ObjResultSetMetaData;
    private String SentenciaSQL, ErrorDB, MensajeDB;
    private boolean Read;
    private ArrayList<String> LstParametros;

    //Variables Publicas
    public DefaultTableModel getObjDefaultTableModel() {
        return ObjDefaultTableModel;
    }

    public void setObjDefaultTableModel(DefaultTableModel ObjDefaultTableModel) {
        this.ObjDefaultTableModel = ObjDefaultTableModel;
    }

    public Connection getObjConnection() {
        return ObjConnection;
    }

    public void setObjConnection(Connection ObjConnection) {
        this.ObjConnection = ObjConnection;
    }

    public ResultSet getObjResultSet() {
        return ObjResultSet;
    }

    public void setObjResultSet(ResultSet ObjResultSet) {
        this.ObjResultSet = ObjResultSet;
    }

    public CallableStatement getObjCallableStatement() {
        return ObjCallableStatement;
    }

    public void setObjCallableStatement(CallableStatement ObjCallableStatement) {
        this.ObjCallableStatement = ObjCallableStatement;
    }

    public ResultSetMetaData getObjResultSetMetaData() {
        return ObjResultSetMetaData;
    }

    public void setObjResultSetMetaData(ResultSetMetaData ObjResultSetMetaData) {
        this.ObjResultSetMetaData = ObjResultSetMetaData;
    }

    public String getSentenciaSQL() {
        return SentenciaSQL;
    }

    public void setSentenciaSQL(String SentenciaSQL) {
        this.SentenciaSQL = SentenciaSQL;
    }

    public String getErrorDB() {
        return ErrorDB;
    }

    public void setErrorDB(String ErrorDB) {
        this.ErrorDB = ErrorDB;
    }

    public boolean isRead() {
        return Read;
    }

    public void setRead(boolean Read) {
        this.Read = Read;
    }

    public ArrayList<String> getLstParametros() {
        return LstParametros;
    }

    public void setLstParametros(ArrayList<String> LstParametros) {
        this.LstParametros = LstParametros;
    }

    public String getMensajeDB() {
        return MensajeDB;
    }

    public void setMensajeDB(String MensajeDB) {
        this.MensajeDB = MensajeDB;
    }

    //Constructor
    public ClsAccesoDatos() {

        setLstParametros(new ArrayList<>());

    }

    //Metodo para crear y abrir la conexion a la base de datos
    private void CrearConexion(ClsAccesoDatos ObjDataAccess) {

        try {
            Class.forName(ObjDataAccess.DRIVER);
            ObjDataAccess.setObjConnection((Connection) DriverManager.getConnection(
                    ObjDataAccess.URL,
                    ObjDataAccess.USER,
                    ObjDataAccess.PASSWORD));

        } catch (ClassNotFoundException | SQLException | NullPointerException e) {

            ObjDataAccess.setErrorDB(e.getMessage());
        }
    }

    //Metodo para cerrar la conexion a la base de datos
    private void CerrarConexion(ClsAccesoDatos ObjDataAccess) {

        try {
            if (ObjDataAccess.getErrorDB() == null) {
                if (!ObjDataAccess.getObjConnection().isClosed()) {
                    ObjDataAccess.getObjResultSet().close();
                    ObjDataAccess.getObjCallableStatement().close();
                    ObjDataAccess.getObjConnection().close();

                }
            }
        } catch (SQLException | NullPointerException e) {
            ObjDataAccess.setErrorDB(e.getMessage());
        }
    }

    //Metodo para agregar parametros el la llamada del procedimiento almacenado
    private void AgregarParametros(ClsAccesoDatos ObjDataAccess) {

        if (!ObjDataAccess.getLstParametros().isEmpty()) {

            try {
                for (String itemLista : ObjDataAccess.getLstParametros()) {

                    String[] item;
                    item = itemLista.split(";");

                    switch (item[2]) {
                        //Agregar parametro de tipo String o Varchar
                        case "1":
                            if (item[1].equals("")) {
                                ObjDataAccess.getObjCallableStatement().setNull(Integer.parseInt(item[0]), Types.INTEGER);
                            } else {
                                ObjDataAccess.getObjCallableStatement().setString(Integer.parseInt(item[0]), item[1]);
                            }
                            break;
                        //Agregar parametro de tipo boolean o bit
                        case "2":
                            ObjDataAccess.getObjCallableStatement().setBoolean(Integer.parseInt(item[0]), Boolean.parseBoolean(item[1]));
                            break;
                        //Agregar parametro de tipo tinyint
                        case "3":
                            ObjDataAccess.getObjCallableStatement().setByte(Integer.parseInt(item[0]), Byte.parseByte(item[1]));
                            break;
                        //Agregar parametro de tipo int o integer
                        case "4":
                            ObjDataAccess.getObjCallableStatement().setInt(Integer.parseInt(item[0]), Integer.parseInt(item[1]));
                            break;
                        //Agregar paramnetro de salida (out)
                        case "5":
                            ObjDataAccess.getObjCallableStatement().registerOutParameter(Integer.parseInt(item[0]), Types.VARCHAR);
                            break;
                        default:

                    }

                }
            } catch (NumberFormatException | SQLException e) {
            }
        }

    }

    //Metodo para realizar consultas y manipular los datos de la base de datos
    public void CRUD(ClsAccesoDatos ObjDataAccess) {
        try {
            CrearConexion(ObjDataAccess);
            if (ObjDataAccess.getErrorDB() == null) {
                ObjDataAccess.setObjCallableStatement(ObjDataAccess.getObjConnection().prepareCall(ObjDataAccess.getSentenciaSQL()));
                ObjDataAccess.AgregarParametros(ObjDataAccess);
                ObjDataAccess.setObjResultSet(ObjDataAccess.getObjCallableStatement().executeQuery());

                if (ObjDataAccess.isRead()) {

                    ObjDataAccess.setObjResultSetMetaData(ObjDataAccess.getObjResultSet().getMetaData());
                    // Se obtiene el número de columnas.
                    byte CantidadColumnas = (byte) ObjDataAccess.getObjResultSetMetaData().getColumnCount();
                    // Se crea un array de encabezados para rellenar
                    Object[] Encabezados;
                    Encabezados = new Object[CantidadColumnas];
                    // Se obtiene cada uno de los encabezados para cada columna
                    for (int i = 0; i < CantidadColumnas; i++) {
                        // Nuevamente, para ResultSetMetaData la primera columna es la 1.
                        Encabezados[i] = ObjDataAccess.getObjResultSetMetaData().getColumnLabel(i + 1);
                    }
                    ObjDataAccess.setObjDefaultTableModel(new DefaultTableModel());
                    ObjDataAccess.getObjDefaultTableModel().setColumnIdentifiers(Encabezados);

                    while (ObjDataAccess.getObjResultSet().next()) {

                        Object[] fila = new Object[CantidadColumnas];
                        for (int f = 0; f < CantidadColumnas; f++) {

                            if (ObjDataAccess.getObjResultSet().getObject(f + 1) != null) {
                                fila[f] = ObjDataAccess.getObjResultSet().getObject(f + 1);
                            } else {
                                fila[f] = "";
                            }

                        }
                        ObjDataAccess.getObjDefaultTableModel().addRow(fila);
                    }

                } else {

                    while (ObjDataAccess.getObjResultSet().next()) {
                        ObjDataAccess.setMensajeDB(ObjDataAccess.getObjResultSet().getString("Mensaje"));
                    }
                }

            }

        } catch (SQLException | NullPointerException e) {
            ObjDataAccess.setErrorDB(e.getMessage());
        } finally {

            CerrarConexion(ObjDataAccess);

        }
    }

}
