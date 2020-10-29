package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.myUtil;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class addguanliyuan {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private DBHelper db = new DBHelper();
	private myUtil mu = new myUtil();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			addguanliyuan window = new addguanliyuan();
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
		shell.setBackgroundImage(SWTResourceManager.getImage(addguanliyuan.class, "/images/background_6.jpg"));
		shell.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		shell.setSize(581, 423);
		shell.setText("添加管理员");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel.setBounds(10, 28, 235, 24);
		lblNewLabel.setText("请输入员工秘钥：");
		
		text = new Text(shell, SWT.BORDER);
		text.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(251, 26, 214, 26);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(10, 106, 235, 24);
		lblNewLabel_1.setText("请输入员工的名字：");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(251, 104, 214, 26);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(10, 175, 235, 24);
		lblNewLabel_2.setText("请输入员工的密码：");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_2.setBounds(251, 173, 214, 26);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton.setBounds(208, 267, 98, 30);
		btnNewButton.setText("添 加");
		//添加的点击事件和添加的完成事件
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String cid1 = text.getText();
				String cname1 = text_1.getText();
				String pwd1 = text_2.getText();
				String sql = "insert into adminUser(cid,cname,pwd,superAdmin) values(?,?,?,2) ";
				int result = db.doUpdate(sql, cid1, cname1, pwd1);
				if (result > 0) {
					mu.alterMessage(shell, "提示信息", "添加成功");
					text.setText("");
					text_1.setText("");
					text_2.setText("");

				}
			}
		});

	}
}
