package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.Data;
import com.nine.util.MyUtil;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class Useredit1 {

	protected Shell shell;
	private Text text;
	private String photoFile = "";
	private StackLayout stackLayout = new StackLayout();
	DBHelper db = new DBHelper();
	private Label lblNewLabel_1;
	MyUtil mu = new MyUtil();
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private String code = "";
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Useredit1 window = new Useredit1();
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
		shell.setSize(761, 474);
		shell.setText("编辑资料");
		shell.setImage(SWTResourceManager.getImage(About.class, "/images/icon.jpg"));
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setBackgroundImage(SWTResourceManager.getImage(Useredit1.class, "/images/background.jpg"));
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm = new SashForm(composite, SWT.NONE);

		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm_1 = new SashForm(composite_1, SWT.NONE);
		sashForm_1.setOrientation(SWT.VERTICAL);

		Composite composite_3 = new Composite(sashForm_1, SWT.NONE);
		composite_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		composite_3.setLayout(null);

		Label lblNewLabel = new Label(composite_3, SWT.NONE);

		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel.setBounds(42, 126, 175, 32);
		lblNewLabel.setText("编辑头像和用户名");

		Label lblNewLabel_13 = new Label(composite_3, SWT.NONE);
		lblNewLabel_13.setAlignment(SWT.CENTER);
		lblNewLabel_13.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_13.setBounds(42, 205, 175, 32);
		lblNewLabel_13.setText("编辑密码");

		Label lblNewLabel_14 = new Label(composite_3, SWT.NONE);
		lblNewLabel_14.setAlignment(SWT.CENTER);
		lblNewLabel_14.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_14.setBounds(42, 282, 175, 32);
		lblNewLabel_14.setText("编辑邮箱");

		Label lblNewLabel_15 = new Label(composite_3, SWT.NONE);
		lblNewLabel_15.setAlignment(SWT.CENTER);
		lblNewLabel_15.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_15.setBounds(42, 363, 175, 32);
		lblNewLabel_15.setText("返回主页");
		sashForm_1.setWeights(new int[] { 399 });

		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		composite_2.setLayout(new StackLayout());

		Composite composite_5 = new Composite(composite_2, SWT.NONE);
		composite_5.setBackgroundImage(SWTResourceManager.getImage(Useredit1.class, "/images/background.jpg"));
		composite_5.setBackgroundMode(SWT.INHERIT_FORCE);
		composite_5.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));

		lblNewLabel_1 = new Label(composite_5, SWT.BORDER);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(216, 32, 100, 100);

		Label lblNewLabel_2 = new Label(composite_5, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(75, 214, 84, 20);
		lblNewLabel_2.setText("用户名：");

		text = new Text(composite_5, SWT.BORDER);
		text.setEnabled(false);
		text.setBounds(171, 212, 225, 26);

		Button btnNewButton_1 = new Button(composite_5, SWT.NONE);
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_1.setBounds(298, 296, 98, 30);
		btnNewButton_1.setText("完 成");

		Button btnNewButton_2 = new Button(composite_5, SWT.NONE);
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_2.setBounds(218, 157, 98, 30);
		btnNewButton_2.setText("选择头像");

		Button btnNewButton = new Button(composite_5, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton.setBounds(146, 296, 98, 30);
		btnNewButton.setText("编 辑");

		Composite composite_6 = new Composite(composite_2, SWT.NONE);
		composite_6.setBackgroundImage(SWTResourceManager.getImage(Useredit1.class, "/images/background.jpg"));
		composite_6.setBackgroundMode(SWT.INHERIT_FORCE);

		Label lblNewLabel_3 = new Label(composite_6, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_3.setBounds(0, 75, 225, 24);
		lblNewLabel_3.setText("请输入您的新密码：");

		text_1 = new Text(composite_6, SWT.BORDER);
		text_1.setEnabled(false);
		text_1.setBounds(252, 73, 225, 38);

		Label lblNewLabel_4 = new Label(composite_6, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_4.setBounds(0, 133, 246, 26);
		lblNewLabel_4.setText("请再次输入您的密码：");

		text_2 = new Text(composite_6, SWT.BORDER);
		text_2.setEnabled(false);
		text_2.setBounds(252, 124, 225, 39);

		Label lblNewLabel_5 = new Label(composite_6, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_5.setBounds(0, 232, 225, 30);
		lblNewLabel_5.setText("请输入您的验证码：");

		text_3 = new Text(composite_6, SWT.BORDER);
		text_3.setEnabled(false);
		text_3.setBounds(252, 225, 125, 38);

		Button btnNewButton_3 = new Button(composite_6, SWT.NONE);
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_3.setBounds(380, 230, 131, 32);
		btnNewButton_3.setText("获取验证码");

		Button btnNewButton_4 = new Button(composite_6, SWT.NONE);
		btnNewButton_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_4.setBounds(80, 307, 98, 30);
		btnNewButton_4.setText("编 辑");

		Button btnNewButton_5 = new Button(composite_6, SWT.NONE);
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_5.setBounds(272, 307, 98, 30);
		btnNewButton_5.setText("完 成");

		Label lblNewLabel_6 = new Label(composite_6, SWT.NONE);
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_6.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_6.setBounds(0, 269, 462, 20);

		Label lblNewLabel_7 = new Label(composite_6, SWT.NONE);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_7.setBounds(0, 182, 246, 30);
		lblNewLabel_7.setText("请输入您的接受邮箱：");

		text_4 = new Text(composite_6, SWT.BORDER);
		text_4.setEnabled(false);
		text_4.setText("");
		text_4.setBounds(252, 176, 225, 36);

		Composite composite_7 = new Composite(composite_2, SWT.NONE);
		composite_7.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		composite_7.setBackgroundMode(SWT.INHERIT_FORCE);
		composite_7.setBackgroundImage(SWTResourceManager.getImage(Useredit1.class, "/images/background.jpg"));

		Label lblNewLabel_8 = new Label(composite_7, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_8.setBounds(24, 159, 215, 24);
		lblNewLabel_8.setText("请输入您的新邮箱：");

		text_5 = new Text(composite_7, SWT.BORDER);
		text_5.setEnabled(false);
		text_5.setBounds(253, 158, 220, 36);

		Label lblNewLabel_9 = new Label(composite_7, SWT.NONE);
		lblNewLabel_9.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_9.setBounds(0, 202, 237, 24);
		lblNewLabel_9.setText("请输入你的接受邮箱：");

		text_6 = new Text(composite_7, SWT.BORDER);
		text_6.setEnabled(false);
		text_6.setBounds(253, 201, 220, 37);

		Label lblNewLabel_10 = new Label(composite_7, SWT.NONE);
		lblNewLabel_10.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_10.setBounds(75, 255, 164, 30);
		lblNewLabel_10.setText("请输入验证码：");

		text_7 = new Text(composite_7, SWT.BORDER);
		text_7.setEnabled(false);
		text_7.setBounds(253, 254, 124, 37);

		Button btnNewButton_6 = new Button(composite_7, SWT.NONE);
		btnNewButton_6.setEnabled(false);
		btnNewButton_6.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_6.setBounds(383, 256, 128, 29);
		btnNewButton_6.setText("获取验证码");

		Button btnNewButton_7 = new Button(composite_7, SWT.NONE);
		btnNewButton_7.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_7.setBounds(97, 341, 98, 30);
		btnNewButton_7.setText("编 辑");

		Button btnNewButton_8 = new Button(composite_7, SWT.NONE);
		btnNewButton_8.setEnabled(false);
		btnNewButton_8.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_8.setBounds(287, 341, 98, 30);
		btnNewButton_8.setText("完 成");

		Label lblNewLabel_11 = new Label(composite_7, SWT.NONE);
		lblNewLabel_11.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_11.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_11.setBounds(27, 266, 418, 20);

		Label lblNewLabel_12 = new Label(composite_7, SWT.NONE);
		lblNewLabel_12.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_12.setBounds(46, 113, 194, 30);
		lblNewLabel_12.setText("您原来的邮箱为：");

		text_8 = new Text(composite_7, SWT.BORDER);
		text_8.setEnabled(false);
		text_8.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text_8.setBounds(253, 110, 219, 36);
		sashForm.setWeights(new int[] { 227, 513 });
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				stackLayout.topControl = composite_5;

				composite_5.setVisible(true);
				composite_6.setVisible(false);
				composite_7.setVisible(false);

			}
		});
		lblNewLabel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				stackLayout.topControl = composite_6;

				composite_5.setVisible(false);
				composite_6.setVisible(true);
				composite_7.setVisible(false);

			}
		});
		lblNewLabel_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				stackLayout.topControl = composite_7;

				composite_5.setVisible(false);
				composite_6.setVisible(false);
				composite_7.setVisible(true);

			}
		});
		lblNewLabel_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();

			}
		});
		// 选择头像
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
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
					lblNewLabel_1.setImage(image);
				}
			}
		});
		showTX();
		// 编辑用户名和头像编辑按钮点击事件
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnNewButton_2.setEnabled(true);
				btnNewButton_1.setEnabled(true);
				text.setEnabled(true);
			}
		});
		// 编辑用户名和头像中的完成按钮的点击
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String name = text.getText(); // 名字
				String email1 = text_8.getText();
				String sql = "update memberUser set muname = ? ,photoUser = ?  where email=?";
				int result;
				if (name == null) {
					return;
				}
				try {
					if (photoFile == null) { // 如果图片没有更换
						String sql1 = "update memberUser set muname = ?  where email=?";
						result = db.doUpdate(sql1, name,email1);
					} else {
						byte[] b;
						//System.out.println(photoFile);
						BufferedInputStream bis = new BufferedInputStream(new FileInputStream(photoFile));
						b = new byte[bis.available()];
						bis.read(b);
						result = db.doUpdate(sql, name, b,email1);
						if (result > 0) {
							mu.alterMessage(shell, "提示信息", "编辑成功");
						} else {
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
		// 编辑密码中编辑的点击事件
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnNewButton_3.setEnabled(true);
				btnNewButton_5.setEnabled(true);
				text_1.setEnabled(true);
				text_2.setEnabled(true);
				text_3.setEnabled(true);
				text_4.setEnabled(true);

			}
		});
		// 重复密码的失焦事件
		text_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String pwd1 = text_1.getText();
				String repwd1 = text_2.getText();
				if (pwd1 != null && !"".equals(pwd1) && pwd1.equals(repwd1)) {
					lblNewLabel_6.setText("");
					btnNewButton_5.setEnabled(true);
				} else {
					lblNewLabel_6.setText("两次输入的密码不一致");
					btnNewButton_5.setEnabled(false);
				}
			}
		});
		// 编辑密码中发送验证码的点击事件
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String email1 = text_4.getText();
				if ("".equals(email1) || email1 == null) {
					return;
				}
				// 调用发送邮件的方法
				code = mu.senEmail(email1);
				mu.alterMessage(shell, "提示信息", "邮件发送成功");
			}
		});
		// 编辑密码中的完成点击事件
		btnNewButton_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String pwd1 = text_1.getText();
				String mycode = text_3.getText();
				if (!mycode.equals(code)) {
					lblNewLabel_6.setText("验证码输入有问题");
					return;
				}
				String sql = "update memberUser set  pwd = ?  ";
				int result;
				result = db.doUpdate(sql, pwd1);
				if( result > 0 ){
					mu.alterMessage(shell, "提示信息", "修改成功,请重新登录");
					Login1  l1 = new Login1();
					l1.open();
					shell.dispose();					
				}else{
					mu.alterMessage(shell, "提示信息", "修改失败");
				}
			}
		});
		// 编辑邮箱的编辑点击事件
		btnNewButton_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnNewButton_6.setEnabled(true);
				btnNewButton_8.setEnabled(true);
				text_5.setEnabled(true);
				text_6.setEnabled(true);
				text_7.setEnabled(true);
			}
		});
		// 编辑邮箱中发送验证码的点击事件
		btnNewButton_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String email1 = text_6.getText();
				if ("".equals(email1) || email1 == null) {
					return;
				}
				// 调用发送邮件的方法
				code = mu.senEmail(email1);
				mu.alterMessage(shell, "提示信息", "邮件发送成功");
			}
		});
		// 编辑邮箱中的完成点击事件
		btnNewButton_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String email1 = text_5.getText();
				String mycode = text_7.getText();
				if (!mycode.equals(code)) {
					lblNewLabel_6.setText("验证码输入有问题");
					return;
				}
				String sql = "update memberUser set  email = ?  ";
				int result;
				result = db.doUpdate(sql, email1);
				if (email1 == null) {
					return;
				}
			}
		});
		// 邮箱的失去焦点事件
		text_5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String email1 = text_5.getText();
				String sql = "select * from memberUser where email=?";
				List<Map<String, Object>> list = db.findAll(sql, email1);
				if (list.size() > 0) {
					lblNewLabel_11.setText("该邮箱已被注册，请重新输入");
					btnNewButton_8.setEnabled(false);

				} else {
					lblNewLabel_11.setText("");
					btnNewButton_8.setEnabled(true);

				}
			}
		});
		showYX();

	}

	private void showYX() {
		// TODO Auto-generated method stub
		String sql = "select * from memberUser where muid = ? ";
		List<Map<String, Object>> list = db.findAll(sql, Data.mid);
		text_8.setText(list.get(0).get("email") + "");
	}

	private void showTX() {
		// TODO Auto-generated method stub
		// 自动显示头像，用户名
		String sql = "select * from memberUser where muid = ? ";
		List<Map<String, Object>> list = db.findAll(sql, Data.mid);
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream((byte[]) list.get(0).get("photouser"));
			ImageData imageData = new ImageData(bais);
			imageData = imageData.scaledTo(100, 100);
			Image image = new Image(null, imageData);
			lblNewLabel_1.setImage(image);
			text.setText(list.get(0).get("muname") + "");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
