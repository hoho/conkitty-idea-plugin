package com.hoho.conkitty;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.hoho.conkitty.psi.ConkittyTypes.*;

%%

%line
%column
%class _ConkittyLexer
%abstract
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

%{
  _ConkittyLexer() {
    this((java.io.Reader)null);
  }

  public int yycolumn = 0;
  public int yyline = 0;

  public final void setStart(int start) {
    zzCurrentPos = zzStartRead = start;
  }

  protected abstract void readJavaScript() throws java.io.IOException;
  protected abstract void readMultilineJavaScript() throws java.io.IOException;
%}


CRLF = (\r|\n|\r\n)+
WHITE_SPACE = [\ \t\f]+
COMMENT = "//" [^\r\n]*
LONG_COMMENT = "/*" !([^]* "*/" [^]*) "*/"?
STRING = \"([^\"\r\n\\]|\\.)*\" | '([^'\r\n\\]|\\.)*' | \"\"\"([^\"\r\n\\]|\\.)*\"\"\" | '''([^'\r\n\\]|\\.)*'''

TPL_NAME = (([a-zA-Z0-9_-]*(\:\:)?[a-zA-Z0-9_-]+)|([a-zA-Z0-9_-]+\:\:))
TPL_NS_NAME = ([a-zA-Z0-9_-]*\:\:[a-zA-Z0-9_-]+)
JS_NAME = [a-zA-Z_][a-zA-Z0-9_]*
CMD_NAME = "AS"|"ATTR"|"CHOOSE"|"EACH"|"ELSE"|"EXCEPT"|"MEM"|"OTHERWISE"|"PAYLOAD"|"SET"|"TEST"|"TRIGGER"|"WHEN"|"WITH"

VARIABLE = "$" {JS_NAME}

CSS_BEM_NAME = [a-zA-Z0-9-]+
CSS_NAME = [a-zA-Z_0-9-]+

CSS_TAG = [a-z][a-z0-9_-]*
CSS_CLASS = "." {CSS_NAME}
CSS_ID = "#" {CSS_NAME}
CSS_PSEUDO = ":" {CSS_NAME} "("

CSS_BEM = "%" {CSS_BEM_NAME} ("(" {CSS_BEM_NAME} ")")?

ATTR = @ {CSS_NAME}
INCLUDE = "&" {STRING}


%state IN_TEMPLATE
%state AFTER_CALL
%state IN_CALL
%state IN_COMMENT
%state NO_JS
%state MULTILINE_JS

%%

<YYINITIAL>          {TPL_NAME}                      { yybegin(IN_TEMPLATE); return TEMPLATE_NAME; }
<YYINITIAL>          {WHITE_SPACE}                   { yybegin(IN_TEMPLATE); return com.intellij.psi.TokenType.WHITE_SPACE; }

                     {LONG_COMMENT}                  { return COMMENT; }

                     "JS"                            { yybegin(MULTILINE_JS); return COMMAND_NAME; }
<MULTILINE_JS>       [^]*                            { readMultilineJavaScript(); return JAVASCRIPT; }

                     "CALL"                          { yybegin(AFTER_CALL); return COMMAND_NAME; }
                     {TPL_NS_NAME}                   { yybegin(IN_CALL); return TEMPLATE_NAME; }

<AFTER_CALL>         {TPL_NAME}                      { yybegin(IN_CALL); return TEMPLATE_NAME; }
<IN_CALL>            {JS_NAME}                       { return VARIABLE; }

                     {CMD_NAME}                      { return COMMAND_NAME; }

                     {VARIABLE}                      { return VARIABLE; }

                     {CSS_TAG}                       { return CSS_TAG; }
                     {CSS_CLASS}                     { return CSS_CLASS; }
                     {CSS_ID}                        { return CSS_ID; }

                     {CSS_PSEUDO}                    { yypushback(1); yybegin(NO_JS); return CSS_IF; }

                     {CSS_BEM}                       { return CSS_CLASS; }

                     {ATTR}                          { return ATTR; }

                     {INCLUDE}                       { return INCLUDE; }

                     "["                             { return LSBRACKET; }
                     "]"                             { return RSBRACKET; }

                     "{"                             { return LCBRACKET; }
                     "}"                             { return RCBRACKET; }

                     {STRING}                        { return STRING; }
<NO_JS>              "("                             { yybegin(IN_TEMPLATE); return LBRACKET; }
                     "("                             { readJavaScript(); return JAVASCRIPT; }
                     ")"                             { return RBRACKET; }

                     "="                             { return RET_MAKER; }
                     "+"                             { return CSS_CLASS; }
                     "-"                             { return CSS_CLASS; }
                     "^"                             { return NODE_APPENDER; }

                     ","                             { return COMMA; }

                     {COMMENT}                       { return COMMENT; }
                     {WHITE_SPACE}                   { return com.intellij.psi.TokenType.WHITE_SPACE; }

                     {CRLF}                          { yybegin(YYINITIAL); return CRLF; }
                     .                               { return com.intellij.psi.TokenType.BAD_CHARACTER; }
