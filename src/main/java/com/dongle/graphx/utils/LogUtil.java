package com.dongle.graphx.utils;

import org.slf4j.Logger;

public class LogUtil {
    public static void info(Logger logger, String... msgs) {
        logger.info(String.join(",", msgs));

    }

    public static void error(Logger logger, Exception e, String... msgs) {
        String errMsg = e.toString();
        errMsg += String.join(",", msgs);
        logger.error(errMsg);

    }
    public static void error(Logger logger, String... msgs) {
        String errMsg = "";
        errMsg += String.join(",", msgs);
        logger.error(errMsg);

    }
}
