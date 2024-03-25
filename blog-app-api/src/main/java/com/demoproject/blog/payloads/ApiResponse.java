package com.demoproject.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {

	 public ApiResponse(String message2, boolean b) {
		// TODO Auto-generated constructor stub
		 message=message2;
		 success=b;
	}
	private String message;
	 private boolean success;
}
