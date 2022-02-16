grammar GraphxGrammar;
@header {
package com.dongle.graphx.antlr.code;
}

stat    : expr (NEWLINE+ expr)* NEWLINE* #statExpr
        | NEWLINE+  #statNewLine;

expr    :STRING line STRING (line STRING)*;

line    : LINE LINE                 #lineLine
        | LINE STRING LINE          #lineStringLine
        | LINE LINE ARROW           #lineLineArrow
        | LINE STRING LINE ARROW    #lineStringLineArrow;

STRING      :   [\u4e00-\u9fa5a-zA-Z0-9_]+;
LINE        :   '-';
ARROW       :   '>';
COLON       :   ':';
NEWLINE     :   '\r'?'\n';  //匹配新行
WS : [ \t]+ -> skip;