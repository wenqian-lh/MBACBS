package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Composite;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.AutoGroup;
import com.nine.util.MyUtil;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class ShowCangpin1 {

	protected Shell shell;
	private StackLayout stackLayout = new StackLayout();
	private ScrolledComposite scrolledComposite;
	private Tree tree;TreeItem treeItem ;
	private Composite composite_x = null;
	MyUtil mu = new MyUtil();
	DBHelper db = new DBHelper();
	AutoGroup ag = new AutoGroup();
	private Composite composite_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ShowCangpin1 window = new ShowCangpin1();
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
		shell.setSize(1000, 732);
		shell.setText("数字文物库");
		shell.setLayout(new FormLayout());
		shell.setImage(SWTResourceManager.getImage(About.class, "/images/icon.jpg"));
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		fd_composite.bottom = new FormAttachment(0, 674);
		fd_composite.right = new FormAttachment(0, 978);
		composite.setLayoutData(fd_composite);
		
		SashForm sashForm = new SashForm(composite, SWT.NONE);
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackgroundMode(SWT.INHERIT_DEFAULT);
		tree = new Tree(composite_1, SWT.BORDER);
		tree.setBackgroundImage(SWTResourceManager.getImage(ShowCangpin1.class, "/images/background_left.jpg"));
		
		tree.setBounds(0, 0, 139, 674);
		
		treeItem = new TreeItem(tree, SWT.NONE);
		treeItem.setText(new String[] {});
		treeItem.setFont(SWTResourceManager.getFont("楷体", 13, SWT.BOLD));
		treeItem.setText("藏品分类");
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setLayout(stackLayout);
		
		scrolledComposite = new ScrolledComposite(composite_2, SWT.BORDER  | SWT.V_SCROLL);
		//scrolledComposite.setBackgroundImage(SWTResourceManager.getImage(showCangpin1.class, "/images/background_right.jpg"));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		composite_3 = new Composite(composite_2, SWT.NONE);
		composite_3.setBackgroundImage(SWTResourceManager.getImage(ShowCangpin1.class, "/images/background_right.jpg"));
		sashForm.setWeights(new int[] {139, 836});
		showType();
		
		//选中事件
		tree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem ti = (TreeItem)e.item;
				String type = ti.getText();

				if( "藏品分类".equals(type) ){
					type = "绘画";
				}
				String sql = "select p.cpid, p.cpname, p.years, p.photo , p.detail from cangpin p , cptype t where t.cname = ? and p.ctype = t.cid";
				List<Map<String , Object>> list = db.findAll(sql, type);
				stackLayout.topControl = scrolledComposite;
				scrolledComposite.setVisible(true);
				//内容放在composite_x中，滚动面板只负责滚动
				composite_x = new Composite(scrolledComposite,SWT.NONE);
				scrolledComposite.setContent(composite_x);
				
				//设置滚动面板的最小大小，高度是动态，随着内容的变多而增高
				scrolledComposite.setMinSize(805, 505 * (list.size()/2 + 1));
				AutoGroup ag = new AutoGroup();
				for(int i = 0; i < list.size(); i++){
	
					ag.createGroup(composite_x, list.get(i));
					
				}
			}
		});
		
	}
	//显示全部藏品分类
	protected void showType(){
		String sql = "select cname from cptype";
		TreeItem ti = null;
		List<Map<String , Object>> list = db.findAll(sql);
		for(int i = 0; i < list.size(); i ++){
			ti = new TreeItem(treeItem ,SWT.NONE);
			ti.setFont(SWTResourceManager.getFont("楷体", 11, SWT.BOLD));
			ti.setText(list.get(i).get("cname")+"");
			ti.setData(i+1);
		}
	}
	
}
