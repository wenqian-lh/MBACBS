package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.nine.dao.DBHelper;
import com.nine.util.myUtil;

import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Dropgg {

	protected Shell shell;
	private Table table;
	private DBHelper db= new DBHelper();
	private myUtil mu = new myUtil();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Dropgg window = new Dropgg();
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
		shell.setBackgroundImage(SWTResourceManager.getImage(Dropgg.class, "/images/background.jpg"));
		shell.setSize(666, 438);
		shell.setText("删除公告");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		
		table.setBackgroundImage(SWTResourceManager.getImage(Dropgg.class, "/images/background.jpg"));
		table.setBounds(0, 0, 650, 425);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn  tblclmnNewColumn= new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("        编号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(284);
		tblclmnNewColumn_1.setText("标题");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(110);
		tblclmnNewColumn_2.setText("日期");
		
		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setText("            发布部门");
		tableColumn.setWidth(151);
		
		showAllgg();
		
		
 }
       //展示所有公告
	private void showAllgg() { 
		//展示之前清空表格内容
		table.removeAll();
		// TODO Auto-generated method stub
		String sql="select*from gg";
		
		List<Map<String, Object>> list = db.findAll(sql);
		
		TableItem ti;
		for (int i = 0; i < list.size(); i++) {
			
			ti = new TableItem(table, SWT.NONE);
			ti.setText(0, list.get(i).get("ggid")+"");
			ti.setText(1, list.get(i).get("title")+"");
			ti.setText(2, list.get(i).get("times")+"");

			ti.setText(3, list.get(i).get("who")+"");
		}
		//表格的右键菜单
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(e.button==3){
					Menu menu=new Menu(table);
					table.setMenu(menu);
					MenuItem mi=new MenuItem(menu,SWT.NONE);
					mi.setText("删除");
					
					mi.addListener(SWT.Selection,new Listener(){
						@Override
						public void handleEvent(Event arg0){
							// TODO Auto-generated method stub
							TableItem ti= table.getSelection()[0];
							String ggid= ti.getText()+"";
							String sql="delete from gg where ggid=?";
							int result = db.doUpdate(sql,ggid);
							if(result>0){
								mu.alterMessage(shell, " 提示信息", "删除成功");
								showAllgg();
							}else{
								mu.alterMessage(shell, " 提示信息", "删除失败");
							}
	
							
						}
					
				});
			 }
			}
		});
		
	}
}
