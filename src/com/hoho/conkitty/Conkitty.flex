package com.hoho.conkitty;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.hoho.conkitty.psi.ConkittyTypes.*;

%%

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

  public final void setStart(int start) {
    zzCurrentPos = zzStartRead = start;
  }

  private int afterJavaScript = YYINITIAL;

  protected abstract void readJavaScript(int state) throws java.io.IOException;
%}

CRLF = \r | \n | \r\n
WHITE_SPACE = [\ \t\f]+
IDENTIFIER = [a-zA-Z_][a-zA-Z_0-9]*
STRING = ('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
KEYWORD = "ATTR"|"CALL"|"CHOOSE"|"EACH"|"INSERT"|"SET"|"TEST"|"WITH"|"WHEN"|"OTHERWISE"|"ELSE"|"PAYLOAD"
COMMENT = "//" [^\r\n]* {CRLF} | "/*" [^*] ~"*/" | "/*" "*"+ "/"
JAVASCRIPT = . | {WHITE_SPACE} | {CRLF} | {COMMENT} | {STRING}
CSS = {IDENTIFIER}
ATTR = @[a-zA-Z_-]+


%state IN_COMMENT
%state IN_LONG_COMMENT
%state IN_TEMPLATE
%state IN_VAR_DECL
%state IN_JAVASCRIPT
%state IN_JAVASCRIPT2
%state IN_CALL

%%

<YYINITIAL>          {IDENTIFIER}                    { yybegin(IN_VAR_DECL); return TEMPLATE_NAME; }

<IN_VAR_DECL>        {IDENTIFIER}                    { return VARIABLE; }
<IN_VAR_DECL>        {CRLF}                          { yybegin(IN_TEMPLATE); return com.intellij.psi.TokenType.WHITE_SPACE; }

<IN_JAVASCRIPT>      {JAVASCRIPT}                    { yybegin(IN_JAVASCRIPT2); readJavaScript(afterJavaScript); return JAVASCRIPT; }
<IN_JAVASCRIPT2>     {JAVASCRIPT}                    { return JAVASCRIPT; }
                     "("                             { afterJavaScript = yystate(); yybegin(IN_JAVASCRIPT); return JAVASCRIPT_BEGIN; }
                     ")"                             { return JAVASCRIPT_END; }

                     {COMMENT}                       { return COMMENT; }

                     {STRING}                        { return STRING; }

                     "CALL"                          { yybegin(IN_CALL); return KEYWORD; }
<IN_CALL>            {IDENTIFIER}                    { yybegin(IN_TEMPLATE); return TEMPLATE_NAME; }

                     "EACH"                          { yybegin(IN_VAR_DECL); return KEYWORD; }
                     "SET"                           { yybegin(IN_VAR_DECL); return KEYWORD; }
                     "WITH"                          { yybegin(IN_VAR_DECL); return KEYWORD; }


                     {KEYWORD}                       { return KEYWORD; }

<IN_TEMPLATE>        {CSS}                           { return CSS; }
<IN_TEMPLATE>        {ATTR}                          { return CSS; }

                     {WHITE_SPACE}                   { return com.intellij.psi.TokenType.WHITE_SPACE; }
                     {CRLF}                          { return com.intellij.psi.TokenType.WHITE_SPACE; }
                     .                               { return com.intellij.psi.TokenType.BAD_CHARACTER; }
