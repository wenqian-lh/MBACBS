package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.myUtil;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class addactivity {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private DBHelper db = new DBHelper();
	private String photoFile = "";
	private myUtil mu = new myUtil();

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			addactivity window = new addactivity();
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
		shell.setImage(SWTResourceManager.getImage(about.class, "/images/icon.jpg"));
		shell.setBackgroundImage(SWTResourceManager.getImage(addactivity.class, "/images/background_6.jpg"));
		shell.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		shell.setSize(869, 515);
		shell.setText("添加展览");

		Label lblNewLabel = new Label(shell, SWT.BORDER);
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel.setBounds(10, 10, 300, 300);

		Button btnNewButton = new Button(shell, SWT.NONE);

		btnNewButton.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton.setBounds(87, 331, 105, 30);
		btnNewButton.setText("选择图片");

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(340, 109, 193, 30);
		lblNewLabel_1.setText("请输入展览名称：");

		text = new Text(shell, SWT.BORDER);
		text.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		text.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text.setBounds(562, 105, 263, 35);

		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(347, 182, 200, 35);
		lblNewLabel_2.setText("请输入展览时间：");

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		text_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text_1.setText("");
		text_1.setBounds(562, 182, 263, 35);

		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_3.setBounds(343, 257, 193, 35);
		lblNewLabel_3.setText("请输入展览地点：");

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		text_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text_2.setText("");
		text_2.setBounds(562, 255, 263, 35);

		Button btnNewButton_1 = new Button(shell, SWT.NONE);

		btnNewButton_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton_1.setBounds(555, 357, 105, 35);
		btnNewButton_1.setText("添 加");
		// 添加
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String uname = text.getText();
				String time1 = text_1.getText();
				String site1 = text_2.getText();

				try {
					BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(photoFile));
					byte[] bs1 = new byte[bis1.available()];
					bis1.read(bs1);
					String sql = "insert into addactivity values(addactivity_acid.nextval,?,?,?,?) ";
					int result = db.doUpdate(sql, uname, time1, site1, bs1);
					if (result > 0) {
						mu.alterMessage(shell, "提示信息", "添加成功");
						text.setText("");
						text_1.setText("");
						text_2.setText("");

						lblNewLabel.setImage(null);

					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		// 添加图片点击事件
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell);
				fd.setFilterExtensions(new String[] { "*.jpg", "*.png" });
				fd.open();
				if (fd != null && !"".equals(fd.getFileName())) {
					photoFile = fd.getFilterPath() + "\\" + fd.getFileName();
					// 显示图片
					ImageData id = new ImageData(photoFile);
					id = id.scaledTo(300, 300);
					Image image = new Image(null, id);
					lblNewLabel.setImage(image);

				}

			}
		});

	}
}
