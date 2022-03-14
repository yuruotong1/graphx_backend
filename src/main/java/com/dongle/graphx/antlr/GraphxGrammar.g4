grammar GraphxGrammar;
import GraphxLexer;

@header {
package com.dongle.graphx.antlr.code;
}

stat  :statement* EOF;
statement : structDefile
       | lineExpression;
structDefile :Identifier structBody;
structBody:  '{' statement* '}';
lineExpression : nodeId (lineStatement nodeId)*;
lineStatement  : Line lineText? Line Arrow?;
lineText: Identifier;
nodeId: Identifier;


