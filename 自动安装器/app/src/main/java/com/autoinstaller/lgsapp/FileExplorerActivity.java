package com.autoinstaller.lgsapp;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.util.*;

public class FileExplorerActivity extends Activity implements AdapterView.OnItemClickListener
{
	String rootPath=Environment.getExternalStorageDirectory().getPath();
	String path=rootPath;
	ListView lv;
	SimpleAdapter sa;
	List<Map<String,Object>>list=new ArrayList<>();
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

	private void updatelist(String path)
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
				else{map.put("pic",R.drawable.apk);}
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
		// TODO: Implement this method
	}

	
	
	
}
