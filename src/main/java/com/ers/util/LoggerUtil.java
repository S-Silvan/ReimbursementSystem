package com.ers.util;

import org.apache.log4j.LogManager;

public class LoggerUtil {
	private static org.apache.log4j.Logger log = LogManager.getLogger(LoggerUtil.class);
	public static org.apache.log4j.Logger getLog() {
		return log;
	}
}
