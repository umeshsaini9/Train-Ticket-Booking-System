package collection;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public  class trainticket implements ActionListener{
	JFrame frame=new JFrame();
	String ticketclass[]={"General","Sleeper","AC"};
	String gender[]= {"male","female","other"};
	JLabel costumernameLabel=new JLabel("COSTUMER NAME");
	JLabel ticketclassLabel=new JLabel("TICKET CLASS");
	JLabel genderLabel=new JLabel("GENDER");
	JLabel mobilenoLabel=new JLabel("MOBILE NUMBER");
	JLabel ageLabel=new JLabel("AGE");
	JLabel emailLabel=new JLabel("E-Mail");
	JLabel addressLabel=new JLabel("ADDRESS");
	JLabel aadharnoLabel=new JLabel("AADHAR NUMBER");
	JTextField costumernameTextField=new JTextField();
	JComboBox genderComboBox=new JComboBox(gender);
	JComboBox ticketclassComboBox=new JComboBox(ticketclass);
	JTextField ageTextField=new JTextField();
	JTextField mobilenoTextField=new JTextField();
	JTextField emailTextField=new JTextField();
	JTextField addressTextField=new JTextField();
	JTextField aadharnoTextField=new JTextField();
	JButton submitButton=new JButton("SUBMIT");
	JButton resetButton=new JButton("reset");

	trainticket()
	{
		createwindow();
		setsize();
		addallcomponent();
		actionevent();
		
	}
	public void createwindow() 
	{
		frame.setTitle("Ticket Booking");
		frame.setBounds(40,40,380,600);
		frame.getContentPane().setBackground(Color.orange);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		}
	public void setsize()
	{
		
		costumernameLabel.setBounds(20,20,120,70);
		ticketclassLabel.setBounds(20,70,230,70);
		genderLabel.setBounds(20,120,100,70);
		mobilenoLabel.setBounds(20,170,100,70);
		ageLabel.setBounds(20,220,140,70);
		emailLabel.setBounds(20,270,100,70);
		addressLabel.setBounds(20,320,100,70);
		aadharnoLabel.setBounds(20,370,100,70);
		costumernameTextField.setBounds(180,43,165,23);
		ticketclassComboBox.setBounds(180,93,165,23);
		genderComboBox.setBounds(180,143,165,23);
		mobilenoTextField.setBounds(180,193,165,23);
		ageTextField.setBounds(180,243,165,23);
		emailTextField.setBounds(180,293,165,23);
		addressTextField.setBounds(180,343,165,23);
		aadharnoTextField.setBounds(180,393,165,23);
		submitButton.setBounds(70,450,100,35);
		resetButton.setBounds(220,450,100,35);
		
		
	}
	public void addallcomponent() 
	{
		frame.add(costumernameLabel);
		frame.add(ticketclassLabel);
		frame.add(genderLabel);
		frame.add(mobilenoLabel);
		frame.add(ageLabel);
		frame.add(emailLabel);
		frame.add(addressLabel);
		frame.add(aadharnoLabel);
		frame.add(costumernameTextField);
		frame.add(ticketclassComboBox);
		frame.add(genderComboBox);
		frame.add(mobilenoTextField);
		frame.add(ageTextField);
		frame.add(emailTextField);
		frame.add(addressTextField);
		frame.add(aadharnoTextField);
		frame.add(submitButton);
		frame.add(resetButton);
		
		
		
	}
	public void actionevent()
	{
		submitButton.addActionListener(this);
		resetButton.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==submitButton)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/officer","root","root");
				PreparedStatement ps=c.prepareStatement("insert into trainticket values(?,?,?,?,?,?,?,?)");
				ps.setString(1,costumernameTextField.getText());
				ps.setString(2, ticketclassComboBox.getSelectedItem().toString());
				ps.setString(3, genderComboBox.getSelectedItem().toString());
				ps.setString(4,mobilenoTextField.getText());
				ps.setString(5, ageTextField.getText());
				ps.setString(6, emailTextField.getText());
				ps.setString(7, addressTextField.getText());
				ps.setString(8,aadharnoTextField.getText());
				
				if(true) 
				{
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Ticket Confirmed");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Ticket not Confirmed");
				}
				
			}
			catch(Exception E)
			{
				E.printStackTrace();			}
		}
	
	if(e.getSource()==resetButton)
	{
		costumernameTextField.setText("");
		ticketclassComboBox.setSelectedItem("");
		genderComboBox.setSelectedItem("");
		mobilenoTextField.setText("");
		ageTextField.setText("");
		emailTextField.setText("");
		addressTextField.setText("");
		aadharnoTextField.setText("");
		
	}
	}
	
}
