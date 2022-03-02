grammar GraphxGrammar;
@header {
package com.dongle.graphx.antlr.code;
}

stat    : expr (NEWLINE+ expr)* NEWLINE* #statExpr
          | NEWLINE+  #statNewLine
          | STRING   # node;

expr    :STRING (line STRING)+;

line    : LINE STRING LINE ARROW    #lineStringLineArrow
        | LINE LINE ARROW           #lineLineArrow
        | LINE STRING LINE          #lineStringLine
        | LINE LINE                 #lineLine;

STRING      :   (~('-'|'>'|'\n'|'\r')|'\\-'|'\\>')+;
LINE        :   '-';
ARROW       :   '>';
NEWLINE     :   '\r'?'\n'; //匹配新行
WS : [ \t]+ -> skip;