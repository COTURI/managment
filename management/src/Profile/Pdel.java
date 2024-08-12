package Profile;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Member.Mframe;
import login.LoginFrame;

public class Pdel {
	private JFrame f;
	private JLabel ldelete;
	private JButton Btok, Btno;
	private ProfileDAO dao;
	private DTO user;
	
	Font font = new Font("SansSerif", Font.BOLD, 15);

	public Pdel() {
		dao = new ProfileDAO();
				
		f = new JFrame("회원탈퇴");
		f.setBounds(100, 100, 450, 300);
		f.setLayout(null);
		f.getContentPane().setBackground(new Color(255, 245, 248));

		ldelete = new JLabel("탈퇴 하겠습니까?");
		ldelete.setBounds(150, 85, 150, 23);
		ldelete.setFont(font);
		
		Btok = new JButton("확인");
		Btok.setBounds(109, 134, 97, 23);
		Btok.setBackground(new Color(77,182,172));
		Btok.setForeground(Color.black);
		Btok.setFocusPainted(false); // 버튼 포커스 페인팅 비활성화
		Btok.setOpaque(false); // 버튼 불투명 설정 비활성화
		Btok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dao.delete(user);
				new LoginFrame();
				f.dispose();
			}
		});
		
		
		Btno = new JButton("취소");
		Btno.setBounds(229, 134, 97, 23);
		Btno.setBackground(new Color(77,182,172));
		Btno.setForeground(Color.black);
		Btno.setFocusPainted(false); // 버튼 포커스 페인팅 비활성화
		Btno.setOpaque(false); // 버튼 불투명 설정 비활성화
		Btno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
				new Pframe();
			}
		});
		
		f.add(ldelete);
		f.add(Btno);
		f.add(Btok);
		
		f.setFont(font);
		f.setVisible(true);	
		
	}
	public static void main(String[] args) {
		new Pdel();
	}

}
