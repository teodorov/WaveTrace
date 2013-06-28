package org.cte.petitwave;



import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.cte.PetitWaveTrace.grammar.TraceGrammarLexer;
import org.cte.PetitWaveTrace.grammar.TraceGrammarParser;

public class PetitWave {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ANTLRFileStream fs;
		try {
			fs = new ANTLRFileStream("C:\\scm\\WaveTrace\\PetitWaveTrace\\resources\\testP.otr");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		TraceGrammarLexer lexer = new TraceGrammarLexer(fs);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TraceGrammarParser parser = new TraceGrammarParser(tokens);
		ParseTree tree = parser.traceFile();
		
		System.out.println(tree.toStringTree(parser));
	}

}
