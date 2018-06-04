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
		setTitle("Chess Game");							//container의 title 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		Font font = new Font("Hobo BT",Font.BOLD, 20);	//글씨체 설정
		
		JLabel b = new JLabel("Chess!");				//라벨설정
		b.setHorizontalAlignment(SwingConstants.CENTER);//가운데 정렬
		b.setVerticalAlignment(SwingConstants.CENTER);
		b.setLocation(100, 30);						
		b.setSize(200, 50);
		b.setFont(font);
		add(b);											//label 추가
		
		String[] button = {"1vs1", "2vs2","EXIT"};		//button의 문자열 설정
		JButton[] jbtno = new JButton[3];				//버튼 배열 생성
		ListenerClass listener = new ListenerClass();
		
		for(int i=0;i<3;i++){							//3개의 버튼 설정
			add(jbtno[i] = new JButton(button[i]));		
			jbtno[i].setBackground(new Color(247,184,206));	//배경 색 설정
			jbtno[i].setForeground(new Color(0,63,126));	//글씨 색 설정
			jbtno[i].setLocation(100,100+i*70);	
			jbtno[i].setSize(200,50);
			jbtno[i].setFont(font);				
			jbtno[i].addActionListener((ActionListener) listener);
		}
		
		setSize(420,370);														//container의 크기 설정
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
