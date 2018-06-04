package board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FirstGUI extends JFrame{
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	FirstGUI(){
		setTitle("Chess Game");							//container�� title ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		Font font = new Font("Hobo BT",Font.BOLD, 20);	//�۾�ü ����
		
		JLabel b = new JLabel("Chess!");				//�󺧼���
		b.setHorizontalAlignment(SwingConstants.CENTER);//��� ����
		b.setVerticalAlignment(SwingConstants.CENTER);
		b.setLocation(100, 30);						
		b.setSize(200, 50);
		b.setFont(font);
		add(b);											//label �߰�
		
		String[] button = {"1vs1", "2vs2","EXIT"};		//button�� ���ڿ� ����
		JButton[] jbtno = new JButton[3];				//��ư �迭 ����
		ListenerClass listener = new ListenerClass();
		
		for(int i=0;i<3;i++){							//3���� ��ư ����
			add(jbtno[i] = new JButton(button[i]));		
			jbtno[i].setBackground(new Color(247,184,206));	//��� �� ����
			jbtno[i].setForeground(new Color(0,63,126));	//�۾� �� ����
			jbtno[i].setLocation(100,100+i*70);	
			jbtno[i].setSize(200,50);
			jbtno[i].setFont(font);				
			jbtno[i].addActionListener((ActionListener) listener);
		}
		
		setSize(420,370);														//container�� ũ�� ����
		setLocation((dim.width/2)-(getWidth()/2), (dim.height/2)-(getHeight()/2));		
		
		setVisible(true);
	}
	
	class ListenerClass implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		    if(e.getActionCommand().equals("1vs1")) {
		    	setVisible(false);
		    	new Board();
		    }
		    else if(e.getActionCommand().equals("2vs2"))
		       	System.out.println("The " + e.getActionCommand() + " button " + "is clicked");
		    else 
		    	System.exit(0);
		}
	}
}
