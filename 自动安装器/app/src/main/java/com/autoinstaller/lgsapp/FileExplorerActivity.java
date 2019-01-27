package com.autoinstaller.lgsapp;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.util.*;

public class FileExplorerActivity extends Activity implements AdapterView.OnItemClickListener
{
	
	ListView lv;
	SimpleAdapter sa;
	List<Map<String,Object>>list=new ArrayList<>();
	String rootPath=Environment.getExternalStorageDirectory().getPath();
	String path=rootPath;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
	setContentView(R.layout.file_explorer_activity);
		lv=(ListView)findViewById(R.id.fileexploreractivityListView1);
	sa=new SimpleAdapter
	(
		FileExplorerActivity.this
		,list
		,R.layout.list_item_of_file_explorer_activity
		,new String[]
			{
				"pic","name"
			}
		,new int[]
			{
				R.id.listitemoffileexploreractivityImageView1,R.id.listitemoffileexploreractivityTextView1
			}
	);
		lv.setAdapter(sa);
		lv.setOnItemClickListener(this);
		updatelist(path);
	}

	protected void updatelist(String path)
	{
		setTitle(path);
		list.clear();
		File[] file=new File(path).listFiles();
		if(file!=null)
		{
			for(File files:file)
			{
				Map<String,Object>map=new HashMap<>();
				if(files.isDirectory()){map.put("pic",R.drawable.wenjianjia);}
				else{
					String filePath=files.getPath();
					String[]filePathArray=filePath.split("\\.");
					int arrayLen=filePathArray.length;
					if("apk".equalsIgnoreCase(filePathArray[arrayLen-1]))
					{
map.put("pic",R.drawable.apk);
					}
					else{
						//new AlertDialog.Builder(getApplication()).setMessage("未知类型").show();
					
					map.put("pic",R.drawable.unknown);
					}
					
					}
				map.put("name",files.getName());
				map.put("path",files.getPath());
				list.add(map);
			}
			sa.notifyDataSetChanged();
		}
			
	}
	@Override
	public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
	{
		String path=(String)list.get(p3).get("path");
		File filess=new File(path);
		if(filess.isDirectory())
		{updatelist(path);}
		else{
			String filePath=filess.getPath();
			String[]filePathArray=filePath.split("\\.");
			int arrayLen=filePathArray.length;
			if("apk".equalsIgnoreCase(filePathArray[arrayLen-1]))
			{
				
			}
			else{
				new AlertDialog.Builder(this).setMessage("未知类型").show();
			}
		}
		// TODO: Implement this method
	}

	@Override
	public void onBackPressed()
	{
		// TODO: Implement this method
		
		if(path.equals(rootPath))
		{
			super.onBackPressed();
		}
		else{
			File filesss=new File(path);
			path=filesss.getParentFile().getPath();
			updatelist(path);
		}
	}

	
	
	
}
