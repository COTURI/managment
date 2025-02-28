package Profile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Member.MessageDialog;
import login.InfoVo;

public class PTab extends JPanel {
	private DTO user;
	String height2;
	String weight2;
	
	public PTab(String tabName, DTO user) {

		this.user = user;
		setLayout(new BorderLayout());

		if (tabName.equals("내 프로필")) {
			add(createProfilePanel(), BorderLayout.CENTER);
				
		} else if (tabName.equals("E-MAIL 변경")) {
			add(emailChangePanel(), BorderLayout.CENTER);
		} else if (tabName.equals("비밀번호 변경")) {
			add(createPasswordChangePanel(), BorderLayout.CENTER);
		}

	}

	ProfileDAO dao = new ProfileDAO();

	private JPanel createProfilePanel() {
		
		Font font = new Font("SansSerif", Font.BOLD, 18);
			
		JPanel profilePanel = new JPanel();
		profilePanel.setBackground(new Color(255,255,255));
		profilePanel.setLayout(new BorderLayout());
		// 프로필 정보 패널 구성
		JLabel name = new JLabel("이름");
		name.setFont(font);
		name.setBounds(100, 80, 100, 30);
		profilePanel.add(name);
		JLabel dname = new JLabel(user.getName());
		dname.setBounds(200, 80, 100, 30);
		dname.setFont(font);
		profilePanel.add(dname);
		// 정보 가져오기

		JLabel id = new JLabel("ID");
		id.setBounds(100, 130, 100, 30);
		id.setFont(font);
		profilePanel.add(id);
		JLabel did = new JLabel(user.getID());
		did.setBounds(200, 130, 100, 30);
		did.setFont(font);
		profilePanel.add(did);

		JLabel mail = new JLabel("E-mail");
		mail.setBounds(100, 180, 100, 30);
		mail.setFont(font);
		profilePanel.add(mail);
		JLabel dmail = new JLabel(user.getEmail());
		dmail.setBounds(200, 180, 180, 30);
		dmail.setFont(font);
		profilePanel.add(dmail);

		JLabel phone = new JLabel("핸드폰");
		phone.setBounds(100, 230, 100, 30);
		phone.setFont(font);
		profilePanel.add(phone);
		JLabel dphone = new JLabel(user.getPhone());
		dphone.setBounds(200, 230, 180, 30);
		dphone.setFont(font);
		profilePanel.add(dphone);

		JLabel year = new JLabel("생년월일");
		year.setBounds(100, 280, 100, 30);
		year.setFont(font);
		profilePanel.add(year);
		JLabel dyear = new JLabel(user.getYear());
		dyear.setBounds(200, 280, 130, 30);
		dyear.setFont(font);
		profilePanel.add(dyear);

		JLabel height = new JLabel("키");
		height.setBounds(100, 330, 100, 30);
		height.setFont(font);
		profilePanel.add(height);
		JLabel dheight = new JLabel(String.valueOf(user.getHeight()));
		dheight.setBounds(200, 330, 100, 30);
		dheight.setFont(font);
		profilePanel.add(dheight);
//		dheight.setText(height2);

		JLabel weight = new JLabel("몸무게");
		weight.setBounds(100, 380, 100, 30);
		weight.setFont(font);
		profilePanel.add(weight);
		JLabel dweight = new JLabel(String.valueOf(user.getWeight()));
		dweight.setBounds(200, 380, 100, 30);
		dweight.setFont(font);
		profilePanel.add(dweight);
//		dweight.setText(weight2);

		JButton wh = new JButton("키 몸무게 수정");
		wh.setBounds(400, 380, 120, 30);
		profilePanel.add(wh);
		wh.setBackground(new Color(0,0,0));
		wh.setForeground(Color.white);
		wh.addActionListener(new ActionListener() {
			// 키 몸무게 수정창 띄우기
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Ptab1hw frame = new Ptab1hw();
				frame.setVisible(true);
			}
		});

		// 줄간격이 안맞아서 넣음
		JLabel e = new JLabel(" ");
		e.setBounds(100, 300, 100, 30);
		profilePanel.add(e);
		JLabel de = new JLabel(" ");
		de.setBounds(200, 300, 100, 30);
		profilePanel.add(de);

		return profilePanel;
	}

	private JPanel emailChangePanel() {
		Font font = new Font("SansSerif", Font.BOLD, 15);
		JPanel emailChangePanel = new JPanel();
		emailChangePanel.setLayout(null);
		emailChangePanel.setBackground(new Color(255,255,255));
		// 아이디 변경 패널 구성
		JLabel newIdLabel = new JLabel("NEW E-MAIL:");
		newIdLabel.setBounds(50, 50, 100, 30);
		newIdLabel.setFont(font);
		emailChangePanel.add(newIdLabel);
		JTextField newIdField = new JTextField();
		newIdField.setBounds(160, 50, 200, 30);
		newIdField.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1));
		emailChangePanel.add(newIdField);
		JButton ICP = new JButton("확인");
		ICP.setBounds(400, 50, 70, 30);
		emailChangePanel.add(ICP);
		ICP.setBackground(new Color(0,0,0));
		ICP.setForeground(Color.white);
		ICP.addActionListener(new ActionListener() {
			// 새로운 이메일 저장
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userId = InfoVo.getInstance().getId();
				String email = newIdField.getText();
				if (email.isEmpty()) {
					new MessageDialog(null, "알림", "email 입력해주세요.");
				} else {
					dao.updatemail(email, userId);
					new MessageDialog(null, "알림", "변경 되었습니다.");
				}
			}
		});

		return emailChangePanel;
	}

	private JPanel createPasswordChangePanel() {
		Font font = new Font("SansSerif", Font.BOLD, 15);
		JPanel passwordChangePanel = new JPanel();
		passwordChangePanel.setLayout(null);
		passwordChangePanel.setBackground(new Color(255,255,255));
		// 비밀번호 변경 패널 구성
		JLabel newPasswordLabel = new JLabel("새 비밀번호:");
		newPasswordLabel.setBounds(50, 50, 120, 30);
		newPasswordLabel.setFont(font);
		passwordChangePanel.add(newPasswordLabel);
		JTextField newPasswordField = new JTextField();
		newPasswordField.setBounds(180, 50, 200, 30);
		newPasswordField.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1));
		passwordChangePanel.add(newPasswordField);

		JLabel newPwd2 = new JLabel("비밀번호 확인:");
		newPwd2.setBounds(50, 100, 120, 30);
		newPwd2.setFont(font);
		passwordChangePanel.add(newPwd2);
		JTextField tfnewPwd = new JTextField();
		tfnewPwd.setBounds(180, 100, 200, 30);
		tfnewPwd.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1));
		passwordChangePanel.add(tfnewPwd);

		JButton pwd = new JButton("확인");
		pwd.setBounds(400, 100, 70, 30);
		passwordChangePanel.add(pwd);
		pwd.setBackground(new Color(0,0,0));
		pwd.setForeground(Color.white);
		pwd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String password = newPasswordField.getText();
				String confirmPassword = tfnewPwd.getText();
				if (password.isEmpty() || confirmPassword.isEmpty()) {
					new MessageDialog(null, "알림", "빈칸 없이 채워주세요.");
				} else if (!password.equals(confirmPassword)) {
					new MessageDialog(null, "알림", "비밀번호가 일치하지 않습니다.");
				} else if (!isValidPassword(password)) {
					new MessageDialog(null, "알림", "특수문자를 포함하지 않습니다.");
				} else {
					// 비밀번호 업데이트
					String userId = InfoVo.getInstance().getId();
					dao.updatepwd(password, userId);
					new MessageDialog(null, "알림", "비밀번호 변경 완료");
				}
			}
		});

		return passwordChangePanel;
	}

	// 비밀번호에 특수문자가 포함되어 있는지 검증
	public boolean isValidPassword(String password) {
		return password.matches("[a-zA-Z0-9]+");
	}
}


