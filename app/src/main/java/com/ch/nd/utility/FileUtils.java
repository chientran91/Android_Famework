package com.ch.nd.utility;

import android.os.Environment;
import android.text.TextUtils;

import com.ch.nd.app.CApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileUtils {

    public static File getDirectory(File parent, String name) {
        File dir = new File(parent + File.separator + name);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir;
    }

    public static String getAbsolutePath(File parent, String name) {
        return getDirectory(parent, name).getAbsolutePath();
    }

    public static File getExternalStorageDirectory() {
        String path = Environment.getExternalStorageDirectory() + File.separator + Constant.Directory.EXTERNAL_STORAGE_ENVIRONMENT;
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static File getDirectoryApp() {
        return CApplication.getInstance().getExternalFilesDir(null);
    }

    public static File getTempDirectory(String fileName) {
        File dir = new File(getDirectoryApp() + File.separator + fileName);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir;
    }

    public static String getAbsolutePathTemp(String fileName) {
        return getTempDirectory(fileName).getAbsolutePath();
    }


    public static String getAbsolutePathTempImage() {
        File dir = new File(getDirectoryApp() + File.separator + Constant.Directory.IMAGE);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir.getPath();
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

    public static String getFileName(String filePath) {
        String fileName;
        if (TextUtils.isEmpty(filePath)) {
            fileName = null;
        } else {
            int position = filePath.lastIndexOf(File.separator);
            if (position == -1) {
                return null;
            }
            fileName = filePath.substring(position + 1);
            if (TextUtils.isEmpty(fileName)) {
                return null;
            }
        }
        return fileName;
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

    public static boolean copyFile(File srcFile, String savePath) {
        FileInputStream source = null;
        FileOutputStream destination = null;

        try {
            source = new FileInputStream(srcFile);
            destination = new FileOutputStream(savePath);

            FileChannel sourceFileChannel = source.getChannel();
            FileChannel destinationFileChannel = destination.getChannel();

            long size = sourceFileChannel.size();
            sourceFileChannel.transferTo(0, size, destinationFileChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != source) source.close();
                if (null != destination) destination.close();
                return true;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String loadFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(path);

            FileInputStream fis = new FileInputStream(file);
            FileChannel fileChannel = fis.getChannel();

            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();

            ByteBuffer buff = ByteBuffer.allocateDirect(1024);
            CharBuffer charBuff = CharBuffer.allocate(1024);
            while (fileChannel.read(buff) != -1) {
                buff.flip();
                decoder.decode(buff, charBuff, false);
                charBuff.flip();
                sb.append(charBuff.toString());
                buff.clear();
                charBuff.clear();
            }

            fis.close();

            fileChannel.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }

    private static boolean saveFile(File file, byte[] data) {
        boolean ret = false;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            FileChannel fileChannel = fos.getChannel();

            ByteBuffer buffer = ByteBuffer.wrap(data);

            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }

            fileChannel.close();
            fos.close();
            ret = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static boolean saveFile(String path, byte[] data) {
        return saveFile(new File(path), data);
    }

    public static boolean saveFile(String dir, String name, byte[] data) {
        return saveFile(new File(dir, name), data);
    }
}
