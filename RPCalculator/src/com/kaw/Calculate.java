package com.kaw;

import java.io.*;
import java.util.*;

public class Calculate  {
	public static double solve(String s){
		Stack<String> tks = new Stack<String>();
		tks.addAll(Arrays.asList(s.trim().split("[ \t]+")));
		try  {
			double r = mathFn(tks);
			if (!tks.empty())  throw new Exception();
			return r;
		} catch (Exception e)  {
			System.out.println("error");
		}
		return 0;
	}

	private static double mathFn(Stack<String> tks) throws Exception {
		String tk = tks.pop();
		double x,y;
		try  {
			x = Double.parseDouble(tk);
		} catch (Exception e)  {
			if (tk.equals("Sin") || tk.equals("Cos") || tk.equals("Sqrt") || tk.equals("Tan")){
				x = mathFn(tks);
				if (tk.equals("Cos"))
					return Math.acos(x);
				else if (tk.equals("Sin"))
					return Math.asin(x);
				else if (tk.equals("Sqrt"))
					return Math.sqrt(x);
				else if (tk.equals("Tan"))
					return Math.atan(x);
			}
			else if (tk.equals("+") || tk.equals("-") || tk.equals("*") || tk.equals("/")){
				y = mathFn(tks);
				x = mathFn(tks);
				if      (tk.equals("+"))  x += y;
				else if (tk.equals("-"))  x -= y;
				else if (tk.equals("*"))  x *= y;
				else if (tk.equals("/"))  x /= y;
			}
			else if (tk.equals("x")){
				x = RPCalculatorActivity.x;
			}

			else throw new Exception();
		}
		return x;
	}
}
