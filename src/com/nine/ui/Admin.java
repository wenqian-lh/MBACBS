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
import com.nine.util.myUtil;

//import swtl.Index;

import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.widgets.Group;

public class Admin {

	protected Shell shell;
	private Display display;
	private Text text;
	
	private DBHelper db = new DBHelper();
	private myUtil mu = new myUtil();
	
	private Text text_1;
	private Text text_2;
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private Button btnNewButton;
	
	private List<Map<String, Object>> list;
	private Label label_1;
	private Text text_3;
	
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Admin window = new Admin();
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
		shell.setBackgroundImage(SWTResourceManager.getImage(Admin.class, "/images/right.jpg"));
		shell.setSize(539, 439);
		shell.setText("\u6B22\u8FCE\u6765\u5230\u767B\u5165\u754C\u9762");

		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel.setBounds(105, 54, 68, 34);
		lblNewLabel.setText("姓名：");

		text = new Text(shell, SWT.BORDER);
		text.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		text.setBounds(198, 53, 218, 35);

		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(105, 123, 68, 33);
		lblNewLabel_1.setText("密码：");
		

		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(198, 122, 218, 35);
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		
		label_1 = new Label(shell, SWT.NONE);
		label_1.setText("员工密钥：");
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label_1.setBounds(55, 191, 112, 33);
		
		text_3 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		text_3.setBounds(198, 190, 218, 35);
		
		btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));	
		btnNewButton.setBounds(218, 268, 98, 30);
		btnNewButton.setText("\u767B \u5165");
		
		
		
		
		text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println(e.keyCode);
				if (e.keyCode == 13) {
					login();
				}
			}
		});
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				login();
			}	
			});
		
	}
		private void login(){
			// TODO Auto-generated method stub
			// 获取用户名和密码
			String uname = text.getText();
			String pwd = text_1.getText();
			String my = text_3.getText();
			String sql = "select * from  adminUser  where cname=? and pwd=? and cid = ?";
			list = db.findAll(sql, uname,pwd,my);
			if (list.size() > 0) {			
				mu.alterMessage(shell, "提示信息", "登录成功");
				if( (list.get(0).get("superadmin")+"").equals("1") ){ // 判断管理员是否是超级管理员
					guanliyuan gly = new guanliyuan();
					shell.dispose();
					gly.open();			
				}else{
					guanliyuan_common gc = new guanliyuan_common();
					shell.dispose();
					gc.open();					
				}
				
			} else {
					mu.alterMessage(shell, "提示信息", "名字或密码错误");
			}
	
		}
}
