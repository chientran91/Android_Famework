package com.ch.nd.utility;

import android.os.Environment;
import android.text.TextUtils;

import com.ch.nd.app.CApplication;

import java.io.File;

public class FileUtils {

    public static String getFolderApp() {
        String folderApp = Environment.getExternalStorageDirectory() + "/" + Constant.Directory.EXTERNAL_STORAGE_FOLDER_APP;
        File dir = new File(folderApp);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return folderApp;
    }

    /**
     * @param nameDirectory
     * @return
     */
    public static String getDirectoryPath(String nameDirectory) {
        File dir = new File(CApplication.getInstance().getApplicationContext().getExternalCacheDir() + File.separator + nameDirectory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir.getPath();
    }

    public static File getDirectory(String nameDirectory) {
        File dir = new File(getFolderApp() + File.separator + nameDirectory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static String getFileExtension(String path) {
        if (!TextUtils.isEmpty(path)) {
            int dotPos = path.lastIndexOf('.');
            if (0 <= dotPos) {
                return path.substring(dotPos + 1);
            }
        }
        return "";
    }

    public static void purgeDirectory(File dir) {
        if (null != dir && dir.exists()) {
            File[] files = dir.listFiles();
            if (null != files) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        purgeDirectory(file);
                    }
                    if (file.delete()) {
                        Logger.d("purgeDirectory", "\nfile: " + file.getPath());
                    }
                }
            }
        }
    }

}
