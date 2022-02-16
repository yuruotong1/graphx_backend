package com.dongle.graphx.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class TempFile {
    private static final Logger LOGGER = LoggerFactory.getLogger(TempFile.class);

    public static File createDir() {
        String tempPath = System.getProperty("java.io.tmpdir");
        File tempDir = new File(tempPath + "/graphxTemp/" + UUID.randomUUID() + "/");
        boolean createResult = tempDir.mkdirs();
        if (!createResult) {
            LogUtil.error(LOGGER, new Exception(), "Dir create error");
        }
        LogUtil.info(LOGGER, "create dir", tempDir.getAbsolutePath());
        return tempDir;
    }

    public static File createFile(File dir, String fileName, String content) {
        File file = new File(dir.getAbsolutePath() +"/"+ fileName);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            LogUtil.error(LOGGER, e);
        }
        LogUtil.info(LOGGER, "create file", file.getAbsolutePath());
        return file;
    }

    public static File createTempFile(String fileName, String content) {
        File tempDir = createDir();
        return createFile(tempDir, fileName, content);
    }

    public static void deleteDir(File file) {
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            assert fs != null;
            for (File f : fs) {
                if (f.isDirectory()) {
                    deleteDir(f);
                } else {
                    boolean deleteResult = f.delete();
                    if (!deleteResult) {
                        LogUtil.error(LOGGER, "delete file error", f.getAbsolutePath());
                    }
                }
            }
        }
        boolean deleteResult = file.delete();
        if (!deleteResult) {
            LogUtil.error(LOGGER, "delete file error", file.getAbsolutePath());
        }
    }


}
