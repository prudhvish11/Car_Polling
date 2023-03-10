package ABC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class GUI_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField txtGogreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_1 frame = new GUI_1();
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
	public GUI_1() {
		setBackground(Color.BLACK);
		setTitle("                         TARGARYEN'S CAR-POOLING");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setEditable(false);
		txtpnUsername.setFont(new Font("Arial", Font.BOLD, 14));
		txtpnUsername.setForeground(Color.BLACK);
		txtpnUsername.setBackground(Color.LIGHT_GRAY);
		txtpnUsername.setText("USERNAME");
		txtpnUsername.setBounds(36, 135, 89, 23);
		contentPane.add(txtpnUsername);
		
		textField = new JTextField();
		textField.setBounds(188, 135, 251, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setText("PASSWORD");
		txtpnPassword.setFont(new Font("Arial", Font.BOLD, 14));
		txtpnPassword.setBackground(Color.LIGHT_GRAY);
		txtpnPassword.setBounds(36, 197, 89, 23);
		contentPane.add(txtpnPassword);
		
		JButton btnNewButton = new JButton("CREATE A ACCOUNT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username=textField.getText();
				String password=textField.getText();
				LoginDetails lg=new LoginDetails(username,password,"user");
				car_mangement carmg=new car_mangement();
				boolean deltr=carmg.getuserdetails(lg);
				if(!deltr)
				{
				boolean abc = false;
				try {
					abc = carmg.addUser(lg);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(abc==true)
				{
					System.out.println("added success");
					JOptionPane.showMessageDialog(null, "successfully created");
					JOptionPane.showMessageDialog(null, "AddedSuccess");
				}
				else
				{
				System.out.println("error in  adding");
				JOptionPane.showMessageDialog(null, "error in  adding");
				}
				}
				else
				{
					System.out.println("User duplicate/Already found");
					JOptionPane.showMessageDialog(null, "User duplicate/Already found");
				}
			}
		});
		btnNewButton.setBounds(22, 304, 159, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BOOK A POOL\r\n\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Login Successfully");
				List<String> loc=new ArrayList<>(Arrays.asList("hyderabad","kamareddy","nizambad","vizag","vijayawada"));
				List<String> carno=new ArrayList<>(Arrays.asList("ap1234","ts1234","re12","yu12","kmr12"));
				//System.out.println("Enter the user name");
				//String username=sc.next();
				//String uuu=username;
				
//				System.out.println(uuu);
				//System.out.println("Enter password");
//				sc.nextLine();
				//String password=sc.next();
				String username=textField.getText();
				String password=textField.getText();
				LoginDetails lg=new LoginDetails(username,password,"user");
				car_mangement carmg=new car_mangement();
				boolean abc=carmg.getuserdetails(lg);
				if(abc==true)
				{
					System.out.println("User already exsists");
					System.out.println("hyderabad\n"+"kamareddy\n"+"nizambad\n"+"vizag\n"+"vijayawada");
					System.out.println("Enter pickup");
					Scanner sc=new Scanner(System.in);
					String pickup=sc.next();
					
					System.out.println("Enter destination");
					String desti=sc.next();
					
					System.out.println("Enter the vechile");
					for(int i=0;i<carno.size();i++)
					{
						System.out.println(carno.get(i));
					}
					String vecno=sc.next();
					
					int total=0;
					if(loc.indexOf(pickup)>=0 && loc.indexOf(desti)>=0 && loc.indexOf(pickup)!=loc.indexOf(desti))
					{
						if((loc.indexOf(pickup)-loc.indexOf(desti))<0)
						{
						  total=total+(-(loc.indexOf(pickup)-loc.indexOf(desti)))*300;
						}
						else
						{
						System.out.println((loc.indexOf(pickup)-loc.indexOf(desti)));
						total=total+(loc.indexOf(pickup)-loc.indexOf(desti))*300;
						
						}LocalDate ld=LocalDate.now();
						System.out.println("lg.getUsername"+lg.getUsername()+" ASDFG+"+total);
						PoolDetails pp=new PoolDetails(lg.getUsername(), ld, vecno, total, pickup, desti);
//						boolean confirm;
					System.out.println("enter yes to save");
					String confirm=sc.next();
					car_mangement carma=new car_mangement();
					if(confirm.equalsIgnoreCase("yes"))
					{
						
						boolean bb=carma.detailssave(pp);
						if(bb)
						{
						System.out.println("sucessssss");
						
						}else
						{
							System.out.println("pool drive failed");
						}
						
					}
					else
					{	System.out.println("order cancelled");}
					}
					else
					{	System.out.println("picup or desti is wrong");}
				}
				else
				{System.out.println("User id not found in  data bas");}
			}
		});
		btnNewButton_1.setBounds(205, 304, 127, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("POOL HISTORY");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Login Successfully");
				String username=textField.getText();
				String password=textField.getText();
				LoginDetails lg=new LoginDetails(username,password,"user");
				car_mangement carmg=new car_mangement();
				ArrayList<PoolDetails> ppd=carmg.viewalldetails(username);
				System.out.println("use name  "+"Date   "+"  car no"+"   amount"+"  pickup"+" destination");
				for(int i=0;i<ppd.size();i++)
				{
					System.out.println(ppd.get(i).getName()+" "+ppd.get(i).getDate()+" "+ppd.get(i).getCarNo()+" "+ppd.get(i).getAmount()+" "+ppd.get(i).getPickup()+" "+ppd.get(i).getDestination());
				}
				System.out.println("These are all transactions done");
			}
		});
		btnNewButton_2.setBounds(376, 304, 125, 39);
		contentPane.add(btnNewButton_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 197, 251, 23);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\project\\2.jpeg"));
		lblNewLabel.setBounds(10, 46, 526, 318);
		contentPane.add(lblNewLabel);
		
		txtGogreen = new JTextField();
		txtGogreen.setForeground(Color.GREEN);
		txtGogreen.setFont(new Font("Arial", Font.BOLD, 17));
		txtGogreen.setText("GO-GREEN");
		txtGogreen.setEditable(false);
		txtGogreen.setBounds(206, 22, 104, 29);
		contentPane.add(txtGogreen);
		txtGogreen.setColumns(10);
		
		JTextPane txtpnGoCarpooling = new JTextPane();
		txtpnGoCarpooling.setForeground(Color.GREEN);
		txtpnGoCarpooling.setFont(new Font("Arial", Font.BOLD, 17));
		txtpnGoCarpooling.setText("GO CAR-POOLING");
		txtpnGoCarpooling.setBounds(188, 363, 168, 27);
		contentPane.add(txtpnGoCarpooling);
	}
}