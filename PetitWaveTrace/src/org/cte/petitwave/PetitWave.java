package org.cte.petitwave;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.petitparser.Parsing;
import org.petitparser.buffer.Buffer;
import org.petitparser.context.Context;
import org.petitparser.context.Result;
import org.petitparser.parser.Parser;
import org.cte.petitwave.grammar.TraceGrammar;

public class PetitWave {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("C:\\java\\workspace\\PetitWaveTrace\\resources\\testP.otr"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		Parser traceParser = new TraceGrammar();

		Result r = Parsing.parse(traceParser, br.toString());
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
