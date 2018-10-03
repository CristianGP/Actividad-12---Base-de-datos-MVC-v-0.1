
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ModelAgenda;
import views.ViewAgenda;

public class ControllerAgenda {

    ModelAgenda modelAgenda;
    ViewAgenda viewAgenda;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgenda.jbtn_primero) {
                try {
                    jbtn_primero_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewAgenda.jbtn_anterior) {
                try {
                    jbtn_anterior_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewAgenda.jbtn_siguiente) {
                try {
                    jbtn_siguiente_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewAgenda.jbtn_ultimo) {
                try {
                    jbtn_ultimo_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    };

    public ControllerAgenda(ModelAgenda modelAgenda, ViewAgenda viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        initComponents();
        setActionListener();
        initDB();
    }

    public void initDB(){
        modelAgenda.conectarDB();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }

    public void initComponents() {
        viewAgenda.setLocationRelativeTo(null);
        viewAgenda.setTitle("Agenda MVC");
        viewAgenda.setVisible(true);
    }


    public void setActionListener() {
        viewAgenda.jbtn_primero.addActionListener(actionListener);
        viewAgenda.jbtn_anterior.addActionListener(actionListener);
        viewAgenda.jbtn_siguiente.addActionListener(actionListener);
        viewAgenda.jbtn_ultimo.addActionListener(actionListener);
    }

 
    private void jbtn_primero_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_primero");
        modelAgenda.moverPrimerRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());

    }


    private void jbtn_anterior_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_anterior");
        modelAgenda.moverAnteriorRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }


    private void jbtn_ultimo_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_ultimo");
        modelAgenda.moverUltimoRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
 
    }
    private void jbtn_siguiente_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_siguiente");
        modelAgenda.moverSiguienteRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
       
  
    }
}
