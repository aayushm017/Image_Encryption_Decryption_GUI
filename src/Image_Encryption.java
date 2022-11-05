// package ImageEncryptionDecryption_GUI;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class Image_Encryption {

	public static void operate(int key)
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		//file inputStream reader
		try{
			FileInputStream fis = new FileInputStream(file);
			byte []data = new byte[fis.available()];
			fis.read(data);
			int i = 0;
			//It comes under symmetric algorithm
			for(byte b:data)
			{
				System.out.println(b);
				data[i] = (byte)(b^key);  //position B me data i b xor key se
				i++;
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data);
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null, "Done");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("this is testing");

		JFrame f = new JFrame();
		f.setTitle("Image Operation");
		f.setSize(400,400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font font = new Font("Roboto", Font.BOLD, 25);
		// Creating Button
		JButton button = new JButton();
		button.setText("Open Image");
		button.setFont(font);

		//Creating Text Field
		JTextField textField =new JTextField(10);
		textField.setFont(font);

		button.addActionListener(e-> {  //Lambda fun:- anonymous class replace by lambda function to implement fun interface
			System.out.println("button clicked");
			String text =  textField.getText();
			int temp = Integer.parseInt(text); //convert string to int
			operate(temp);
		});

		f.setLayout(new FlowLayout());

		f.add(button);
		f.add(textField);
		f.setVisible(true);
	}
}