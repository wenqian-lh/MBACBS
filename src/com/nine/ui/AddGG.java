package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.text.SimpleDateFormat;
import com.nine.dao.DBHelper;
import com.nine.util.MyUtil;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AddGG {

	protected Shell shell;
	private Text text_1;
	private Text text_2;
	private Text text;
	MyUtil mu = new MyUtil();
	DBHelper db = new DBHelper();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AddGG window = new AddGG();
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
		shell.setBackgroundImage(SWTResourceManager.getImage(AddGG.class, "/images/background_6.jpg"));
		shell.setSize(720, 603);
		shell.setText("添加公告");
		
		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label.setBounds(79, 129, 196, 36);
		label.setText("请输入公告内容:");
		
		text_1 = new Text(shell, SWT.BORDER | SWT.WRAP);
		text_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		text_1.setBounds(275, 129, 413, 253);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("请输入发布单位:");
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label_2.setBounds(79, 407, 196, 36);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		text_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text_2.setBounds(275, 404, 335, 36);
		
		Button button = new Button(shell, SWT.NONE);
		
		button.setBounds(275, 487, 114, 34);
		button.setText("发  布");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("请输入公告标题:");
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label_3.setBounds(79, 70, 196, 36);
		
		text = new Text(shell, SWT.BORDER);
		text.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		text.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		text.setBounds(275, 67, 335, 36);

		//发布按钮的点击事件
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String title = text.getText();
				String text1 = text_1.getText();
				String who = text_2.getText();
				//判断是否为空
				if( title == null || text1 == null || who == null ){
					return;
				}
					String sql = "insert into gg values(gg_ggid.nextval , ? , ? , ? , ?)";
					String date = sdf.format( new Date());
					int result = db.doUpdate(sql, title , date , text1 , who);
					if( result > 0){
				
						mu.alterMessage(shell, "提示信息", "添加成功");
						text.setText("");
						text_1.setText("");
						text_2.setText("");
					}else{
						mu.alterMessage(shell, "提示信息", "添加失败");
					}
				}
			
		});
	}
}
