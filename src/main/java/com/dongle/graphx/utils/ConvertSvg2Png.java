package com.dongle.graphx.utils;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConvertSvg2Png {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConvertSvg2Png.class);

    public static void convertSvg2Png(InputStream svgIn, FileOutputStream pngFileOutputStream) throws IOException, TranscoderException {

        Transcoder transcoder = new PNGTranscoder();
        try {
            TranscoderInput input = new TranscoderInput(svgIn);
            try {
                TranscoderOutput output = new TranscoderOutput(pngFileOutputStream);
                transcoder.transcode(input, output);
            } catch (TranscoderException e) {
                e.printStackTrace();
            } finally {
                pngFileOutputStream.close();
            }
        } finally {
            svgIn.close();
        }
    }

    public static File convertHttpSvg2Png(String svgUrl, File dir) {
        try {
            File pngFile = File.createTempFile("tmp", ".png", dir);
            FileOutputStream fileOutputStream = new FileOutputStream(pngFile);
            InputStream svgIn = HttpUtil.getInputStream(svgUrl);
            convertSvg2Png(svgIn, fileOutputStream);
            if (pngFile.exists()) {
                LogUtil.info(LOGGER, "convert svg to png success", pngFile.getAbsolutePath());
            } else {
                LogUtil.error(LOGGER, "convert svg to png error");
            }
            return pngFile;
        } catch (IOException | TranscoderException e) {
            LogUtil.error(LOGGER, e);
        }
        return null;

    }


}
