package com.hoho.conkitty;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.hoho.conkitty.psi.ConkittyTypes.*;

%%

%public
%class ConkittyLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%eof{ return;
%eof}

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

COMMENT="//".*
MULTILINE_COMMENT="/*"(.|{EOL})*"*/"
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
IDENTIFIER=[:letter:][a-zA-Z_0-9]*

%%
<YYINITIAL> {
  {WHITE_SPACE}                { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "name"                       { return NAME; }
  "INDENT"                     { return INDENT; }
  "DEDENT"                     { return DEDENT; }
  "CRLF"                       { return CRLF; }
  "css"                        { return CSS; }
  "javascript"                 { return JAVASCRIPT; }
  "command"                    { return COMMAND; }

  {COMMENT}                    { return COMMENT; }
  {MULTILINE_COMMENT}          { return COMMENT; }
  {STRING}                     { return STRING; }
  {IDENTIFIER}                 { return IDENTIFIER; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
