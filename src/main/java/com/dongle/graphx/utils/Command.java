package com.dongle.graphx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(Command.class);

    public static void run(String command) {
        try {
            LogUtil.info(LOGGER, "Run command", command);
            Process proc = Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            StringBuilder stdInputString = new StringBuilder();
            String s;
            while ((s = stdInput.readLine()) != null) {
                stdInputString.append(s).append("\n");
            }
            if (stdInputString.length() > 0) {
                LogUtil.info(LOGGER, "command success result", stdInputString.toString());
            }
            StringBuilder stdErrorString = new StringBuilder();
            while ((s = stdError.readLine()) != null) {
                stdErrorString.append(s).append("\n");
            }
            if (stdErrorString.length() > 0) {
                LogUtil.info(LOGGER, "command err result", stdErrorString.toString());
            }

        } catch (IOException e) {
            LogUtil.error(LOGGER, e);
        }


    }
}
