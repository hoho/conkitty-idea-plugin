package com.hoho.conkitty;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.hoho.conkitty.psi.ConkittyTypes.*;

%%

%public
%class _ConkittyLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%eof{ return;
%eof}

%{
  _ConkittyLexer() {
    this((java.io.Reader)null);
  }

  public final void setStart(int start) {
    zzCurrentPos = zzStartRead = start;
  }

/*  private IElementType ncName() {
    yybegin(S1);
    return XPathTokenTypes.NCNAME;
  }

  protected abstract void readComment() throws java.io.IOException;*/
%}

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

COMMENT="//".*
MULTILINE_COMMENT="/*"(.|{EOL})*"*/"
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
IDENTIFIER=[:letter:][a-zA-Z_0-9]*

KEYWORD="ATTR"|"CALL"|"CHOOSE"|"EACH"|"INSERT"|"SET"|"TEST"|"WITH"|"WHEN"|"OTHERWISE"|"ELSE"|"PAYLOAD"

%%
<YYINITIAL> {
  {WHITE_SPACE}                { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "name"                       { return NAME; }
  "INDENT"                     { return INDENT; }
  "DEDENT"                     { return DEDENT; }
  "CRLF"                       { return CRLF; }
  "css"                        { return CSS; }
  "javascript"                 { return JAVASCRIPT; }

  {KEYWORD}                    { return KEYWORD; }

  {COMMENT}                    { return COMMENT; }
  {MULTILINE_COMMENT}          { return COMMENT; }
  {STRING}                     { return STRING; }
  {IDENTIFIER}                 { return IDENTIFIER; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
