package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.Data;

//import swtl.Index;

import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;

public class Login1 {

	protected Shell shell;
	private Display display;
	private Text text;
	private DBHelper db = new DBHelper();
	private Text text_1;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login1 window = new Login1();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(about.class, "/images/icon.jpg"));
		shell.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(Login1.class, "/images/background.jpg"));
		shell.setSize(539, 439);
		shell.setText("\u6B22\u8FCE\u6765\u5230\u767B\u5165\u754C\u9762");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel.setBounds(105, 150, 68, 34);
		lblNewLabel.setText("邮箱：");

		text = new Text(shell, SWT.BORDER);
		text.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		text.setBounds(198, 149, 218, 35);

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(105, 219, 68, 33);
		lblNewLabel_1.setText("密码：");
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		
		text_1.setBounds(198, 218, 218, 35);
		

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));


		
		btnNewButton.setBounds(130, 312, 98, 30);
		btnNewButton.setText("\u767B \u5165");

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		
		btnNewButton_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_1.setBounds(292, 312, 98, 30);
		btnNewButton_1.setText("\u6CE8 \u518C");

		
		Label label = new Label(shell, SWT.BORDER);
		label.setBounds(211, 13, 100, 100);
		
		Link link = new Link(shell, SWT.NONE);
		
		link.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		link.setBounds(338, 259, 79, 24);
		link.setText("<a>忘记密码</a>");
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				login();
			}	
			});
		
		text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println(e.keyCode);
				if (e.keyCode == 13) {
					login();
				}
			}
		});
		//输入账号之后点击密码框显示头像
		text_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String sql = "select photoUser from memberUser where email = ?";
				String email = "";
				email = text.getText();
				List<Map<String , Object>> list = db.findAll(sql,email);
				InputStream bais = new ByteArrayInputStream( (byte[]) list.get(0).get("photouser"));
				ImageData imageData = new ImageData(bais);
				imageData = imageData.scaledTo(100, 100);
				Image image = new Image(display , imageData);
				label.setImage(image);
			}
						
		});
		
		//注册按钮的点击事件
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Reg reg = new Reg();
				shell.dispose();
				reg.open();
			}
		});
		
		//忘记密码
		link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Wangjimima wjmm = new Wangjimima();
				wjmm.open();
			}
		});
	}
		private void login() {
			// TODO Auto-generated method stub
			// 获取用户名和密码
			String uname = text.getText();
			String pwd = text_1.getText();
			String sql = "select * from  memberUser   where email=? and pwd=?";
			List<Map<String, Object>> list = db.findAll(sql, uname,pwd);
			// 弹框
			MessageBox mb = new MessageBox(shell);
			mb.setText("提示信息");
			if (list.size() > 0){
				Data.mid = list.get(0).get("muid")+"";
				mb.setMessage("登入成功");
				mb.open();
				shell.dispose();
				Index index = new Index();
				index.open();
	
			} else {
				mb.setMessage("用户名或者密码错误。。。");
				mb.open();
			}
	
		}
}
