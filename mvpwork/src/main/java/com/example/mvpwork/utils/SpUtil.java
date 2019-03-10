package com.example.mvpwork.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mvpwork.base.BaseApp;

//Sharepreference
public class SpUtil {
    /**
	 * 保存在手机里面的文件名
	 */
	private static final String FILE_NAME = "share_date";
	
	
	/**
	 * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
	 * @param key
	 * @param object 
	 */
	public static void setParam( String key, Object object){
		
		String type = object.getClass().getSimpleName();
		SharedPreferences sp = BaseApp.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		
		if("String".equals(type)){
			editor.putString(key, (String)object);
		}
		else if("Integer".equals(type)){
			editor.putInt(key, (Integer)object);
		}
		else if("Boolean".equals(type)){
			editor.putBoolean(key, (Boolean)object);
		}
		else if("Float".equals(type)){
			editor.putFloat(key, (Float)object);
		}
		else if("Long".equals(type)){
			editor.putLong(key, (Long)object);
		}
		
		editor.commit();
	}
	
	
	/**
	 * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
	 * @param key
	 * @param defaultObject
	 * @return
	 */
	public static Object getParam(String key, Object defaultObject){
		String type = defaultObject.getClass().getSimpleName();
		SharedPreferences sp = BaseApp.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
		
		if("String".equals(type)){
			return sp.getString(key, (String)defaultObject);
		}
		else if("Integer".equals(type)){
			return sp.getInt(key, (Integer)defaultObject);
		}
		else if("Boolean".equals(type)){
			return sp.getBoolean(key, (Boolean)defaultObject);
		}
		else if("Float".equals(type)){
			return sp.getFloat(key, (Float)defaultObject);
		}
		else if("Long".equals(type)){
			return sp.getLong(key, (Long)defaultObject);
		}
		
		return null;
	}
}