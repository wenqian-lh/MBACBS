package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.myUtil;

public class deleteguanliyuan {

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
			deleteguanliyuan window = new deleteguanliyuan();
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
		shell.setBackgroundImage(SWTResourceManager.getImage(deleteguanliyuan.class, "/images/background_6.jpg"));
		shell.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		shell.setSize(611, 492);
		shell.setText("删除管理员");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		table.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		table.setBounds(0, 10, 583, 425);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setText("   员工秘钥");
		tblclmnNewColumn.setWidth(183);
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(174);
		tblclmnNewColumn_1.setText("员工名字");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(206);
		tblclmnNewColumn_2.setText("员工密码");
		showAll();
		//表格的点击事件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(e.button==3) {
					Menu menu=new Menu(table);
					table.setMenu(menu);
					MenuItem mi=new MenuItem(menu,SWT.NONE);
					mi.setText("删除员工");
					mi.addListener(SWT.Selection,new Listener(){
						@Override
						public void handleEvent(Event arg0) {
							//TODO Auto-generated method stub
							TableItem ti = table.getSelection()[0];
							String cid = ti.getText()+"";
							String sql = "delete from adminUser where cid = ? ";
							int result = db.doUpdate(sql, cid);
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
		String sql = "select * from adminUser where superAdmin = 2 ";
		List<Map<String, Object>> list = db.findAll(sql);
		TableItem ti = null;
		for (int i = 0; i < list.size(); i++) {
			ti = new TableItem(table, SWT.NONE);
			ti.setText(0, list.get(i).get("cid").toString());
			ti.setText(1, list.get(i).get("cname").toString());
			ti.setText(2, list.get(i).get("pwd").toString());
		}

	}
}
