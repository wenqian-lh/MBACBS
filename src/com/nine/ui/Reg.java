package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import com.nine.dao.DBHelper;
import com.nine.util.MyUtil;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Reg {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
    private DBHelper db= new DBHelper();
    private MyUtil mu = new MyUtil();
	private String code="";
	private String photoFile="";

	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Reg window = new Reg();
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
		shell.setImage(SWTResourceManager.getImage(About.class, "/images/icon.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(Reg.class, "/images/background.jpg"));
		shell.setSize(612, 641);
		shell.setText("注册");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		label.setBounds(81, 177, 150, 38);
		label.setText("请输入您的账号：");
		
		text = new Text(shell, SWT.BORDER);		
		text.setBounds(254, 176, 200, 35);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(254, 242, 200, 35);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(86, 380, 160, 38);
		lblNewLabel.setText("请输入您的邮箱：");
		
		text_2 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		
		
		text_2.setBounds(254, 305, 200, 35);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(106, 442, 140, 38);
		label_2.setText("请输入验证码：");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(254, 441, 100, 35);
		
		Button button = new Button(shell, SWT.NONE);
		
		button.setBounds(357, 439, 100, 38);
		button.setText("发送验证码");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				
				Login1 login = new Login1();
				login.open();
				
			}
		});
		
		btnNewButton.setBounds(128, 524, 100, 35);
		btnNewButton.setText("返回登陆");
		
		Button reg = new Button(shell, SWT.NONE);
		
		reg.setBounds(357, 524, 100, 35);
		reg.setText("注   册");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setBounds(81, 309, 150, 38);
		lblNewLabel_1.setText("请确认您的密码：");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		text_4.setBounds(254, 379, 200, 35);
		
		Label errorInfo = new Label(shell, SWT.NONE);
		errorInfo.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));		
		errorInfo.setBounds(251, 346, 263, 17);
		
		Label label_3 = new Label(shell, SWT.BORDER);
		label_3.setBounds(255, 10, 100, 100);
		
		Button button_1 = new Button(shell, SWT.NONE);
		
		button_1.setBounds(261, 125, 100, 35);
		button_1.setText("选择头像");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("请输入您的密码：");
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		label_1.setBounds(81, 243, 150, 38);
		
		
        
		//邮箱的失去焦点事件
		text_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String email = text_4.getText();
				String sql = "select*from memberUser where email = ?";
				
				List<Map<String, Object>>list = db.findAll(sql,email);
				if(list.size()>0){
					errorInfo.setText("该邮箱已被注册，请重新输入");
					reg.setEnabled(false);
				}else{
					errorInfo.setText("");
					reg.setEnabled(true);
				}
			}
		});
		//重复密码
		text_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String pwd = text_1.getText();
				String repwd = text_2.getText();
				
				if(pwd!=null && !"".equals(pwd) && pwd.equals(repwd)){
					errorInfo.setText("");
					reg.setEnabled(true);
				}else{
					errorInfo.setText("输入的密码不一致");
					reg.setEnabled(false);
				}
			}
		});
		
		//发送邮件
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String email = text_4.getText();
				if("".equals(email)|| email==null ){
					return;
				}
				
				code =mu.senEmail(email);
				mu.alterMessage(shell,"提示信息","     邮件发送成功");
			}
		});
		//注册的点击事件
		reg.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String muname=text.getText();
				String pwd =text_1.getText();
				String mycode= text_3.getText();
				String email=text_4.getText();
				
				//判断验证码
				if(!mycode.equals(code)){
					errorInfo.setText("验证码输入错误");
					return;
				}
				try {
					BufferedInputStream  bis = new BufferedInputStream( new FileInputStream(photoFile));
					byte[] b = new byte[ bis.available()];
					bis.read(b);
					String sql="insert into memberUser(muid,muname,pwd,email,photoUser,adminUser) values(memberUser_muid.nextval,?,?,?,?,1)";
					int result = db.doUpdate(sql,muname,pwd,email,b);
					
					if(result>0){
						mu.alterMessage(shell, " 提示信息", "注册成功，即将跳转登陆界面");
						shell.dispose();
						
						Login1 login = new Login1();
						login.open();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell);
				fd.setFilterExtensions(new String[]{"*.jpg","*.png"});
				fd.open();
				
				if(fd !=null && !"".equals(fd.getFileName())){
					photoFile = fd.getFilterPath()+"\\"+fd.getFileName();
					//显示图片
					ImageData id=new ImageData(photoFile);
					id = id.scaledTo(100,100);
					Image image= new Image(null,id);
					label_3.setImage(image);
				}
			}
		});
		
		
	}
}
