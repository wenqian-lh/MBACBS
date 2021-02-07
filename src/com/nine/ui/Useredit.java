package com.nine.ui;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.Data;
import com.nine.util.MyUtil;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Useredit extends Index{

	protected Shell shell;
	private String photoFile = "";
	DBHelper db = new DBHelper();
	private Label lblNewLabel;
	private Text text;
	private Text text_1;
	private Text text_2;
	MyUtil mu = new MyUtil();
	private Button button;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Useredit window = new Useredit();
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
		shell.setBackgroundImage(SWTResourceManager.getImage(Useredit.class, "/images/background.jpg"));
		shell.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		shell.setSize(392, 506);
		shell.setText("用户编辑");

		lblNewLabel = new Label(shell, SWT.BORDER);
		lblNewLabel.setBounds(134, 10, 100, 100);

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(10, 178, 79, 20);
		lblNewLabel_1.setText("用户名：");

		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(10, 240, 79, 20);
		lblNewLabel_2.setText("密码：");

		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_3.setBounds(10, 307, 76, 20);
		lblNewLabel_3.setText("邮箱：");

		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_3.setBounds(212, 373, 98, 30);
		btnNewButton_3.setText("完 成");

		Button btnNewButton_4 = new Button(shell, SWT.NONE);
		btnNewButton_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_4.setBounds(134, 126, 98, 30);
		btnNewButton_4.setText("选择头像");
		btnNewButton_4.setEnabled(false);

		text = new Text(shell, SWT.BORDER);
		text.setEnabled(false);
		text.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text.setBounds(95, 175, 251, 26);

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setEnabled(false);
		text_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text_1.setBounds(95, 237, 251, 26);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setEnabled(false);
		text_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text_2.setBounds(95, 304, 251, 26);
		
		button = new Button(shell, SWT.NONE);
		
		button.setText("编 辑");
		button.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button.setBounds(46, 373, 98, 30);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell);
				fd.setFilterExtensions(new String[] { "*.jpg", "*.png" });
				fd.open();
				if (fd != null && !"".equals(fd.getFileName())) {
					photoFile = fd.getFilterPath() + "\\" + fd.getFileName();
					// 显示图片
					ImageData id = new ImageData(photoFile);
					id = id.scaledTo(100, 100);
					Image image = new Image(null, id);
					lblNewLabel.setImage(image);
				}
			}
		});
		show();
		//编辑按钮的点击事件
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//启用选择图片按钮和输入框,添加到数据库
				btnNewButton_4.setEnabled(true);
				text.setEnabled(true);
				text_1.setEnabled(true);
				text_2.setEnabled(true);
			}
		});
		
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String name = text.getText(); //名字
				String pwd1 = text_1.getText(); //密码
				String email1 = text_2.getText(); //邮箱
				int result;
				if(name == null || pwd1==null ||email1 == null ){
					return;
				}
				try {
					if( photoFile == null){ //如果图片没有更换
							String sql1 = "update memberUser set muname = ? , pwd = ? , email = ?  where muid = ?";	
							result = db.doUpdate(sql1, name, pwd1, email1, Data.mid);
						}else{
							String sql2 = "update memberUser set muname = ? , pwd = ? , email = ? , photoUser = ? where muid = ?";	
							byte[] b;
							BufferedInputStream bis = new BufferedInputStream( new FileInputStream(photoFile));
							b = new byte[ bis.available() ];
							bis.read(b);
							result = db.doUpdate(sql2, name, pwd1, email1, b, Data.mid);
							if( result > 0){
								mu.alterMessage(shell, "提示信息", "编辑成功");
								//编辑成功禁用选择图片按钮和输入框,添加到数据库
								btnNewButton_4.setEnabled(false);
								text.setEnabled(false);
								text_1.setEnabled(false);
								text_2.setEnabled(false);
								
							}else{
								mu.alterMessage(shell, "提示信息", "编辑失败");
							}
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
		
	}
//自动显示头像，用户名，密码，邮箱
	private void show() {
		// TODO Auto-generated method stub

		String sql = "select * from memberUser where muid = ? ";
		List<Map<String, Object>> list = db.findAll(sql,Data.mid);
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream((byte[]) list.get(0).get("photouser"));
			ImageData imageData = new ImageData(bais);
			imageData = imageData.scaledTo(100, 100);
			Image image = new Image(null, imageData);
			lblNewLabel.setImage(image);
			text_1.setText(list.get(0).get("pwd") + "");
			text.setText(list.get(0).get("muname") + "");
			text_2.setText(list.get(0).get("email") + "");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
