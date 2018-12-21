package com.test.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static void saveFile(String dir,String fileName,byte [] data) {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        File var1 = new File(dir+fileName);
        try {
            FileOutputStream outputStream = new FileOutputStream(var1);
            outputStream.write(data);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
