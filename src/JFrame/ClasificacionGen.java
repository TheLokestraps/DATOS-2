/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Clases.*;
import java.time.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TheLokestraps
 */
public class ClasificacionGen extends javax.swing.JDialog {

    /**
     * Creates new form ClasificacionGen
     */
    
    public static Nodo ptr;
    
    public ClasificacionGen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Nodo p = ptr;
        ptr = LeerGen(p,Inicio.ptrS);
        p = ptr;
        ptr = sortList(p);
        showList(ptr);
    }
    
    private Nodo LeerGen(Nodo NodoGen, ArrayList<Nodo> Nodos){
        Nodo p,q,r;
        boolean swp;
        NodoGen = null;
        System.out.println("La vuelta de inicio es "+IngresarStandingN.CorrejirD(Nodos.get(0).Time));
        for(Nodo Vuelta : Nodos){
//            if(Vuelta != null){
                if(NodoGen == null){
                    NodoGen = Copiar(Vuelta);
                }else{
                    q = NodoGen;
                    while(q != null){
                       p = Vuelta;
                       swp = false;
                       while(p != null && swp != true){
                           if(q.Player.Nombre.equals(p.Player.Nombre)){
                               Duration temp;
                               temp = q.Time;
                               q.Time = temp.plus(p.Time);
                               swp = true;
                           }else{
                                p = p.link;
                           }
                       }
                       q = q.link;
                    }
                }
                
//            }
        }
        return NodoGen;
    }
    
    
    private Nodo OrdenarPtr(Nodo ptr){
        Nodo p,actual,q;
        if(ptr!=null){
            
            p = ptr;
            while(p != null){
                actual = p.link;
                while(actual != null){
                    if(p.Time.compareTo(actual.Time)> 0){
                        q = p;
                        p.Player = actual.Player;
                        p.Time = actual.Time;
                        actual.Player = q.Player;
                        actual.Time = q.Time;
                        
                    }
                    actual = actual.link;
                }
                p = p.link;
            }
        }
        
        return ptr;
    }
    
    private Nodo sortList(Nodo head) {  
        //Node current will point to head  
        Nodo current = head, index = null;  
          
        if(head == null) {  
            return head;  
        }  
        else {  
            while(current != null) {  
                //Node index will point to node next to current  
                index = current.link;  
                  
                while(index != null) {  
                    //If current node's data is greater than index's node data, swap the data between them  
                    if(current.Time.compareTo(index.Time)>0) {
                        
                        Duration T = current.Time;
                        Corredor Player = current.Player;  
                        current.Player = index.Player;
                        current.Time = index.Time;
                        index.Time = T;
                        index.Player = Player;
                    }  
                    index = index.link;  
                }  
                current = current.link;  
            }      
        }
        return head;
    }
    
    
    
    
    
   private void showList(Nodo ptr){

        DefaultTableModel modelX = (DefaultTableModel) Tabla.getModel();
        modelX.setRowCount(0);
        Nodo p = ptr;
        Nodo antp = null;
        int i = 1;
        Object[] row = new Object[6];
        while(p!= null){
            if(p == ptr){
                row[0] = Integer.toString(i);
                row[1] = Integer.toString(p.Player.Numero);
                row[2] = p.Player.Nombre;
                row[3] = p.Player.Equipo;
                row[4] = CorrejirD(p.Time);
                modelX.addRow(row);
                antp = p;
                p = p.link;
                i++;
            }else{
                row[0] = Integer.toString(i);
                row[1] = Integer.toString(p.Player.Numero);
                row[2] = p.Player.Nombre;
                row[3] = p.Player.Equipo;
                row[4] = CorrejirD(p.Time);
                Duration Dif, Aux = p.Time;
                
                if(antp != null){
                    Dif = Aux.minus(ptr.Time);
                    row[5] = "+ "+CorrejirD(Dif);
                    antp = p;
                    p = p.link;
                    modelX.addRow(row);
                    i++;
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Dumb");
                }
            }
        }
    }
    
    private static String CorrejirD(Duration D){
        long AñadirH;
        AñadirH = 24*(D.toDaysPart());
        String AD = D.toHoursPart()+AñadirH+"H "+D.toMinutesPart()+"' "+D.toSecondsPart()+"''";
        return AD;
    }
     
  public Nodo Copiar(Nodo ptr1){
      Nodo ptr2 = null,q,Aux;
      if(ptr1 == null){
          return null;
      }else{
          Nodo p = ptr1;
          while(p!=null){
             Aux = ptr2;
             ptr2 = addCola(Aux,p.Player,p.Time);
             p = p.link;
          }
          return ptr2;
      }
  }
  
  
  Nodo addCola(Nodo ptr, Corredor Player, Duration Time){
        Nodo p =  ptr;
        Nodo q = new Nodo();
        q.Player = Player;
        q.Time = Time;
        if(ptr == null){
            ptr = q;
        }else{
            while(p.link != null){
                p = p.link;
            }
            p.link = q;
        }
        return ptr;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clasificacion General");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("  Clasificacion General");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posicion", "Numero", "Nombre", "Equipo", "Tiempo", "Diferencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClasificacionGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClasificacionGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClasificacionGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClasificacionGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClasificacionGen dialog = new ClasificacionGen(new javax.swing.JFrame(), true);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
