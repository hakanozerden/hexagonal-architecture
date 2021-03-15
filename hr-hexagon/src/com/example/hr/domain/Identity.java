package com.example.hr.domain;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/**
 * @author hakan.ozerden
 */
public class Identity {

	private final String value;
	private final static Map<String, Identity> identityCache = new WeakHashMap<>();

	private Identity(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Identity valueOf(String value) {
		Objects.requireNonNull(value);
		// validation : cross-cutting concern
		if (!isValidate(value))
			throw new IllegalArgumentException("This is not  valid identity no.");
		// caching -> Fly-weight (GoF) : cross-cutting concern
		synchronized (Identity.class) {
			var identity = identityCache.get(value);
			if (Objects.isNull(identity)) {
				identity = new Identity(value);
				identityCache.put(value, identity);
			}
			return identity;
		}
	}

	private static boolean isValidate(String value) {
		if (value == null)
			return false;
		if (!value.matches("^\\d{11}$")) {
			return false;
		}
		int[] digits = new int[11];
		for (int i = 0; i < digits.length; ++i) {
			digits[i] = value.charAt(i) - '0';
		}
		int x = digits[0];
		int y = digits[1];
		for (int i = 1; i < 5; i++) {
			x += digits[2 * i];
		}
		for (int i = 2; i <= 4; i++) {
			y += digits[2 * i - 1];
		}
		int c1 = 7 * x - y;
		if (c1 % 10 != digits[9]) {
			return false;
		}
		int c2 = 0;
		for (int i = 0; i < 10; ++i) {
			c2 += digits[i];
		}
		if (c2 % 10 != digits[10]) {
			return false;
		}
		return true;
	}

}
