package com.Java8.newfeature.spring.cool.features.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * https://docs.spring.io/spring-framework/docs/3.0.x/reference/expressions.html
 * */
public class SpringSpel {
	
	static void spelTest() {
		ExpressionParser parser = new SpelExpressionParser();

		// invokes 'getBytes().length'
		Expression exp = parser.parseExpression("'Hello World'.bytes.length");  

		int length = (Integer) exp.getValue();
		
		System.out.println(length);
	}
	
	public static void main(String[] args) {
		spelTest();
	}
}
