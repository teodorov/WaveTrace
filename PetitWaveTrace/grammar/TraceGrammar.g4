/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

grammar TraceGrammar;

CHANNELS : 'Channels';
VIOLATEDASSERTS : 'Violated asserts:';
NONE : 'none';
TRUE : 'true';
FALSE : 'false';
LCURLY : '{';
RCURLY : '}';
LSQUARE : '[';
RSQUARE : ']';
LPAREN : '(';
RPAREN : ')';
TICK : '\'';
EQ : '=';
COMMA : ',';
AT : '@';
MINUS : '-';
DQUOTE : '"';
COLON: ':';
TransitionDetail: ('"' .*? '"');
Number : ('+'|'-')?[0-9]+;
Identifier : [a-zA-Z] ([a-zA-Z0-9_-])* ;

identifier : Identifier (COLON Identifier)*;
instanceName : LCURLY identifier RCURLY Number;
fiInstanceName : TICK instanceName TICK;
field : identifier EQ fieldValue;
fieldValue : arrayValue
           | recordValue
           | numberValue
           | booleanValue;

booleanValue : TRUE | FALSE;
numberValue : Number;
arrayElements : fieldValue (COMMA fieldValue)*;
arrayValue : LSQUARE arrayElements? RSQUARE;
recordElements : field (COMMA field)*;
recordValue : LCURLY recordElements RCURLY;
stateName: AT? identifier COMMA?;
processState: stateName? (MINUS field)*;
process: (fiInstanceName | instanceName) LSQUARE processState RSQUARE;
channels: CHANNELS identifier (COMMA identifier)*;
violatedAsserts: VIOLATEDASSERTS NONE | (instanceName (COMMA instanceName)*);
configurationElement: MINUS (process | channels | violatedAsserts);
configuration: Number LCURLY configurationElement+ RCURLY;

transition: LPAREN Number COMMA TransitionDetail COMMA Number RPAREN;
traceFile : configuration* transition*;

WS : [ \r\t\n]+ -> skip ;