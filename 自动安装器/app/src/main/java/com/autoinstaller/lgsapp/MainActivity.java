package com.autoinstaller.lgsapp;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.provider.*;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener,DialogInterface.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater mi=getMenuInflater();
		mi.inflate(R.menu.main_menu,menu);
		// TODO: Implement this method
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case R.id.item1:
				Toast.makeText(MainActivity.this,"QQ:3377017440",Toast.LENGTH_LONG).show();
				break;
			case R.id.item2:
				LayoutInflater li=LayoutInflater.from(this);
				View setItemView=li.inflate(R.layout.set_item,null);
				ListView lv=(ListView)setItemView.findViewById(R.id.setitemListView1);
				ArrayAdapter<String> adapter=new ArrayAdapter<String>
				(
					MainActivity.this
					,android.R.layout.simple_list_item_1
					,new String[]
					{
						"打开辅助安装服务"
					}
				);
				lv.setAdapter(adapter);
				lv.setOnItemClickListener(this);
				new AlertDialog.Builder(this)
				.setTitle("设置")
				.setView(setItemView)
				.setCancelable(false)
				.setNegativeButton("关闭",this)
				.show();
				break;
		}
		// TODO: Implement this method
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
	{
		Intent i=new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
		startActivity(i);
		// TODO: Implement this method
	}
	@Override
	public void onClick(DialogInterface p1, int p2)
	{
		// TODO: Implement this method
	}
}
