package org.cte.petitwave.grammar;

import static org.petitparser.Chars.character;
import static org.petitparser.Chars.pattern;
import static org.petitparser.Chars.anyOf;
import static org.petitparser.Chars.digit;
import static org.petitparser.Parsers.string;
import org.petitparser.parser.CompositeParser;

public class TraceGrammar extends CompositeParser {

	@Override
	protected void initialize() {
		def("number", 
					digit().plus().flatten().token().trim());
		
		def("identLetter", pattern("a-zA-Z").or(anyOf("_-")));
		
		def("identifier", 
					 ref("identLetter")
				.seq(	(ref("identLetter")
				     .or(digit())).star())
				.flatten().token().trim()
		);
		def("instanceName", 
					 character('{')
				.seq(ref("identifier"), 
					 character('}'), 
					 ref("number")));
		def("fiInstanceName",
					 character('\'')
				.seq(ref("instanceName"), 
					 character('\''))
		);
		def("field",
					 ref("identifier").trim()
				.seq(character('=').trim(),
					 ref("fieldValue").trim())
		);
		def("fieldValue", 
					ref("arrayValue")
				.or(ref("recordValue"), 
					ref("number"), 
					ref("booleanValue"))
		);
		def("booleanValue",
					string("true").flatten().token().trim()
				.or(string("false").flatten().token().trim())
		);
		def("arrayElements",
				ref("fieldValue").separatedBy(character(',').trim())
		);
		def("arrayValue",
					 character('[')
				.seq(ref("arrayElements").optional(), 
					 character(']'))
		);
		def("recordElements",
				ref("field").separatedBy(character(',').trim())
		);
		def("recordValue",
					 character('{')
				.seq(ref("recordElements"),
					 character('}'))
		);
		def("stateName",
					 character('@').optional()
				.seq(ref("identifier"), 
					 character(',').optional().trim())
		);
		def("processState",
					 ref("stateName").optional()
				.seq(ref("fields").optional())
		);
		def("fields",
				 	 character('-').trim()
				.seq(ref("field").separatedBy(character('-').trim()))
		);
		def("process",
					(ref("fiInstanceName").or(ref("instanceName")))
				.seq(character('[').trim(),
					 ref("processState"),
					 character(']').trim())
		);
		def("channels", 
					 string("Channels").token().trim()
				.seq(ref("identifier").separatedBy(character(',').trim()))
		);
		def("violatedAsserts",
					 string("Violated asserts:").token().trim()
				.seq(    string("none").token().trim()
					 .or(ref("instanceName").separatedBy(character(',').trim())))
		);
		def("configurationElement",
					 character('-').trim()
				.seq(    ref("process")
					 .or(ref("channels"),
						 ref("violatedAsserts")))
		);
		def("configuration",
					 ref("number")
				.seq(character('{').trim(),
					 ref("configurationElement").star(),
					 character('}').trim())
		);
		def("transitionDetail",
					 	character('"')
				   .seq(character('"').negate().star(),
						character('"'))
		);
		def("transition",
					 character('(').trim()
				.seq(ref("number"),
					 character(',').trim(),
					 ref("transitionDetail"),
					 character(',').trim(),
					 ref("number"),
					 character(')').trim())
		);
		def("traceFile",
					 ref("configuration").star()
				.seq(ref("transition").star())
		);
		def("start",
				ref("traceFile")
		);
	}
}
