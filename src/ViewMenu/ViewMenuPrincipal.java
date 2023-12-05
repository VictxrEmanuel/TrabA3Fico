package ViewMenu;
import ViewMenu.Operacoes;
import ViewMenu.conexao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;

public class ViewMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField quantidade;
	private JTextField id;
	private static ViewMenuPrincipal frame = new ViewMenuPrincipal();
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewMenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nome = new JTextField();
		nome.setHorizontalAlignment(SwingConstants.CENTER);
		nome.setForeground(Color.WHITE);
		nome.setBackground(Color.DARK_GRAY);
		nome.setBounds(43, 108, 154, 30);
		contentPane.add(nome);
		nome.setColumns(10);
		
		quantidade = new JTextField();
		quantidade.setForeground(Color.WHITE);
		quantidade.setHorizontalAlignment(SwingConstants.CENTER);
		quantidade.setColumns(10);
		quantidade.setBackground(Color.DARK_GRAY);
		quantidade.setBounds(43, 149, 154, 30);
		contentPane.add(quantidade);
		
		id = new JTextField();
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setForeground(Color.WHITE);
		id.setColumns(10);
		id.setBackground(Color.DARK_GRAY);
		id.setBounds(43, 67, 154, 30);
		contentPane.add(id);
		
		JButton botaoAdicionar = new JButton("Adicionar");
		botaoAdicionar.setForeground(new Color(255, 255, 255));
		botaoAdicionar.setBackground(new Color(50, 205, 50));
		botaoAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
				String Id = id.getText();				
				int idDois = Integer.parseInt(Id);	
				
				String Quantidade = quantidade.getText();
				int quantidadeDois = Integer.parseInt(Quantidade);
				
				String Nome= nome.getText();
				int Nint;
				for(int i=0; i<Nome.length();i++)
				{
					try
					{
				 Nint=Nome.charAt(i);
					}
					catch(java.lang.NumberFormatException nexc)
					{
						JOptionPane.showMessageDialog(null,
				                "Preencha os campos corretamente:"
				                + "\nID-número"
				                + "\nNome-nenhum caractere especial/números"
				                + "\nQuantidade-número",
				                "PopUp Dialog",
				                JOptionPane.INFORMATION_MESSAGE);
						ViewMenuPrincipal frame2= new ViewMenuPrincipal();
						frame.setVisible(false);
						frame2.setVisible(true);
						break;
					}
				 	
				}
			    Operacoes operacao= new Operacoes();
				JOptionPane.showMessageDialog(null,
						operacao.Insert(idDois,Nome,quantidadeDois)+idDois+Nome+quantidadeDois,
		                "PopUp Dialog",
		                JOptionPane.INFORMATION_MESSAGE);
				}
				
				catch (java.lang.NumberFormatException nexc){
					JOptionPane.showMessageDialog(null,
			                "Preencha os campos corretamente:"
			                + "\nID-número"
			                + "\nNome-nenhum caractere especial"
			                + "\nQuantidade-número",
			                "PopUp Dialog",
			                JOptionPane.INFORMATION_MESSAGE);
					
					
				}
				
		}});
		botaoAdicionar.setBounds(271, 93, 89, 60);
		contentPane.add(botaoAdicionar);
		
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Id = id.getText();				
					int idDois = Integer.parseInt(Id);
					Operacoes operacao= new Operacoes();
					JOptionPane.showMessageDialog(null,
							operacao.Delete(idDois),
			                "PopUp Dialog",
			                JOptionPane.INFORMATION_MESSAGE);
				}
				catch(java.lang.NumberFormatException nexc)
				{
					JOptionPane.showMessageDialog(null,
			               "Para remover algum item da tabela o campo ID deve ser preenchido corretamente\n ID-Apenas números",
			                "PopUp Dialog",
			                JOptionPane.INFORMATION_MESSAGE);
				}
			
		}});
		botaoExcluir.setForeground(Color.WHITE);
		botaoExcluir.setBackground(new Color(220, 20, 60));
		botaoExcluir.setBounds(389, 93, 89, 60);
		contentPane.add(botaoExcluir);
		
		JButton botaoAtualizar = new JButton("Atualizar");
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Id = id.getText();				
					int idDois = Integer.parseInt(Id);
					String Quantidade = quantidade.getText();
					int quantidadeDois = Integer.parseInt(Quantidade);
					
					String Nome= nome.getText();				
					if((Nome.isEmpty()||(Nome.isBlank()))||(Quantidade.isEmpty()||(Quantidade.isBlank())))
					{
						JOptionPane.showMessageDialog(null,
					               "Para atualizar a tabela o campo Nome e o campo quantidade devem ser preenchidos\n E o ID deve ser preenchido contendo apenas números",
					                "PopUp Dialog",
					                JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
					Operacoes operacao= new Operacoes();
					JOptionPane.showMessageDialog(null,
							operacao.Update(idDois,Nome,quantidadeDois),
			                "PopUp Dialog",
			                JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(java.lang.NumberFormatException nexc)
				{
					JOptionPane.showMessageDialog(null,
			               "Para remover algum item da tabela o campo ID deve ser preenchido corretamente\n ID-Apenas números",
			                "PopUp Dialog",
			                JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		botaoAtualizar.setForeground(Color.WHITE);
		botaoAtualizar.setBackground(new Color(0, 191, 255));
		botaoAtualizar.setBounds(514, 93, 89, 60);
		contentPane.add(botaoAtualizar);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(22, 67, 21, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuantidade = new JLabel("QTD:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(10, 155, 33, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(0, 114, 43, 14);
		contentPane.add(lblNome);
		
		table = new JTable();
		table.setBounds(22, 190, 661, 253);
		contentPane.add(table);
	}
}
