package com.assessment.Ecommerce.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*
* Response Message that has to be sent when any exception occurs
*
* @author Gaurav
* 
*
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	private String error_message;

}