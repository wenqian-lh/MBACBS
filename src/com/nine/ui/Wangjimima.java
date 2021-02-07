package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.MyUtil;

import org.eclipse.swt.widgets.Label;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class Wangjimima {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private MyUtil mu = new MyUtil();
    private String code="";
    private DBHelper db= new DBHelper();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Wangjimima window = new Wangjimima();
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
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setImage(SWTResourceManager.getImage(About.class, "/images/icon.jpg"));
		shell.setBackgroundImage(SWTResourceManager.getImage(Wangjimima.class, "/images/background.jpg"));
		shell.setSize(612, 641);
		shell.setText("忘记密码");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_1.setText("请输入验证码：");
		lblNewLabel_1.setBounds(46, 411, 160, 30);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(46, 232, 160, 30);
		lblNewLabel_2.setText("请输入新密码：");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_3.setBounds(46, 323, 160, 30);
		lblNewLabel_3.setText("请确认新密码：");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(20, 146, 187, 27);
		label.setText("请输入注册邮箱：");
		
		Button button = new Button(shell, SWT.NONE);
		button.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		
		button.setBounds(111, 503, 95, 37);
		button.setText("返回登录");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		
		button_1.setBounds(340, 503, 95, 37);
		button_1.setText("确认修改");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(223, 145, 286, 35);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(223, 410, 171, 35);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(223, 231, 257, 35);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		
		text_3.setBounds(223, 322, 257, 35);
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		
		
		button_2.setBounds(410, 408, 112, 37);
		button_2.setText("发送验证码");
		
		Label errorInfo = new Label(shell, SWT.NONE);
		errorInfo.setBounds(252, 373, 257, 17);
		
		Label errorInfo1 = new Label(shell, SWT.NONE);
		errorInfo1.setBounds(252, 457, 130, 17);
        button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
              shell.dispose();
				
		      Login1 login = new Login1();	
	          login.open();
			}
		});
        
        //重复密码
        text_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String pwd = text_2.getText();
				String repwd = text_3.getText();
				
				if(pwd!=null&&!"".equals(pwd)&&pwd.equals(repwd)){
					errorInfo.setText("");
					button_1.setEnabled(true);
				}else{
				    errorInfo.setText("输入的密码不一致");
				    button_1.setEnabled(false);
					
				}
			}
		});
		
        //发送邮件
        button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String email = text.getText();
				if("".equals(email)|| email==null ){
					return;
				}
				
				code =mu.senEmail(email);
				mu.alterMessage(shell,"提示信息","     邮件发送成功");
			}
		});
        button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String Mypwd =text_2.getText();
				String mycode= text_1.getText();
				String Email=text.getText();
				
				//判断验证码
				if(!mycode.equals(code)){
					errorInfo1.setText("验证码输入错误");
					return;
				}
				String sql="Update memberUser set pwd=? where  email= ? ";
				int result = db.doUpdate(sql,Mypwd,Email);
				
				if(result>0){
					mu.alterMessage(shell, " 提示信息", "密码修改成功，即将跳转登陆界面");
					shell.dispose();
					
					Login1 login = new Login1();
					login.open();
				}
				
					
			}
		});
		
   }    
}
