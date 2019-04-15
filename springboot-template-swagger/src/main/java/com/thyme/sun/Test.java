package com.thyme.sun;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.thyme.sun.config.YmlConfigStore;

public class Test {
	public static void main(String[] args) {
		System.out.println(YmlConfigStore.get("filter_url", List.class));
	}
}
