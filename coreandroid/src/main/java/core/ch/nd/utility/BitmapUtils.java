package core.ch.nd.utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileOutputStream;

public class BitmapUtils {

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if ((reqWidth <= 0) || (reqHeight <= 0)) {
            return inSampleSize;
        }
        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((height / inSampleSize) > reqHeight
                || (width / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
        return inSampleSize;
    }

    public static String resizeBitmap(String photoPath, int reqWidth, int reqHeight) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(photoPath, bmOptions);
        int scale = calculateInSampleSize(bmOptions, reqWidth, reqHeight);
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scale;
        bmOptions.inPurgeable = true; //Deprecated API 21
        return saveBitmap(BitmapFactory.decodeFile(photoPath, bmOptions), photoPath);
    }

    public static String saveBitmap(Bitmap finalBitmap, String dir, String fileName) {
        return saveBitmap(finalBitmap, new File(dir, fileName));
    }

    public static String saveBitmap(Bitmap finalBitmap, String path) {
        return saveBitmap(finalBitmap, new File(path));
    }

    public static String saveBitmap(Bitmap finalBitmap, File file) {
        if (file.exists()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
