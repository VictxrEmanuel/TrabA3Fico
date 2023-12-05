package ViewMenu;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
public class Operacoes {
	   static String jdbcUrl = "jdbc:mysql://localhost:3306/trabfico";
	    static String user = "root";
	    static String password = "root";
	    static Connection conn=null;

	 
	public String Insert(int id,String nome,int qtd)
	{
		 try {
		     conn = DriverManager.getConnection(jdbcUrl,user, password);
		    } catch ( SQLException e) {
		        System.out.println("Conexão mal sucedida!");
		    }
		String ret="";
		int ids=id;
		String nome_s=nome;
		int qtds=qtd;
		try {
			String sql="INSERT INTO produtos (ID,Nome,Quantidade) VALUES ("+ids+",'"+nome_s+"',"+qtds+");";
	        PreparedStatement pstm = conn.prepareStatement(sql);
			 pstm.execute(sql);
		       ret="funciona";
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,
	                "Não foi possível realizar a operação"+"\ninsert into produtos (ID, Nome, Quantidade)"+ids+","+nome_s+","+qtds+"",
	                "PopUp Dialog",
	                JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null,
	                conn.toString(),
	                "PopUp Dialog",
	                JOptionPane.INFORMATION_MESSAGE);
			System.out.println(e.toString());
		}
 return ret;
        
	}

	public String Delete(int id)
	{
		 try {
		     conn = DriverManager.getConnection(jdbcUrl,user, password);
		    } catch ( SQLException e) {
		        System.out.println("Conexão mal sucedida!");
		    }
		String ret="";
		int ids=id;
		try {
		String sql = "SELECT * FROM produtos WHERE ID="+ids+"";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		if(rs.next())
		{
		try {
			String sql2="DELETE FROM produtos WHERE ID="+ids+";";
	        PreparedStatement pstm2 = conn.prepareStatement(sql2);
			 pstm2.execute(sql2);
		       ret="Item removido";
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,
	                "Não foi possível realizar a operação"+"\nDELETE FROM produtos WHERE ID2="+ids+"",
	                "PopUp Dialog",
	                JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null,
	                conn.toString(),
	                "PopUp Dialog",
	                JOptionPane.INFORMATION_MESSAGE);
			System.out.println(e.toString());
		}
        
	}
		else
		{
			ret="Coloque um ID válido";	
		}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,
	                "Não foi possível realizar a operação"+"\nDELETE FROM produtos WHERE ID1="+ids+"",
	                "PopUp Dialog",
	                JOptionPane.INFORMATION_MESSAGE);
		}
		return ret;
	/*PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1, username);
	pstmt.setString(2, password);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
	    //read the data from ResultSet
	}*/

}
	public String Update(int id,String nome_u,int qtdu)
	{
		String retu="";
			 try {
			     conn = DriverManager.getConnection(jdbcUrl,user, password);
			    } catch ( SQLException e) {
			        System.out.println("Conexão mal sucedida!");
			    }
			String ret="";
			int ids=id;
			try {
			String sql = "SELECT * FROM produtos WHERE ID="+id+"";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
			try {
				String sql2="UPDATE produtos SET Nome='"+nome_u+"',Quantidade="+qtdu+" WHERE ID="+ids+";";
		        PreparedStatement pstm2 = conn.prepareStatement(sql2);
				 pstm2.execute(sql2);
			       retu="Item atualizado";
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,
		                "Não foi possível realizar a operação"+"\nDELETE FROM produtos WHERE ID2="+ids+"",
		                "PopUp Dialog",
		                JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null,
		                conn.toString(),
		                "PopUp Dialog",
		                JOptionPane.INFORMATION_MESSAGE);
				System.out.println(e.toString());
			}
	        
		}
			else
			{
				ret="Coloque um ID válido";	
			}
			}
			catch(SQLException e) {
				JOptionPane.showMessageDialog(null,
		                "Não foi possível realizar a operação"+"\nDELETE FROM produtos WHERE ID1="+ids+"",
		                "PopUp Dialog",
		                JOptionPane.INFORMATION_MESSAGE);
			}
		/*PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
		    //read the data from ResultSet
		}*/
		
		return retu;
		}
}

