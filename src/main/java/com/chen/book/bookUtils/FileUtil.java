package com.chen.book.bookUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FileUtil {
	private static String seperator = System.getProperty("file.separator");
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat(
			"yyyyMMddHHmmss"); // 时间格式化的格式
	private static final Random r = new Random();

	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/software/IdeaProjects/book/image/";
		} else {
			basePath = "/home/xiangzepro/";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}


	
	public static String getUserPicImagePath() {
		String userPicImagePath = "/upload/images/user/";
		userPicImagePath = userPicImagePath.replace("/", seperator);
		return userPicImagePath;
	}

	public static String getBookImagePath(long shopId) {
		StringBuilder bookImagePathBuilder = new StringBuilder();
		bookImagePathBuilder.append("upload/images/book/");
		bookImagePathBuilder.append(shopId);
		bookImagePathBuilder.append("/");
		String bookImagePath = bookImagePathBuilder.toString().replace("/",
				seperator);
		return bookImagePath;
	}

	public static String getRandomFileName() {
		// 生成随机文件名：当前年月日时分秒+五位随机数（为了在实际项目中防止文件同名而进行的处理）
		int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // 获取随机数
		String nowTimeStr = sDateFormat.format(new Date()); // 当前时间
		return nowTimeStr + rannum;
	}

	public static void deleteFile(String storePath) {
		File file = new File(getImgBasePath() + storePath);
		if (file.exists()) {
			if (file.isDirectory()) {
				File files[] = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					files[i].delete();
				}
			}
			file.delete();
		}
	}
}
