package com.nine.util;

import java.io.ByteArrayInputStream;
import java.util.Map;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.ui.DeleteAndeditorCp;
import com.nine.ui.ShowCangpin1;

public class AutoGroup {
	
	int x = 0;
	int y = 0;
	
	/**
	 * 自动生成group对象
	 * @param composite group所在面板
	 * @param map 	group里面的数据
	 */
	public void createGroup(Composite composite, Map<String , Object> map){
		Group group = new Group(composite , SWT.NONE);
		
		group.setBounds(0 + 405 * x, 0 + 505 * y, 400, 500);
		if(  x % 2 != 0){
			x = 0;
			y++;
		}else{
			x++;
		}
		
		//composite.setBackgroundImage(SWTResourceManager.getImage(showCangpin1.class, "/images/background_right.jpg"));
		
		Label label = new Label(group, SWT.NONE | SWT.WRAP);
		label.setBounds(0, 0, 400, 400);
		ByteArrayInputStream bais = new ByteArrayInputStream( (byte[]) map.get("photo")); 
		ImageData imageData = new ImageData(bais);
		imageData = imageData.scaledTo(400, 400);
		Image image = new Image(null,imageData);
		label.setImage(image);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		label_1.setAlignment(SWT.RIGHT);
		label_1.setText(map.get("cpname")+"");
		label_1.setBounds(0, 406, 400, 37);
		
		Label label_2 = new Label(group, SWT.NONE | SWT.RIGHT);
		label_2.setFont(SWTResourceManager.getFont("微软雅黑", 9, SWT.BOLD));
		label_2.setText("文物号:" + map.get("cpid") + "  " + "年代:" + map.get("years") + " ");
		label_2.setBounds(0, 453, 400, 37);	
		//点击查看详情
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				label.setFont(SWTResourceManager.getFont("微软雅黑", 9, SWT.BOLD ));
				label.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
				label.setBackgroundImage(SWTResourceManager.getImage(DeleteAndeditorCp.class, "/images/background_right.jpg"));
				label.setText( map.get("detail")+"");
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				label.setImage(image);
			}

		});
	}

}
