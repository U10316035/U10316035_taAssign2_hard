import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;


public class game extends JFrame{
	boolean[] checkQ = new boolean[10];
	
	boolean[] checkA = new boolean[4];
	
	String answer;
	String yourAns;
	question_answer QandA = new question_answer();
	JPanel panel = new JPanel();
	JLabel User = new JLabel();
	JLabel Id = new JLabel();
	
	JLabel number = new JLabel();
	java.net.URL imgURL1 = game.class.getResource("thanos.jpg");
	ImageIcon t = new ImageIcon(imgURL1);
	JLabel thanos = new JLabel(t);
	
	java.net.URL imgURL2 = game.class.getResource("stanlee.jpg");
	ImageIcon s = new ImageIcon(imgURL2);
	JLabel stanlee = new JLabel(s);
	
	int count = 0;
	int Score = 0;
	int remainTime;
	int RandomQ;
	int RandomA;
	JLabel subjectNum = new JLabel();
	JLabel subject = new JLabel("題目 : ");
	JTextArea text = new JTextArea();
	JLabel a = new JLabel("A. ");
	JLabel b = new JLabel("B. ");  
	JLabel c = new JLabel("C. ");
	JLabel d = new JLabel("D. ");
	JLabel scoreNow = new JLabel("你目前的得分: ");
	JTextField scoreText = new JTextField();
	JLabel score = new JLabel("分");
	JButton A = new JButton();
	JButton B = new JButton();
	JButton C = new JButton();
	JButton D = new JButton();
	JButton next = new JButton("點此開始");
	JButton select = new JButton("選擇");
	JTextField time = new JTextField();
	
	Timer timer;
	
	Color oldColor = A.getBackground();
	
	game(String user,String id){
		for(int j = 0;j <= 9;j++){
			checkQ[j] = false;
		}
		setBak();
		
		thanos.setBounds(300, 575, t.getIconWidth(), t.getIconHeight());
		add(thanos);
		thanos.setVisible(false);
		
		stanlee.setBounds(300, 575, s.getIconWidth(), s.getIconHeight());
		add(stanlee);
		stanlee.setVisible(false);
		
		
		add(panel);
		panel.setOpaque(false);
		setTitle("U10316035_question");
		setSize(600, 800);
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		panel.setLayout(null);
		
		User.setBounds(0, 0, 150, 20);
		User.setText("姓名 : " + user);
		User.setFont(new Font("標楷體", Font.BOLD, 16));
		User.setForeground(Color.WHITE);
		panel.add(User);
		
		Id.setBounds(0, 10, 150, 30);
		Id.setText("學號 : " + id);
		Id.setFont(new Font("標楷體", Font.BOLD, 16));
		Id.setForeground(Color.WHITE);
		panel.add(Id);
		
		number.setBounds(150, 20, 200, 20);
		number.setFont(new Font("標楷體", Font.BOLD, 18));
		number.setForeground(Color.RED);
		panel.add(number);
		number.setVisible(false);
		
		subject.setBounds(10, 40, 100, 20);
		subject.setFont(new Font("標楷體", Font.BOLD, 18));
		subject.setForeground(Color.LIGHT_GRAY);
		panel.add(subject);
		
		time.setBounds(450, 10, 130, 40);
		time.setEditable(false);
		time.setFont(new Font("標楷體", Font.BOLD, 22));
		panel.add(time);
		
		text.setBounds(10, 65, 550, 250);
		text.setOpaque(false);
		text.setEditable(false);
		text.setForeground(Color.CYAN);
		text.setFont(new Font("標楷體", Font.BOLD, 20));
		panel.add(text);
		
		a.setBounds(10, 325, 35, 35);
		a.setFont(new Font("標楷體", Font.BOLD, 20));
		a.setForeground(Color.CYAN);
		panel.add(a);
		
		b.setBounds(10, 395, 35, 35);
		b.setFont(new Font("標楷體", Font.BOLD, 20));
		b.setForeground(Color.CYAN);
		panel.add(b);
		
		c.setBounds(10, 465, 35, 35);
		c.setFont(new Font("標楷體", Font.BOLD, 20));
		c.setForeground(Color.CYAN);
		panel.add(c);
		
		d.setBounds(10, 535, 35, 35);
		d.setFont(new Font("標楷體", Font.BOLD, 20));
		d.setForeground(Color.CYAN);
		panel.add(d);
		
		A.setBounds(40, 325, 500, 30);
		A.setFont(new Font("標楷體", Font.BOLD, 20));
		panel.add(A);
		
		B.setBounds(40, 395, 500, 30);
		B.setFont(new Font("標楷體", Font.BOLD, 20));
		panel.add(B);
		
		C.setBounds(40, 465, 500, 30);
		C.setFont(new Font("標楷體", Font.BOLD, 20));
		panel.add(C);
		
		D.setBounds(40, 535, 500, 30);
		D.setFont(new Font("標楷體", Font.BOLD, 20));
		panel.add(D);
		
		scoreNow.setBounds(25, 700, 150, 20);
		scoreNow.setFont(new Font("標楷體", Font.BOLD, 18));
		scoreNow.setForeground(Color.red);
		panel.add(scoreNow);
		
		scoreText.setBounds(45, 725, 150, 30);
		scoreText.setEditable(false);
		scoreText.setText(Integer.toString(Score));
		scoreText.setFont(new Font("標楷體", Font.BOLD, 18));
		panel.add(scoreText);
		
		score.setBounds(200, 730, 30, 35);
		score.setFont(new Font("標楷體", Font.BOLD, 18));
		score.setForeground(Color.RED);
		panel.add(score);
		
		next.setBounds(450, 725, 125, 35);
		next.setFont(new Font("標楷體", Font.BOLD, 18));
		panel.add(next);
		
		select.setBounds(450, 725, 125, 35);
		select.setFont(new Font("標楷體", Font.BOLD, 18));
		select.setVisible(false);
		panel.add(select);
		
		A.setVisible(false);
		B.setVisible(false);
		C.setVisible(false);
		D.setVisible(false);
		
		timer= new Timer(1000, new ActionListener(){ 
		    public void actionPerformed(ActionEvent e) {   
		    	remainTime--;
		    	time.setText("剩餘 " + remainTime + " 秒");
		    	if(remainTime == 0){
		    		JOptionPane.showMessageDialog(null, "時間到, 答案是 : " + answer);
		    	
		    		timer.stop();
		    		if(count == 10)
						next.setText("結束遊戲");
					next.setVisible(true);
		    	}
		    }
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				A.setVisible(true);
				B.setVisible(true);
				C.setVisible(true);
				D.setVisible(true);
				A.setBackground(oldColor);
				B.setBackground(oldColor);
				C.setBackground(oldColor);
				D.setBackground(oldColor);
				if(count == 10){
					next.setText("結束遊戲");
					JOptionPane.showMessageDialog(null, "遊戲結束, 你的得分是 " + Integer.toString(Score) + "分");
					dispose();
				}
				stanlee.setVisible(false);
				thanos.setVisible(false);
				A.addActionListener(new setAListener());
				B.addActionListener(new setBListener());
				C.addActionListener(new setCListener());
				D.addActionListener(new setDListener());
				remainTime = 5;
				for(int j = 0;j <= 3;j++){
					checkA[j] = false;
				}
				do{
					RandomQ = (int)(Math.random() * 10);
				}while(checkQ[RandomQ] == true);
				checkQ[RandomQ] = true;
				switch(RandomQ){
					case 0:
						answer = "漫威";
						break;
					case 1:
						answer = "超人";
						break;
					case 2:
						answer = "布魯斯班納";
						break;
					case 3:
						answer = "美國隊長，鋼鐵人";
						break;
					case 4:
						answer = "Stan Lee";
						break;
					case 5:
						answer = "Steve Rogers";
						break;					
					case 6:
						answer = "薩諾斯";
						break;
					case 7:
						answer = "幻視";
						break;
					case 8:
						answer = "虛幻寶石(黃)";
						break;
					case 9:
						answer = "冬日士兵";
						break;
				}
				text.setText(QandA.createQuestion(RandomQ));
				switch(RandomQ){
					case 4:
						stanlee.setVisible(true);
						break;
					case 6:
						thanos.setVisible(true);
						break;
				}
				for(int ans = 0;ans <= 3;ans++){
					do{
						RandomA = (int)(Math.random() * 4);
					}while(checkA[RandomA] == true);
					switch(ans){
						case 0:
							A.setText(QandA.createAnswer(RandomQ, RandomA));
							checkA[RandomA] = true;
							break;
						case 1:
							B.setText(QandA.createAnswer(RandomQ, RandomA));
							checkA[RandomA] = true;
							break;
						case 2:
							C.setText(QandA.createAnswer(RandomQ, RandomA));
							checkA[RandomA] = true;
							break;
						case 3:
							D.setText(QandA.createAnswer(RandomQ, RandomA));
							checkA[RandomA] = true;
							break;
					}
				}
				
				time.setText("剩餘 " + remainTime + " 秒");
				count++;
				next.setText("下一題");
				number.setText("第 " + count + " 題 / 10 題");
				number.setVisible(true);
				
				timer.start();
				next.setVisible(false);
				select.setVisible(true);
			}
		});
		
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				timer.stop();
				if(yourAns.equals(answer)){
					JOptionPane.showMessageDialog(null, "正確答案!!!加 10 分 ");
					Score += 10;
					scoreText.setText(Integer.toString(Score));
				}else{
					JOptionPane.showMessageDialog(null, "錯誤答案!答案是 : " + answer);
				}
				select.setVisible(false);
				if(count == 10){
					next.setText("結束遊戲");
				}
				next.setVisible(true);
				
			}
		});
		
	}
	
	class setAListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			A.setBackground(Color.RED);
			B.setBackground(oldColor);
			C.setBackground(oldColor);
			D.setBackground(oldColor);
			yourAns = A.getText();
		}
	}
	
	class setBListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			A.setBackground(oldColor);
			B.setBackground(Color.RED);
			C.setBackground(oldColor);
			D.setBackground(oldColor);
			yourAns = B.getText();
		}
	}
	
	class setCListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			A.setBackground(oldColor);
			B.setBackground(oldColor);
			C.setBackground(Color.RED);
			D.setBackground(oldColor);
			yourAns = C.getText();
		}
	}
	
	class setDListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			A.setBackground(oldColor);
			B.setBackground(oldColor);
			C.setBackground(oldColor);
			D.setBackground(Color.RED);
			yourAns = D.getText();
		}
	}
	
	public void setBak(){
			((JPanel)this.getContentPane()).setOpaque(false);
			java.net.URL imgURL = game.class.getResource("1.jpg");
			ImageIcon img = new ImageIcon(imgURL);
			JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
			background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
	
	public static void main(String[] args){
		new login();
	}
}

class question_answer{
	question_answer(){
		
	}
	
	String createQuestion(int randomQuestion){
		switch(randomQuestion){
			case 0:
				return("Marvel漫畫的正式中文譯稱是下列何者?");
			case 1:
				return("下列何者不是Marvel旗下的超級英雄");
			case 2:
				return("綠巨人浩克的真身是何者?");
			case 3:
				return("復仇者大事紀 ，亦是即將上映的電影，\n美國隊長3的副標題:公民內戰(Civil War)，\n其中分成兩派的超級英雄陣營各為何?");
			case 4:
				return("Marvel旗下多位超級英雄的原創者，\n現已高齡九十多歲仍然相當有活力，\n甚至在幾乎每一部Marvel電影都會俏皮地出現客串，\n被粉絲稱作彩蛋(Easter Egg)之一的是下列何者?");
			case 5:
				return("美國隊長的本名是何者?");
			case 6:
				return("復仇者大事紀，\n亦是Marvel影視宇宙(Marvel Cinematic Universe, MCU)第三階段，\n即將迎來劇情最高潮的無限戰爭(Infinity War)，\n是因附圖何者挑起的?");
			case 7:
				return("無限戰爭(Infinity War)的關鍵物品，\n六顆無限寶石(Infinity gems)之一，\n鑲嵌在邪神洛基權杖上的─心靈寶石，\n在電影復仇者聯盟2─奧創紀元中被創造成下列何位英雄?");
			case 8:
				return("無限寶石(Infinity gems)不包括下列何者?");
			case 9:
				return("下列何者是美國隊長最好的基...咳咳......最好的朋友?");
		}
		return null;
	}
	
	String createAnswer(int randomQuestion, int randomAnswer){
		switch(randomQuestion){
			case 0:
				switch(randomAnswer){
					case 0:
						return("漫威");
					case 1:
						return("好威");
					case 2:
						return("小威");
					case 3:
						return("神威");
				}
			case 1:
				switch(randomAnswer){
					case 0:
						return("蜘蛛人");
					case 1:
						return("美國隊長");
					case 2:
						return("鋼鐵人");
					case 3:
						return("超人");
				}	
			case 2:
				switch(randomAnswer){
					case 0:
						return("布魯斯班納");
					case 1:
						return("布魯斯偉恩");
					case 2:
						return("東尼史塔克");
					case 3:
						return("史蒂夫羅傑斯");
				}	
			case 3:
				switch(randomAnswer){
					case 0:
						return("美國隊長，鋼鐵人");
					case 1:
						return("美國隊長，雷神索爾");
					case 2:
						return("美國隊長，蜘蛛人");
					case 3:
						return("美國隊長，神盾局長");
				}	
			case 4:
				switch(randomAnswer){
					case 0:
						return("Stan Lee");
					case 1:
						return("Jeremy Lin");
					case 2:
						return("Mark Zuckerberg");
					case 3:
						return("Jacky Chen");
				}	
			case 5:
				switch(randomAnswer){
					case 0:
						return("Steve Rogers");
					case 1:
						return("Steve Jobs");
					case 2:
						return("Johnny Storm");
					case 3:
						return("Clark Kent");
				}	
			case 6:
				switch(randomAnswer){
					case 0:
						return("薩諾斯");
					case 1:
						return("羅南");
					case 2:
						return("克魯斯");
					case 3:
						return("噬星");
				}	
			case 7:
				switch(randomAnswer){
					case 0:
						return("幻視");
					case 1:
						return("電視");
					case 2:
						return("靈異視");
					case 3:
						return("台視");
				}	
			case 8:
				switch(randomAnswer){
					case 0:
						return("靈魂寶石(綠)");
					case 1:
						return("時間寶石(橘)");
					case 2:
						return("空間寶石(紫)");
					case 3:
						return("虛幻寶石(黃)");
				}	
			case 9:
				switch(randomAnswer){
					case 0:
						return("鋼鐵人");
					case 1:
						return("冬日士兵");
					case 2:
						return("獵鷹");
					case 3:
						return("神盾局局長");
				}	
		}
		return null;
	}
	
}

class login{
	
	static JTextField setUserName = new JTextField();
	static JTextField setNumber = new JTextField();
	JLabel userName = new JLabel("姓名 : "); 
	JLabel number = new JLabel("學號 : ");
	
	login(){
		JFrame login = new JFrame();
		login.setTitle("U10316035_login");
		login.setSize(350, 180);
		login.setLocationRelativeTo(null); // Center the frame
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setResizable(false);
		login.setLayout(null); 
		
		userName.setBounds(20, 20, 50, 30);
		login.add(userName);
		
		setUserName.setBounds(90,20, 150, 30);
		login.add(setUserName);
		
		number.setBounds(20, 80, 50, 30);
		login.add(number);
		
		setNumber.setBounds(90, 80, 150, 30);
		login.add(setNumber);
		
		JButton loginIn = new JButton("login in");
		loginIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(setUserName.getText().equals("") || setNumber.getText().equals("")){
						JOptionPane.showMessageDialog(null, "請輸入內容 !!!");
					}else{
						if(setUserName.getText().length() > 6 || setNumber.getText().length() > 10){
							JOptionPane.showMessageDialog(null, "字串太長! 姓名不大於6字, 學號不大於10字!");
						}else{
							new game(setUserName.getText(), setNumber.getText());
							login.dispose();
						}
					}
				}
		});
		loginIn.setBounds(250, 80, 80, 30);
		login.add(loginIn);
		login.setVisible(true);
	}
}
