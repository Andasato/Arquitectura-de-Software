package crud;

import crud.clases.BD;
import crud.clases.Icono;
import crud.clases.Producto;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ProductoFrm extends javax.swing.JFrame {

    BD mBD;
    DefaultTableModel ModeloTabla;

    private String agregar_icono_ruta = "/iconos/agregar.png";
    private String eliminar_icono_ruta = "/iconos/eliminar.png";
    private String modificar_icono_ruta = "/iconos/modificar.png";
    private String busqueda_icono_ruta = "/iconos/busqueda.png";

    /**
     * Creates new form AlrtaProductoFrm
     */
    public ProductoFrm() {
        initComponents();
        LoadIcons();
        mBD = new BD("productos", "root", "");
        ModeloTabla = new DefaultTableModel();
        ModeloTabla.addColumn("Id del producto");
        ModeloTabla.addColumn("Nombre");
        ModeloTabla.addColumn("Precio");
        ModeloTabla.addColumn("Tipo de producto");
        ModeloTabla.addColumn("Clave del producto");
        ModeloTabla.addColumn("Cantidad en inventario");
        CargarProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPrecio3 = new javax.swing.JTextField();
        pnlPassword3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlAgregar = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        pnlEliminar = new javax.swing.JPanel();
        pnlModificar = new javax.swing.JPanel();
        edtBusqueda = new javax.swing.JTextField();
        pnlBusqueda = new javax.swing.JPanel();

        pnlPassword3.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout pnlPassword3Layout = new javax.swing.GroupLayout(pnlPassword3);
        pnlPassword3.setLayout(pnlPassword3Layout);
        pnlPassword3Layout.setHorizontalGroup(
            pnlPassword3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        pnlPassword3Layout.setVerticalGroup(
            pnlPassword3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(86, 168, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 450));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos");

        pnlAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlAgregarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnlAgregarLayout = new javax.swing.GroupLayout(pnlAgregar);
        pnlAgregar.setLayout(pnlAgregarLayout);
        pnlAgregarLayout.setHorizontalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );
        pnlAgregarLayout.setVerticalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio");

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Clave");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cantidad");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        pnlEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlEliminarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnlEliminarLayout = new javax.swing.GroupLayout(pnlEliminar);
        pnlEliminar.setLayout(pnlEliminarLayout);
        pnlEliminarLayout.setHorizontalGroup(
            pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );
        pnlEliminarLayout.setVerticalGroup(
            pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        pnlModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlModificarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnlModificarLayout = new javax.swing.GroupLayout(pnlModificar);
        pnlModificar.setLayout(pnlModificarLayout);
        pnlModificarLayout.setHorizontalGroup(
            pnlModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );
        pnlModificarLayout.setVerticalGroup(
            pnlModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        edtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtBusquedaActionPerformed(evt);
            }
        });
        edtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtBusquedaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlBusquedaLayout = new javax.swing.GroupLayout(pnlBusqueda);
        pnlBusqueda.setLayout(pnlBusquedaLayout);
        pnlBusquedaLayout.setHorizontalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
        pnlBusquedaLayout.setVerticalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(txtTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre)
                            .addComponent(txtPrecio)
                            .addComponent(jLabel6)
                            .addComponent(txtClave)
                            .addComponent(jLabel8)
                            .addComponent(txtCantidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(pnlEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(pnlModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(edtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edtBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addGap(13, 13, 13)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(13, 13, 13)
                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(13, 13, 13)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1273, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void LoadIcons() {
        Icono imgAgregar = new Icono(pnlAgregar, agregar_icono_ruta);
        pnlAgregar.add(imgAgregar).repaint();
        pnlAgregar.setOpaque(false);
        pnlAgregar.setBorder(null);
        pnlAgregar.setBackground(new Color(0, 0, 0, 64));
        
        Icono imgEliminar = new Icono(pnlEliminar, eliminar_icono_ruta);
        pnlEliminar.add(imgEliminar).repaint();
        pnlEliminar.setOpaque(false);
        pnlEliminar.setBorder(null);
        pnlEliminar.setBackground(new Color(0, 0, 0, 64));
        
        Icono imgModificar = new Icono(pnlModificar, modificar_icono_ruta);
        pnlModificar.add(imgModificar).repaint();
        pnlModificar.setOpaque(false);
        pnlModificar.setBorder(null);
        pnlModificar.setBackground(new Color(0, 0, 0, 64));
        
         Icono imgBusqueda = new Icono(pnlBusqueda, busqueda_icono_ruta);
        pnlBusqueda.add(imgBusqueda).repaint();
        pnlBusqueda.setOpaque(false);
        pnlBusqueda.setBorder(null);
        pnlBusqueda.setBackground(new Color(0, 0, 0, 64));
    }

    private void Limpiar() {
        for (int i = 0; i < tblProductos.getRowCount(); i++) {
            ModeloTabla.removeRow(i);
            i -= 1;
        }

    }

    private void CargarProductos() {
        ArrayList Productos;
        Producto mProducto;
        if (mBD.conectar()) {
            String[] Datos = new String[6];
            Productos = mBD.GetProductos();
            if (Productos != null) {
                for (int i = 0; i < Productos.size(); i++) {
                    mProducto = (Producto) Productos.get(i);
                    Datos[0] = String.valueOf(mProducto.getProducto_id());
                    Datos[1] = mProducto.getNombre();
                    Datos[2] = String.valueOf(mProducto.getPrecio());
                    Datos[3] = mProducto.getTipo();
                    Datos[4] = mProducto.getClave();
                    Datos[5] = String.valueOf(mProducto.getCantidad());
                    ModeloTabla.addRow(Datos);
                }
                
                this.tblProductos.setModel(ModeloTabla);
                this.tblProductos.getColumnModel().getColumn(0).setPreferredWidth(50);
                this.tblProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
                this.tblProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
                this.tblProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
                this.tblProductos.getColumnModel().getColumn(4).setPreferredWidth(50);
                this.tblProductos.getColumnModel().getColumn(5).setPreferredWidth(50);
                
                if (this.tblProductos.getRowCount() > 0) {
                    this.tblProductos.setRowSelectionInterval(0,0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al recuperar los productos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

    }
    
     private void Filtrado(String busqueda) {
        ArrayList Productos;
        Producto mProducto;
        if (mBD.conectar()) {
            String[] Datos = new String[6];
            Productos = mBD.Filtrado(busqueda); 
            if (Productos != null) {
                for (int i = 0; i < Productos.size(); i++) {
                    mProducto = (Producto) Productos.get(i);
                    Datos[0] = String.valueOf(mProducto.getProducto_id());
                    Datos[1] = mProducto.getNombre();
                    Datos[2] = String.valueOf(mProducto.getPrecio());
                    Datos[3] = mProducto.getTipo();
                    Datos[4] = mProducto.getClave();
                    Datos[5] = String.valueOf(mProducto.getCantidad());
                    ModeloTabla.addRow(Datos);
                }
                
                this.tblProductos.setModel(ModeloTabla);
                this.tblProductos.getColumnModel().getColumn(0).setPreferredWidth(50);
                this.tblProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
                this.tblProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
                this.tblProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
                this.tblProductos.getColumnModel().getColumn(4).setPreferredWidth(50);
                this.tblProductos.getColumnModel().getColumn(5).setPreferredWidth(50);
                
                if (this.tblProductos.getRowCount() > 0) {
                    this.tblProductos.setRowSelectionInterval(0,0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al recuperar los productos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

    }
    


    private void pnlAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAgregarMouseClicked
        Producto mProducto = new Producto();
        if (!txtNombre.getText().trim().equals("") && !txtPrecio.getText().trim().equals("")
                && !txtTipo.getText().trim().equals("") && !txtCantidad.getText().trim().equals("")
                && !txtClave.getText().trim().equals("")) {
            if (mBD.conectar()) {
                mProducto.setNombre(txtNombre.getText().trim());
                mProducto.setPrecio(Float.parseFloat(txtPrecio.getText().trim()));
                mProducto.setCantidad(Integer.parseInt(txtCantidad.getText().trim()));
                mProducto.setTipo(txtTipo.getText().trim());
                mProducto.setClave(txtClave.getText().trim());
                if (mBD.AgregarProducto(mProducto)) {
                    Limpiar();
                    CargarProductos();
                    txtNombre.setText("");
                    txtPrecio.setText("");
                    txtTipo.setText("");
                    txtCantidad.setText("");
                    txtClave.setText("");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Error al conectar a dar de alta el producto");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al conectar a BD");
            }
        }
    }//GEN-LAST:event_pnlAgregarMouseClicked

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter != '.' || txtPrecio.getText().contains("."))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void pnlAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAgregarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlAgregarMouseEntered

    private void pnlEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEliminarMouseClicked
        int producto_id = 0;
        if (tblProductos.getSelectedRow() != -1) {
            producto_id = Integer.parseInt(ModeloTabla.getValueAt(tblProductos.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(rootPane, "¿Desea eliminar este producto?", "Eliminar producto", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (mBD.conectar()) {
                    mBD.EliminarProsucto(producto_id);
                    Limpiar();
                    CargarProductos();
                }
            }
        }
    }//GEN-LAST:event_pnlEliminarMouseClicked

    private void pnlEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEliminarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlEliminarMouseEntered

    private void pnlModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlModificarMouseClicked
        int producto_id = 0;
         if (tblProductos.getSelectedRow() != -1) {
            producto_id = Integer.parseInt(ModeloTabla.getValueAt(tblProductos.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(rootPane, "¿Desea modificar este producto?", "Modificación de producto", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                if (mBD.conectar()) {
                    Producto mProducto = new Producto();
                    mProducto.setProducto_id(producto_id);
                    mProducto.setNombre(txtNombre.getText().trim());
                    mProducto.setPrecio(Float.parseFloat(txtPrecio.getText().trim()));
                    mProducto.setTipo(txtTipo.getText().trim());
                    mProducto.setClave(txtClave.getText().trim());
                    mProducto.setCantidad(Integer.parseInt(txtCantidad.getText().trim()));
                    mBD.ModificarProducto(mProducto);
                    Limpiar();
                    CargarProductos();
                }
            }
         }
    }//GEN-LAST:event_pnlModificarMouseClicked

    private void pnlModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlModificarMouseEntered
     
    }//GEN-LAST:event_pnlModificarMouseEntered

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        txtNombre.setText(ModeloTabla.getValueAt(tblProductos.getSelectedRow(), 1).toString());
        txtPrecio.setText(ModeloTabla.getValueAt(tblProductos.getSelectedRow(), 2).toString());
        txtTipo.setText(ModeloTabla.getValueAt(tblProductos.getSelectedRow(), 3).toString());
        txtClave.setText(ModeloTabla.getValueAt(tblProductos.getSelectedRow(), 4).toString());
        txtCantidad.setText(ModeloTabla.getValueAt(tblProductos.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tblProductosMouseClicked

    private void edtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtBusquedaActionPerformed

    private void edtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtBusquedaKeyTyped
      
    }//GEN-LAST:event_edtBusquedaKeyTyped

    private void edtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtBusquedaKeyPressed
            // TODO add your handling code here:
    }//GEN-LAST:event_edtBusquedaKeyPressed

    private void edtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtBusquedaKeyReleased
        Limpiar();
        Filtrado(edtBusqueda.getText().trim());
    }//GEN-LAST:event_edtBusquedaKeyReleased

    
    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductoFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edtBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlAgregar;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlEliminar;
    private javax.swing.JPanel pnlModificar;
    private javax.swing.JPanel pnlPassword3;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecio3;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

}
