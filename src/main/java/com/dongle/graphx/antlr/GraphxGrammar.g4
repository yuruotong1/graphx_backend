grammar GraphxGrammar;
import GraphxLexer;

@header {
package com.dongle.graphx.antlr.code;
}

stat  :statement* EOF;

lineExpression : lineExpression Line opLineString=Identifier? Line opLineArrow=Arrow? lineExpression #  expression
               | Identifier  # identifier;

statement : structDefile
       | lineExpression;
structDefile :Identifier structBody;
structBody:  '{' statement* '}';


