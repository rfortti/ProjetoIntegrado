/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Model.Pedido;
import Controller.PedidoDAO;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilitarios.AceitaStrings;
import utilitarios.LimitarLetras;

/**
 *
 * @author Multas
 */
public class FormConsultaVenda extends javax.swing.JFrame 
{

    private PedidoDAO pedidoDAO;
    
    private void preencheTabela()
    {
        lblSituacao.setVisible(false);
        
            ArrayList<Pedido> pedido = new ArrayList<Pedido>();
            pedido = this.pedidoDAO.getPedidoByItemA();
        
            DefaultTableModel tabela = (DefaultTableModel) tblVendas.getModel();
            tabela.setNumRows(0);
            
        for (Pedido ped : pedido) 
        {
            if (ped != null) 
            {
                Object[] obj = new Object[]{
                    ped.getPedItem(),
                    ped.getPedProduto(),
                    ped.getPedQtde(),
                    ped.getPedVtotal(),
                    ped.getPedPgto(),
                    ped.getPedCliente(),
                    ped.getPedData(),
                    ped.getPedSituacao(),
                    ped.getPedFunc()
                };
                tabela.addRow(obj);
            }
        }                   
    }
    /**
     * Creates new form FormConsultaVenda
     */
    public FormConsultaVenda() 
    {
        initComponents();
        this.pedidoDAO = new PedidoDAO();
        preencheTabela();
        
        txtPCliente.setDocument(new AceitaStrings());
        txtPCliente.setDocument(new LimitarLetras(50));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoOrdenar = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbProduto = new javax.swing.JRadioButton();
        rbPgto = new javax.swing.JRadioButton();
        rbData = new javax.swing.JRadioButton();
        rbFunc = new javax.swing.JRadioButton();
        rbPago = new javax.swing.JRadioButton();
        rbAberto = new javax.swing.JRadioButton();
        lblCliente = new javax.swing.JLabel();
        txtPCliente = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnBaixa = new javax.swing.JButton();
        lblSituacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        txtVTotal = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".: Consulta Vendas :.");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta:"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar por:"));

        rbProduto.setText("Produto");
        rbProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbProdutoMouseClicked(evt);
            }
        });

        rbPgto.setText("Tipo Pgto");
        rbPgto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbPgtoMouseClicked(evt);
            }
        });

        rbData.setText("Data");
        rbData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbDataMouseClicked(evt);
            }
        });

        rbFunc.setText("Funcionário");
        rbFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbFuncMouseClicked(evt);
            }
        });

        rbPago.setText("Pago");
        rbPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbPagoMouseClicked(evt);
            }
        });

        rbAberto.setText("em Aberto");
        rbAberto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbAbertoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbData)
                    .addComponent(rbProduto)
                    .addComponent(rbPago))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbFunc)
                    .addComponent(rbPgto)
                    .addComponent(rbAberto))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbProduto)
                    .addComponent(rbPgto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbData)
                    .addComponent(rbFunc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPago)
                    .addComponent(rbAberto)))
        );

        lblCliente.setText("Cliente:");

        txtPCliente.setBackground(new java.awt.Color(255, 255, 204));
        txtPCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPClienteKeyPressed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseClicked(evt);
            }
        });
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnBaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirm.png"))); // NOI18N
        btnBaixa.setText("Dar Baixa");
        btnBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaixaActionPerformed(evt);
            }
        });

        lblSituacao.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btnBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(txtPCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSituacao))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Produto", "Qtde", "Valor Total", "Tipo Pgto", "Cliente", "Data", "Situação", "Funcionário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendas);
        if (tblVendas.getColumnModel().getColumnCount() > 0) {
            tblVendas.getColumnModel().getColumn(0).setResizable(false);
            tblVendas.getColumnModel().getColumn(1).setResizable(false);
            tblVendas.getColumnModel().getColumn(2).setResizable(false);
            tblVendas.getColumnModel().getColumn(3).setResizable(false);
            tblVendas.getColumnModel().getColumn(4).setResizable(false);
            tblVendas.getColumnModel().getColumn(5).setResizable(false);
            tblVendas.getColumnModel().getColumn(6).setResizable(false);
            tblVendas.getColumnModel().getColumn(7).setResizable(false);
            tblVendas.getColumnModel().getColumn(8).setResizable(false);
        }

        txtVTotal.setEditable(false);
        txtVTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtVTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblTotal.setText("Valor Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       grupoOrdenar.add(rbProduto);
       grupoOrdenar.add(rbPgto);
       grupoOrdenar.add(rbData);
       grupoOrdenar.add(rbFunc);
       grupoOrdenar.add(rbAberto);
       grupoOrdenar.add(rbPago);
       //rbProduto.setSelected(true);// inicia selecionado
       somarColunaTotal();
       txtPCliente.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void rbProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbProdutoMouseClicked
        // TODO add your handling code here:
        if (rbProduto.isSelected())
        {
            ArrayList<Pedido> pedido = new ArrayList<Pedido>();
            pedido = this.pedidoDAO.getPedidoByProduto();
            
            DefaultTableModel tabela = (DefaultTableModel)tblVendas.getModel();
            tabela.setNumRows(0);
            
            for (Pedido ped : pedido) 
            {
            if (ped != null) 
            {
                Object[] obj = new Object[]{
                    ped.getPedItem(),
                    ped.getPedProduto(),
                    ped.getPedQtde(),
                    ped.getPedVtotal(),
                    ped.getPedPgto(),
                    ped.getPedCliente(),
                    ped.getPedData(),
                    ped.getPedSituacao(),
                    ped.getPedFunc()
                };
                tabela.addRow(obj);
            }
            } 
            txtVTotal.setText("");
        }
    }//GEN-LAST:event_rbProdutoMouseClicked

    private void rbPgtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbPgtoMouseClicked
        // TODO add your handling code here:
        if (rbPgto.isSelected())
        {
            ArrayList<Pedido> pedido = new ArrayList<Pedido>();
            pedido = this.pedidoDAO.getPedidoByPgto();
            
            DefaultTableModel tabela = (DefaultTableModel)tblVendas.getModel();
            tabela.setNumRows(0);
            
            for (Pedido ped : pedido) 
            {
            if (ped != null) 
            {
                Object[] obj = new Object[]{
                    ped.getPedItem(),
                    ped.getPedProduto(),
                    ped.getPedQtde(),
                    ped.getPedVtotal(),
                    ped.getPedPgto(),
                    ped.getPedCliente(),
                    ped.getPedData(),
                    ped.getPedSituacao(),
                    ped.getPedFunc()
                };
                tabela.addRow(obj);
            }
            } 
            txtVTotal.setText("");
        }
    }//GEN-LAST:event_rbPgtoMouseClicked

    private void rbDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbDataMouseClicked
        // TODO add your handling code here:
        if (rbData.isSelected())
        {
            ArrayList<Pedido> pedido = new ArrayList<Pedido>();
            pedido = this.pedidoDAO.getPedidoByData();
            
            DefaultTableModel tabela = (DefaultTableModel)tblVendas.getModel();
            tabela.setNumRows(0);
            
            for (Pedido ped : pedido) 
            {
            if (ped != null) 
            {
                Object[] obj = new Object[]{
                    ped.getPedItem(),
                    ped.getPedProduto(),
                    ped.getPedQtde(),
                    ped.getPedVtotal(),
                    ped.getPedPgto(),
                    ped.getPedCliente(),
                    ped.getPedData(),
                    ped.getPedSituacao(),
                    ped.getPedFunc()
                };
                tabela.addRow(obj);
            }
            }  
            txtVTotal.setText("");
        }
    }//GEN-LAST:event_rbDataMouseClicked

    private void rbFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbFuncMouseClicked
        // TODO add your handling code here:
        if (rbFunc.isSelected())
        {
            ArrayList<Pedido> pedido = new ArrayList<Pedido>();
            pedido = this.pedidoDAO.getPedidoByFunc();
            
            DefaultTableModel tabela = (DefaultTableModel)tblVendas.getModel();
            tabela.setNumRows(0);
            
            for (Pedido ped : pedido) 
            {
            if (ped != null) 
            {
                Object[] obj = new Object[]{
                    ped.getPedItem(),
                    ped.getPedProduto(),
                    ped.getPedQtde(),
                    ped.getPedVtotal(),
                    ped.getPedPgto(),
                    ped.getPedCliente(),
                    ped.getPedData(),
                    ped.getPedSituacao(),
                    ped.getPedFunc()
                };
                tabela.addRow(obj);
            }
            }
            txtVTotal.setText("");
        }
    }//GEN-LAST:event_rbFuncMouseClicked

    private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        grupoOrdenar.clearSelection();
        
        if(txtPCliente.getText() == "")
        {
            preencheTabela();
        }
        else
        {
            ArrayList<Pedido> pedido = new ArrayList<Pedido>();
            pedido = this.pedidoDAO.getPedidoByCliente(txtPCliente.getText());
                      
            DefaultTableModel tabela = (DefaultTableModel) tblVendas.getModel();
            tabela.setNumRows(0);
                                   
            for (Pedido p : pedido) 
            {
                if (p != null) 
                {
                    Object[] obj = new Object[]{
                    p.getPedItem(),
                    p.getPedProduto(),
                    p.getPedQtde(),
                    p.getPedVtotal(),
                    p.getPedPgto(),
                    p.getPedCliente(),
                    p.getPedData(),
                    p.getPedSituacao(),
                    p.getPedFunc()    
                    };
                    tabela.addRow(obj);
                }
            }
            
            somarColunaTotal();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtPClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPClienteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) //pressionou ENTER
        {  
            btnPesquisar.doClick(); //clicou no botão Entrar 
        }
    }//GEN-LAST:event_txtPClienteKeyPressed

    private void btnBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaixaActionPerformed
        // TODO add your handling code here:
    try
    {
        if (tblVendas.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "Não há item para ser dado Baixa !","ATENÇÃO",JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if (tblVendas.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(null, "Selecione um item !");
        }  
        else if(tblVendas.getSelectedRow() != -1)
        {
            int dialogButton = JOptionPane.showConfirmDialog (null, "Confirma Baixa do item selecionado ?","Warning",0);// 0 = botão Sim e Não
       
            if(dialogButton == JOptionPane.YES_OPTION)
            {
                Pedido ped = new Pedido();
            
                int linhaselecionada = tblVendas.getSelectedRow(); //pega a linha selecionada
            
                
       
                if (tblVendas.getValueAt(linhaselecionada, 7).toString().equals("P A G O"))
                {  
                    JOptionPane.showMessageDialog(null, "Este item já está P A G O !","ATENÇÃO",JOptionPane.INFORMATION_MESSAGE);
                    preencheTabela();
                }
                else 
                {
                    ped.setPedItem(Integer.parseInt(tblVendas.getValueAt(linhaselecionada, 0).toString()));
                    ped.setPedProduto(tblVendas.getValueAt(linhaselecionada, 1).toString());
                    ped.setPedQtde(Integer.parseInt(tblVendas.getValueAt(linhaselecionada, 2).toString()));
                    ped.setPedVtotal(Float.parseFloat(tblVendas.getValueAt(linhaselecionada, 3).toString()));
                    ped.setPedPgto(tblVendas.getValueAt(linhaselecionada, 4).toString());
                    ped.setPedCliente(tblVendas.getValueAt(linhaselecionada, 5).toString());
                    ped.setPedData(tblVendas.getValueAt(linhaselecionada, 6).toString());
                    //ped.setPedSituacao(tblVendas.getValueAt(linhaselecionada, 7).toString());                
                    ped.setPedSituacao(lblSituacao.getText());
                    ped.setPedFunc(tblVendas.getValueAt(linhaselecionada, 8).toString()); 
                    
                    if (this.pedidoDAO.editar(ped) == true)
                    {
                    JOptionPane.showMessageDialog(null, "Baixa realizada com sucesso !","ATENÇÃO",JOptionPane.INFORMATION_MESSAGE);
                    preencheTabela();
                    }
                } 
            }
        }    
    }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao dar Baixa !\nERRO: " + e.getMessage(),"ATENÇÃO",JOptionPane.INFORMATION_MESSAGE);//\nERRO: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBaixaActionPerformed

    private void tblVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendasMouseClicked
        // TODO add your handling code here:
        int linhaselecionada = tblVendas.getSelectedRow(); //pega a linha selecionada
        
        lblSituacao.setText("P A G O");
    }//GEN-LAST:event_tblVendasMouseClicked

    private void rbAbertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbAbertoMouseClicked
        // TODO add your handling code here:
        if (rbAberto.isSelected())
        {    
            if (tblVendas.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "Não há pedidos [em Aberto] ! ","ATENÇÃO",JOptionPane.INFORMATION_MESSAGE);
            }
            
            ArrayList<Pedido> pedido = new ArrayList<Pedido>();
            pedido = this.pedidoDAO.getPedidoAberto();
            
            DefaultTableModel tabela = (DefaultTableModel)tblVendas.getModel();
            tabela.setNumRows(0);
            
            for (Pedido ped : pedido) 
            {                
                if (ped != null) 
                {
                    Object[] obj = new Object[]{
                    ped.getPedItem(),
                    ped.getPedProduto(),
                    ped.getPedQtde(),
                    ped.getPedVtotal(),
                    ped.getPedPgto(),
                    ped.getPedCliente(),
                    ped.getPedData(),
                    ped.getPedSituacao(),
                    ped.getPedFunc()
                    };
                    tabela.addRow(obj);
                }
            } 
            somarColunaTotal();
        }
    }//GEN-LAST:event_rbAbertoMouseClicked

    private void rbPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbPagoMouseClicked
        // TODO add your handling code here:
        if (rbPago.isSelected())
        {
            ArrayList<Pedido> pedido = new ArrayList<Pedido>();
            pedido = this.pedidoDAO.getPedidoPago();
            
            DefaultTableModel tabela = (DefaultTableModel)tblVendas.getModel();
            tabela.setNumRows(0);
            
            for (Pedido ped : pedido) 
            {
            if (ped != null) 
            {
                Object[] obj = new Object[]{
                    ped.getPedItem(),
                    ped.getPedProduto(),
                    ped.getPedQtde(),
                    ped.getPedVtotal(),
                    ped.getPedPgto(),
                    ped.getPedCliente(),
                    ped.getPedData(),
                    ped.getPedSituacao(),
                    ped.getPedFunc()
                };
                tabela.addRow(obj);
            }
            }  
            somarColunaTotal();
        }
    }//GEN-LAST:event_rbPagoMouseClicked

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
            java.util.logging.Logger.getLogger(FormConsultaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConsultaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConsultaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConsultaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormConsultaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaixa;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.ButtonGroup grupoOrdenar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblSituacao;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton rbAberto;
    private javax.swing.JRadioButton rbData;
    private javax.swing.JRadioButton rbFunc;
    private javax.swing.JRadioButton rbPago;
    private javax.swing.JRadioButton rbPgto;
    private javax.swing.JRadioButton rbProduto;
    private javax.swing.JTable tblVendas;
    private javax.swing.JTextField txtPCliente;
    private javax.swing.JTextField txtVTotal;
    // End of variables declaration//GEN-END:variables
    
    public void somarColunaTotal()  
    {
        DecimalFormat df = new DecimalFormat("R$ "+"#,###,###.00");
        
        int linhaselecionada = tblVendas.getSelectedRow(); //pega a linha selecionada
                        
        DefaultTableModel modelo = (DefaultTableModel)tblVendas.getModel();    
        double soma = 0; 
        
        for (int i=0; i<tblVendas.getRowCount(); i++)   
        {    
            double valor = Double.parseDouble(String.valueOf(modelo.getValueAt(i,3))); //pega a coluna Valor Total     
            soma += valor;    
        }    
        
        String novoValor = String.valueOf(df.format(soma));  
        txtVTotal.setText(novoValor.replace(".","").replace(".", ","));
    }
}
