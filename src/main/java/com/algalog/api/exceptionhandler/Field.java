package com.algalog.api.exceptionhandler;

public class Field {
		
		public Field(String name, String message) {
			super();
			this.name = name;
			this.message = message;
		}
			private String name;
			private String message;
			
			public String getName() {
				return name;
			}
			public String getMessage() {
				return message;
			}
}
