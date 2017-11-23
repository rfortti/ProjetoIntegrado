/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class CategoriaDAO extends GenericDAO 
{

    public CategoriaDAO()
    {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }
            
    public boolean inserir(Categoria categoria)
    {
        String sql = "INSERT INTO categoria (codigo, tipo) VALUES (?, ?)";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1,categoria.getCodCategoria());
            this.stmte.setString(2,categoria.getTipo());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public boolean excluir(Categoria categoria)
    {
        String sql = "DELETE FROM categoria WHERE codigo = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1, categoria.getCodCategoria());
            //this.stmte.execute();
            
            int exec = this.stmte.executeUpdate();
            
            if(exec > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
     public boolean editar(Categoria categoria)
    {
        String sql = "UPDATE categoria SET tipo = ? WHERE codigo = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,categoria.getTipo());
            this.stmte.setInt(2, categoria.getCodCategoria());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public Categoria getCategoriaByTipo(String tipocategoria)
    {
        Categoria cat = new Categoria();
        
        String sql = "SELECT * FROM categoria WHERE tipo LIKE ?";
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,tipocategoria+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            cat.setCodCategoria(rs.getInt("codigo"));
            cat.setTipo(rs.getString("tipo"));
            return cat;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Categoria> getCategoriasByCod() //L I S T A
    {
        ArrayList<Categoria> categoria = new ArrayList<Categoria>();
        //Categoria[] categorias = new Categoria[200];
        int x = 0;
        String sql = "SELECT * FROM categoria ORDER BY codigo ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Categoria c = new Categoria();
                c.setCodCategoria(rs.getInt("codigo"));
                c.setTipo(rs.getString("tipo"));
                categoria.add(c);
                x++;
            }
            return categoria;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public Categoria[] getCategoriasByTipo() //V E T O R
    {
        Categoria[] categorias = new Categoria[200];
        int x = 0;
        String sql = "SELECT * FROM categoria ORDER BY tipo ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Categoria c = new Categoria();
                c.setCodCategoria(rs.getInt("codigo"));
                c.setTipo(rs.getString("tipo"));
                categorias[x] = c;
                x++;
            }
            return categorias;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public int AutoIncCod()
    {
        String sql = "SELECT (MAX(codigo) + 1) as codigo FROM categoria";
        this.prepareStmte(sql);
        ResultSet rs;
        int retorno = 0;
        try {
            rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            retorno = rs.getInt("codigo");
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;

    }

}
