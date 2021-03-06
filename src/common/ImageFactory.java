package common;

import java.io.File;

import utils.ToolsUtil;
import android.graphics.Bitmap;
import android.os.Environment;

public class ImageFactory {
	private final static String ALBUM_PATH  
    = Environment.getExternalStorageDirectory() + "/imgcache/";  
	private static ImageFactory instance=null;
	
	private ImageFactory(){
		
	}
	
	public static ImageFactory getInstance(){
		if(instance==null){
			instance=new ImageFactory();
		}
		return instance;
	}
	
	public Bitmap getBitmap(String url){
		Bitmap b=null;
		String urlMd5=ToolsUtil.encryption(url);
		
		File f=new File(ALBUM_PATH+urlMd5);
		if(f.exists()==false){
			
		}
		return b;
	}
	
}
