package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.nine.dao.DBHelper;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Ggxq {

	protected Shell shell;
	private Table table;
	DBHelper db = new DBHelper();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Ggxq window = new Ggxq();
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
		shell.setBackgroundImage(SWTResourceManager.getImage(Ggxq.class, "/images/background_6.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setSize(945, 730);
		shell.setText("公告详情");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		table.setBounds(0, 0, 234, 674);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(228);
		tableColumn.setText("公告标题");
		
		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label.setAlignment(SWT.CENTER);
		label.setFont(SWTResourceManager.getFont("黑体", 15, SWT.BOLD));
		label.setBounds(240, 47, 738, 36);
		
		Label label_1 = new Label(shell, SWT.WRAP);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_1.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_1.setBounds(317, 100, 600, 60);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_2.setAlignment(SWT.RIGHT);
		label_2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_2.setBounds(562, 170, 355, 30);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_3.setAlignment(SWT.RIGHT);
		label_3.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_3.setBounds(562, 200, 355, 30);
		showgg();
		
		//表格的点击事件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				TableItem ti = table.getSelection()[0];
				String title = ti.getText()+"";
				String sql = "select * from gg where title = ?";
				List<Map<String, Object>> list = db.findAll(sql, title);
				label.setText( list.get(0).get("title")+"");
				int length = (list.get(0).get("text")+"").length();
				label_1.setBounds(317, 100, 600, ((length / 30) + 1 ) * 20 );
				label_1.setText( "   " + list.get(0).get("text")+"" );
				
				label_2.setBounds(562, label_1.getLocation().y + (((length / 30) + 1 ) * 20) + 10 , 355, 30);
				label_2.setText( list.get(0).get("times")+"" );
				
				label_3.setBounds(562, label_2.getLocation().y + 30 , 355, 30);
				label_3.setText( list.get(0).get("who")+"" );
				
				
			}
		});
		
	}
	
	protected void showgg(){
		TableItem ti;
		String sql = "select *  from gg order by ggid desc";
		List<Map<String , Object >> list = db.findAll(sql, null);
		
		for( int i = 0 ; i < list.size(); i++){
			ti = new TableItem(table , SWT.NONE);
			ti.setText(new String[] { list.get(i).get("title")+""});
		}
	}
}
