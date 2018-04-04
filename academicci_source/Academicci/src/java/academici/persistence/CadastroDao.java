package academici.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import academici.connection.ConnectionFactory;
import academici.entity.Cadastro;
import academici.entity.Monitoria;

public class CadastroDao {

    private String sql;

    public boolean incluir(Cadastro cadastro) {
        boolean isOk = false;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (conn == null) {
            return isOk;
        }

        sql = "INSERT INTO usuarios(nome, matricula, sexo, email, senha, "
                + "cpf,rg,telefone, acesso) VALUES(?,?,?,?,?,?,?,?,?);";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cadastro.getNome());
            ps.setInt(2, cadastro.getMatricula());
            ps.setString(3, cadastro.getSexo());
            ps.setString(4, cadastro.getEmail());
            ps.setString(5, cadastro.getSenha());
            ps.setString(6, cadastro.getCpf());
            ps.setString(7, cadastro.getRg());  
            ps.setString(8, cadastro.getTelefone());
            ps.setInt(9, cadastro.getAcesso());
            ps.executeUpdate();
            isOk = true;
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOk;
    }

    public boolean alterar(Cadastro cadastro) {
        boolean isOk = false;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (conn == null) {
            return isOk;
        }

        sql = "UPDATE usuarios SET nome=?, matricula=?, sexo=?, email=?, "
                + "senha=?, cpf=?, rg=?, telefone=?, acesso=? WHERE id=?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(2, cadastro.getNome());
            ps.setInt(3, cadastro.getMatricula());
            ps.setString(4, cadastro.getSexo());
            ps.setString(5, cadastro.getEmail());
            ps.setString(6, cadastro.getSenha());
            ps.setString(7, cadastro.getCpf());
            ps.setString(8, cadastro.getRg());
            ps.setString(9, cadastro.getTelefone());
            ps.setInt(10, cadastro.getAcesso());
            ps.executeUpdate();
            isOk = true;
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOk;
    }

    public boolean excluir(int id) {
        boolean isOk = false;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (conn == null) {
            return isOk;
        }

        sql = "DELETE FROM usuarios WHERE usuarios.id=?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            isOk = true;
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOk;
    }

    public Cadastro getCadastro(int id) {
        Cadastro cadastro = null;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (conn == null) {
            return cadastro;
        }

        sql = "SELECT * FROM usuarios WHERE id=?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cadastro = new Cadastro();
                cadastro.setNome(rs.getString("nome"));
                cadastro.setMatricula(rs.getInt("matricula"));
                cadastro.setSexo(rs.getString("sexo"));
                cadastro.setEmail(rs.getString("email"));
                cadastro.setSenha(rs.getString("senha"));
                cadastro.setCpf(rs.getString("cpf"));
                cadastro.setRg(rs.getString("rg"));
                cadastro.setTelefone(rs.getString("telefone"));
                cadastro.setAcesso(rs.getInt("acesso"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        return cadastro;
    }

    public List<Cadastro> getCadastros() {
        List<Cadastro> lstCadastros = null;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (conn == null) {
            return lstCadastros;
        }

        sql = "SELECT * FROM usuários ORDER BY nome;";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            lstCadastros = new ArrayList<>();
            while (rs.next()) {
                Cadastro cadastro = new Cadastro();
                cadastro.setNome(rs.getString("nome"));
                cadastro.setMatricula(rs.getInt("matricula"));
                cadastro.setSexo(rs.getString("sexo"));
                cadastro.setEmail(rs.getString("email"));
                cadastro.setSenha(rs.getString("senha"));
                cadastro.setCpf(rs.getString("cpf"));
                cadastro.setRg(rs.getString("rg"));
                cadastro.setTelefone(rs.getString("telefone"));
                cadastro.setAcesso(rs.getInt("acesso"));
                lstCadastros.add(cadastro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

        return lstCadastros;
    }

    public boolean incluir(Monitoria monitoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean alterar(Monitoria monitoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
