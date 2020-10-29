package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.myUtil;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class deletepoem {

	protected Shell shell;
	private Table table;
	private DBHelper db = new DBHelper();
	private myUtil mu = new myUtil();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			deletepoem window = new deletepoem();
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
		shell.setImage(SWTResourceManager.getImage(deletepoem.class, "/images/icon.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(deletepoem.class, "/images/background.jpg"));
		shell.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		shell.setSize(739, 642);
		shell.setText("删除诗词");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		table.setBounds(0, 0, 717, 586);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setText("         编号");
		tblclmnNewColumn.setWidth(343);
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(365);
		tblclmnNewColumn_1.setText("标题");
		showAll();
		//表格的点击事件
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						if(e.button==3) {
							Menu menu=new Menu(table);
							table.setMenu(menu);
							MenuItem mi=new MenuItem(menu,SWT.NONE);
							mi.setText("删除诗词");
							mi.addListener(SWT.Selection,new Listener(){
								@Override
								public void handleEvent(Event arg0) {
									//TODO Auto-generated method stub
									TableItem ti = table.getSelection()[0];
									String sid = ti.getText()+"";
									String sql = "delete from shang where sid = ? ";
									int result = db.doUpdate(sql, sid);
									if( result > 0){
										mu.alterMessage(shell, "提示信息", "删除成功");
										showAll();
									}else{
										mu.alterMessage(shell, "提示信息", "删除失败");
									}
								}
							});
						}
					}
				});
	}

	private void showAll() {
		// TODO Auto-generated method stub
		table.removeAll();
		String sql = "select * from shang";
		List<Map<String, Object>> list = db.findAll(sql);
		TableItem ti = null;
		for (int i = 0; i < list.size(); i++) {
			ti = new TableItem(table, SWT.NONE);
			ti.setText(0, list.get(i).get("sid").toString());
			ti.setText(1, list.get(i).get("title").toString());
		}

	}
}
