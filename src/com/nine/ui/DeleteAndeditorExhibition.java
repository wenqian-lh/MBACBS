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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.MyUtil;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class DeleteAndeditorExhibition {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private DBHelper db = new DBHelper();
	private String photoFile = "";
	private MyUtil mu = new MyUtil();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DeleteAndeditorExhibition window = new DeleteAndeditorExhibition();
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
		shell.setBackgroundImage(SWTResourceManager.getImage(DeleteAndeditorExhibition.class, "/images/background_6.jpg"));
		shell.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		shell.setSize(931, 588);
		shell.setText("修改和删减展览");

		Label label = new Label(shell, SWT.BORDER);
		label.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label.setBounds(10, 10, 300, 300);

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
		btnNewButton_1.setBounds(608, 461, 105, 35);
		btnNewButton_1.setText("修 改");
		
		Button button = new Button(shell, SWT.NONE);
		
		button.setBounds(831, 105, 68, 34);
		button.setText("查询");
		
		Button button_1 = new Button(shell, SWT.NONE);
		
		button_1.setText("编 辑");
		button_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button_1.setBounds(402, 461, 105, 35);
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setText("删 除");
		button_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button_2.setBounds(183, 461, 105, 35);
		
		//查询
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String name = text.getText();
				if( name == null){
					button.setEnabled(false);
				}
				String sql = "select * from addactivity where name = ?";
				List<Map<String , Object>> list = db.findAll(sql, name);
				
				ByteArrayInputStream bais = new ByteArrayInputStream( (byte[]) list.get(0).get("photo"));
				ImageData imageData = new ImageData( bais );
				imageData = imageData.scaledTo(400, 320);
				Image image = new Image(null , imageData);
				label.setImage(image);
				
				text_1.setText(list.get(0).get("time")+"");
				text_2.setText(list.get(0).get("site")+"");
				
				//禁用选择图片按钮和输入框
				btnNewButton.setEnabled(false);
				text.setEnabled(false);
				text_1.setEnabled(false);
				text_2.setEnabled(false);
			}
		});
		
		//编辑
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//启用选择图片按钮和输入框
				btnNewButton.setEnabled(true);
				text.setEnabled(true);
				text_1.setEnabled(true);
				text_2.setEnabled(true);
			}
		});
		
		// 添加
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String uname = text.getText();
				String time1 = text_1.getText();
				String site1 = text_2.getText();
				int result;

				try {
					if( photoFile == null ){
						String sql = "update addactivity set name = ? , time = ? , site = ? where name = ?";
						result = db.doUpdate(sql, uname , time1 , site1 , uname);
					}
					BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(photoFile));
					byte[] bs1 = new byte[bis1.available()];
					bis1.read(bs1);
					String sql = "update addactivity set name = ? , time = ? , site = ? , photo = ? where name = ?";
					result = db.doUpdate(sql, uname , time1 , site1 , bs1 , uname);
					if (result > 0) {
						mu.alterMessage(shell, "提示信息", "修改成功");
						text.setText("");
						text_1.setText("");
						text_2.setText("");
						label.setImage(null);
					}else{
						mu.alterMessage(shell, "提示信息", "修改失败");
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
					label.setImage(image);

				}

			}
		});

	}

}
