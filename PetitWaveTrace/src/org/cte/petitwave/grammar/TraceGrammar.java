package org.cte.petitwave.grammar;

import static org.petitparser.Chars.character;
import static org.petitparser.Chars.pattern;
import static org.petitparser.Chars.anyOf;
import static org.petitparser.Chars.digit;
import static org.petitparser.Parsers.string;

import java.lang.reflect.Field;

import org.petitparser.tools.CompositeParser;
import org.petitparser.parser.Parser;
import org.petitparser.tools.Production;

@SuppressWarnings("deprecation")
public class TraceGrammar extends CompositeParser {
	Parser 
		number,
		identifier,
		identLetter,
		instanceName,
		fieldValue,
		arrayValue,
		recordValue,
		booleanValue,
		field,
		fiInstanceName,
		stateName,
		processState,
		process,
		channels,
		violatedAsserts,
		configurationElement,
		configuration,
		transition,
		transitionDetail,
		traceFile;
	
	private Field lookupField(Class<?> start, String name) {
		try {
			Field field = start.getDeclaredField(name);
			field.setAccessible(true);
			return field;
		} catch (SecurityException exception) {
			throw new IllegalStateException(name + " cannot be accessed in " + start.getName());
		} catch (NoSuchFieldException exception) {
			throw new IllegalStateException(name + " is not a valid field in " + start.getName());
	    }
	}
	
	public Parser parserAt(String aRule) {
		Field theField = this.lookupField(this.getClass(), aRule);
		
		try {
			return (Parser)theField.get(this);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Production
	public Parser number() {
		return digit().plus().flatten().token().trim();
	}
	
	@Production
	public Parser identLetter() {
		return pattern("a-zA-Z").or(anyOf("_-"));
	}
	
	@Production
	public Parser identifier() {
		return 		 identLetter
				.seq((	  identLetter
					  .or(digit())).star())
				.flatten().token().trim();
	}
	
	@Production
	public Parser instanceName() {
		return 		 character('{')
				.seq(identifier, 
					 character('}'), 
					 number);
	}
	
	@Production
	public Parser fiInstanceName() {
		return 		 character('\'')
				.seq(instanceName, 
					 character('\''));
	}
	
	@Production
	public Parser field() {
		return 		 identifier.trim()
				.seq(character('=').trim(),
					 fieldValue.trim());
	}
	
	@Production
	public Parser fieldValue() {
		return     	arrayValue
				.or(recordValue, 
					number, 
					booleanValue);
	}
	
	@Production
	public Parser booleanValue() {
		return 		string("true").flatten().token().trim()
				.or(string("false").flatten().token().trim());
	}
	
	@Production
	public Parser arrayValue() {
		return 		 character('[')
				.seq(fieldValue.separatedBy(character(',').trim()).optional(), 
					 character(']'));
	}
	
	@Production
	public Parser recordValue() {
		return 		 character('{')
				.seq(field.separatedBy(character(',').trim()),
					 character('}'));
	}
	
	@Production
	public Parser stateName() {
		return character('@').optional().seq(identifier, character(',').optional().trim());
	}
	
	@Production
	public Parser processState() {
		return 		  stateName.optional()
				.seq(    (character('-').trim()
					 .seq(field)).star());
	}
	
	@Production
	public Parser process() {
		return       (fiInstanceName.or(instanceName))
				.seq(character('['),
					 processState,
					 character(']'));
	}
	
	@Production
	public Parser channels() {
		return 		 string("Channels").token().trim()
				.seq(identifier.separatedBy(character(',').trim()));
	}
	
	@Production
	public Parser violatedAsserts() {
		return 		 string("Violated asserts:").token().trim()
				.seq(    string("none").token().trim()
					 .or(instanceName.separatedBy(character(',').trim())));
	}
	
	@Production
	public Parser configurationElement() {
		return 		 character('-')
				.seq(    process
					 .or(channels,
					     violatedAsserts));
	}
	
	@Production
	public Parser configuration() {
		return 		 number()
				.seq(character('{'),
					 configurationElement.star(),
					 character('}'));
	}
	
	@Production
	public Parser transitionDetail() {
		return 		character('"')
			   .seq(character('"').negate().star(),
					character('"'));
	}
	
	@Production
	public Parser transition() {
		return 		 character('(').trim()
				.seq(number,
					 character(',').trim(),
					 transitionDetail,
					 character(',').trim(),
					 number,
					 character(')').trim());
	}
	
	@Production
	public Parser traceFile() {
		return 		 configuration.star()
				.seq(transition.star());
	}
	
	@Override
	public Parser start(){
		return traceFile;
	}

}
