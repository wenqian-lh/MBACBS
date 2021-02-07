package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.MyUtil;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AddShang {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	
	DBHelper db = new DBHelper();
	MyUtil mu = new MyUtil();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AddShang window = new AddShang();
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
		shell.setBackgroundImage(SWTResourceManager.getImage(AddShang.class, "/images/background_6.jpg"));
		shell.setSize(689, 600);
		shell.setText("添加诗词");
		
		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label.setBounds(85, 48, 150, 24);
		label.setText("请输入正文：");
		
		text = new Text(shell, SWT.BORDER | SWT.WRAP);
		text.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		text.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text.setBounds(267, 48, 384, 181);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("请输入标题：");
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label_1.setBounds(85, 267, 150, 24);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("请输入作者：");
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label_2.setBounds(85, 332, 150, 24);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("请输入年代：");
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label_3.setBounds(85, 391, 150, 24);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		text_1.setBounds(267, 261, 384, 43);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		text_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text_2.setBounds(267, 323, 193, 43);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		text_3.setBounds(267, 383, 193, 43);
		
		Button button = new Button(shell, SWT.NONE);
		button.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button.setBounds(258, 481, 114, 34);
		button.setText("添 加");

		//添加的点击事件
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String text1 = text.getText();
				String title = text_1.getText();
				String author = text_2.getText();
				String years = text_3.getText();
				
				if( text1 == null | title == null | author == null | years == null ){
					return;
				}
				
				String sql = "insert into shang values(shang_sid.nextval,?,?,?,?)";
				int result = db.doUpdate(sql, text1,title,author,years);
				if( result > 0){
					mu.alterMessage(shell, "提示信息", "添加成功");
					text.setText("");
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
				}else{
					mu.alterMessage(shell, "提示信息", "添加失败");
				}
			}
		});
	}
}
