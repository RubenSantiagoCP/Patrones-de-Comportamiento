/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.openmarket.presentation;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.service.CategoryService;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.infra.Messages;
import javax.swing.JOptionPane;
import reloj.frameworkobsobs.Observador;

/**
 *
 * @author SANTIAGO
 */
public class GUICategory extends javax.swing.JFrame implements Observador{

    /**
     * Creates new form GUICategory
     * 
     */
     private boolean addOption;
    CategoryService categoryService; 
    ProductService productService;
    public GUICategory(CategoryService categoryService, ProductService productService) {
        initComponents();
        this.categoryService = categoryService;
        this.productService = productService;
        stateInitial();
        GUIAddCategory instance1 = new GUIAddCategory(productService, categoryService);
        productService.addObservador(instance1);
        categoryService.addObservador(instance1);
        productService.notificar();
        instance1.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
     private void cleanControls() {
        txtNombreCategoria.setText("");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCategoria = new javax.swing.JTextField();
        btnCrearCategoria = new javax.swing.JButton();
        btnCerrarVentanaCategoria = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));
        jPanel1.add(txtNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 260, 30));

        btnCrearCategoria.setText("Grabar");
        btnCrearCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        btnCerrarVentanaCategoria.setText("Cerrar");
        btnCerrarVentanaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarVentanaCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrarVentanaCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, -1, -1));

        jLabel2.setText("Id*:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 62, 260, 30));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        btnFind.setText("Buscar");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        jPanel1.add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addCategory() {
        String name = txtNombreCategoria.getText().trim();
        
        if (categoryService.saveCategory(name)) {
            Messages.showMessageDialog("Se grabó con éxito", "Atención");
            cleanControls();
        } else {
            Messages.showMessageDialog("Error al grabar, lo siento mucho", "Atención");
        }
   
    }
    private void btnCrearCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCategoriaActionPerformed
         if (txtNombreCategoria.getText().trim().equals("")) {
            Messages.showMessageDialog("Debe ingresar el nombre de la categoria", "Atención");
            txtNombreCategoria.requestFocus();
            return;
        }
        if (addOption) {
            //Agregar
            addCategory();
        } else {
            //Editar
            editCategory();
        }
    }//GEN-LAST:event_btnCrearCategoriaActionPerformed

    private void btnCerrarVentanaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarVentanaCategoriaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarVentanaCategoriaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        stateInitial();
        cleanControls();
        txtId.setVisible(true);
        jLabel1.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String id = txtId.getText().trim();
        if (id.equals("")) {
            Messages.showMessageDialog("Debe buscar la categoria a eliminar", "Atención");
            txtId.requestFocus();
            return;
        }
        Long cat_id = Long.parseLong(id);
        if (Messages.showConfirmDialog("Está seguro que desea eliminar esta categoria?", "Confirmación") == JOptionPane.YES_NO_OPTION) {
            if (categoryService.deleteCategory(cat_id)) {
                Messages.showMessageDialog("Categoria eliminada con éxito", "Atención");
                stateInitial();
                cleanControls();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        GUICategoryFind instance = new GUICategoryFind(categoryService);
        instance.setVisible(true);
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        stateNew();
        txtNombreCategoria.requestFocus();
        addOption = true;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        addOption = false;
        stateEdit();
        txtId.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
         if (txtId.getText().trim().equals("")) {
            return;
        }
        Long cat_id = Long.parseLong(txtId.getText());
        Category prod = categoryService.findCategoryById(cat_id);
        if (prod == null) {
            Messages.showMessageDialog("El identificador de la categoria no existe", "Error");
            txtId.setText("");
            txtId.requestFocus();
        } else {
            txtNombreCategoria.setText(prod.getName());
        }
    }//GEN-LAST:event_txtIdFocusLost
  
    
    private void stateEdit() {
        btnNuevo.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(true);
        btnCancelar.setVisible(true);
        btnCerrarVentanaCategoria.setVisible(false);
        btnCrearCategoria.setVisible(true);
        btnFind.setVisible(false);
        txtId.setEnabled(true);
        txtNombreCategoria.setEnabled(true);
    }
    
    private void stateInitial() {
        btnNuevo.setVisible(true);
        btnEditar.setVisible(true);
        btnEliminar.setVisible(false);
        btnCancelar.setVisible(false);
        btnCerrarVentanaCategoria.setVisible(true);
        btnCrearCategoria.setVisible(false);
        btnFind.setVisible(true);
        txtId.setEnabled(false);
        txtNombreCategoria.setEnabled(false);

    }
    
     private void stateNew() {
        btnNuevo.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(false);
        btnCancelar.setVisible(true);
        btnCerrarVentanaCategoria.setVisible(false);
        btnCrearCategoria.setVisible(true);
        btnFind.setVisible(false);
        txtId.setEnabled(false);
        txtNombreCategoria.setEnabled(true);
    }
    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarVentanaCategoria;
    private javax.swing.JButton btnCrearCategoria;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables

    private void editCategory() {
         String id = txtId.getText();
        if (id.equals("")) {
            Messages.showMessageDialog("Debe buscar la categoria a editar", "Atención");
            txtId.requestFocus();
            return;
        }
        Long cat_id = Long.parseLong(id);
        Category cat = new Category();
        cat.setName(txtNombreCategoria.getText().trim());

        if (categoryService.editCategory(cat_id, cat)) {
            Messages.showMessageDialog("Se editó con éxito", "Atención");
            cleanControls();
            stateInitial();
        } else {
            Messages.showMessageDialog("Error al editar, lo siento mucho", "Atención");
        }
     }

    @Override
    public void actualizar() {
        System.out.println("co.edu.unicauca.openmarket.presentation.GUICategory.actualizar()");
    }
}
