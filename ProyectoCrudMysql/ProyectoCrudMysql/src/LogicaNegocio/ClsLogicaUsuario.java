
package LogicaNegocio;

import AccesoDatos.ClsAccesoDatos;
import Entidades.ClsUsuario;
import java.time.LocalDate;

/**
 *
 * @author Lennys Mina
 */
public class ClsLogicaUsuario {

    private ClsAccesoDatos ObjAccesoDatos;

    public void Index(ClsUsuario ObjUsuario) {
        try {
            ObjAccesoDatos = new ClsAccesoDatos();
            ObjAccesoDatos.setSentenciaSQL("{CALL SP_Usuarios_Index}");
            ObjAccesoDatos.setRead(true);
            EjecutarCRUD(ObjUsuario);

        } catch (Exception e) {

            ObjUsuario.setError(e.getMessage());
        }
    }

    public void Create(ClsUsuario ObjUsuario) {

        try {
            ObjAccesoDatos = new ClsAccesoDatos();
            ObjAccesoDatos.setRead(false);
            ObjAccesoDatos.setSentenciaSQL("{CALL SP_Usuarios_Create(?,?,?,?,?,?,?,?)}");
            ObjAccesoDatos.getLstParametros().add("1;" + ObjUsuario.getNombre() + ";1");
            ObjAccesoDatos.getLstParametros().add("2;" + ObjUsuario.getApellido1() + ";1");
            ObjAccesoDatos.getLstParametros().add("3;" + ObjUsuario.getApellido2() + ";1");
            ObjAccesoDatos.getLstParametros().add("4;" + ObjUsuario.getFechaNacimiento() + ";1");
            ObjAccesoDatos.getLstParametros().add("5;" + ObjUsuario.getEmail() + ";1");
            ObjAccesoDatos.getLstParametros().add("6;" + ObjUsuario.getUsuario() + ";1");
            ObjAccesoDatos.getLstParametros().add("7;" + ObjUsuario.getPass() + ";1");
            ObjAccesoDatos.getLstParametros().add("8;" + ObjUsuario.isEstado() + ";2");

            EjecutarCRUD(ObjUsuario);

        } catch (Exception e) {
            ObjUsuario.setError(e.getMessage());
        }

    }

    public void Read(ClsUsuario ObjUsuario) {
        try {
            ObjAccesoDatos = new ClsAccesoDatos();
            ObjAccesoDatos.setSentenciaSQL("{CALL SP_Usuarios_Read(?)}");
            ObjAccesoDatos.setRead(true);
            ObjAccesoDatos.getLstParametros().add("1;" + ObjUsuario.getIdUsuario() + ";4");
            EjecutarCRUD(ObjUsuario);

        } catch (Exception e) {

            ObjUsuario.setError(e.getMessage());
        }
    }

    public void Update(ClsUsuario ObjUsuario) {

        try {
            ObjAccesoDatos = new ClsAccesoDatos();
            ObjAccesoDatos.setRead(false);
            ObjAccesoDatos.setSentenciaSQL("{CALL SP_Usuarios_Update(?,?,?,?,?,?,?,?,?)}");
            ObjAccesoDatos.getLstParametros().add("1;" + ObjUsuario.getIdUsuario() + ";4");
            ObjAccesoDatos.getLstParametros().add("2;" + ObjUsuario.getNombre() + ";1");
            ObjAccesoDatos.getLstParametros().add("3;" + ObjUsuario.getApellido1() + ";1");
            ObjAccesoDatos.getLstParametros().add("4;" + ObjUsuario.getApellido2() + ";1");
            ObjAccesoDatos.getLstParametros().add("5;" + ObjUsuario.getFechaNacimiento() + ";1");
            ObjAccesoDatos.getLstParametros().add("6;" + ObjUsuario.getEmail() + ";1");
            ObjAccesoDatos.getLstParametros().add("7;" + ObjUsuario.getUsuario() + ";1");
            ObjAccesoDatos.getLstParametros().add("8;" + ObjUsuario.getPass() + ";1");
            ObjAccesoDatos.getLstParametros().add("9;" + ObjUsuario.isEstado() + ";2");

            EjecutarCRUD(ObjUsuario);

        } catch (Exception e) {
            ObjUsuario.setError(e.getMessage());
        }

    }

    public void Delete(ClsUsuario ObjUsuario) {

        try {
            ObjAccesoDatos = new ClsAccesoDatos();
            ObjAccesoDatos.setRead(false);
            ObjAccesoDatos.setSentenciaSQL("{CALL SP_Usuarios_Delete(?)}");
            ObjAccesoDatos.getLstParametros().add("1;" + ObjUsuario.getIdUsuario() + ";4");

            EjecutarCRUD(ObjUsuario);

        } catch (Exception e) {
            ObjUsuario.setError(e.getMessage());
        }

    }

    private void EjecutarCRUD(ClsUsuario ObjUsuario) {
        ObjAccesoDatos.CRUD(ObjAccesoDatos);
        if (ObjAccesoDatos.getErrorDB() == null) {
            if (ObjAccesoDatos.isRead()) {
                try {

                    ObjUsuario.setObjDefaultTableModel(ObjAccesoDatos.getObjDefaultTableModel());
                    if (ObjUsuario.getObjDefaultTableModel().getRowCount() == 1) {

                        for (int i = 0; i < ObjUsuario.getObjDefaultTableModel().getRowCount(); i++) {
                            ObjUsuario.setIdUsuario(Integer.parseInt(ObjUsuario.getObjDefaultTableModel().getValueAt(i, 0).toString()));
                            ObjUsuario.setNombre(ObjUsuario.getObjDefaultTableModel().getValueAt(i, 1).toString());
                            ObjUsuario.setApellido1(ObjUsuario.getObjDefaultTableModel().getValueAt(i, 2).toString());
                            ObjUsuario.setApellido2(ObjUsuario.getObjDefaultTableModel().getValueAt(i, 3).toString());
                            ObjUsuario.setFechaNacimiento(LocalDate.parse(ObjUsuario.getObjDefaultTableModel().getValueAt(i, 4).toString()));
                            ObjUsuario.setEmail(ObjUsuario.getObjDefaultTableModel().getValueAt(i, 5).toString());
                            ObjUsuario.setUsuario(ObjUsuario.getObjDefaultTableModel().getValueAt(i, 6).toString());
                            ObjUsuario.setPass(ObjUsuario.getObjDefaultTableModel().getValueAt(i, 7).toString());
                            if (ObjUsuario.getObjDefaultTableModel().getValueAt(i, 9).toString().equals("1")) {
                                ObjUsuario.setEstado(true);
                            } else {
                                ObjUsuario.setEstado(false);
                            }
                        }

                    }

                } catch (Exception e) {
                    ObjUsuario.setError(e.getMessage());
                }
            } else {
                ObjUsuario.setMensaje(ObjAccesoDatos.getMensajeDB());
            }

        } else {
            ObjUsuario.setError(ObjAccesoDatos.getErrorDB());
        }
    }

}
