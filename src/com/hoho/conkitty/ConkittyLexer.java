package com.hoho.conkitty;

import com.hoho.conkitty.psi.ConkittyTypes;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;

import java.io.IOException;

public class ConkittyLexer extends LookAheadLexer {
    public ConkittyLexer() {
        super(new FlexAdapter(new _ConkittyLexer() {
            @Override
            protected void readJavaScript() throws IOException {
                final int state = yystate();
                final int start = getTokenStart();
                while (true) {
                    final IElementType type = advance();
                    if (type == null || type == ConkittyTypes.RBRACKET) {
                        break;
                    }
                }
                setStart(start);
                yybegin(state);
            }

            @Override
            protected void readMultilineJavaScript() throws IOException {
                int size = 0;
                int curIndent = yycolumn;
                CharSequence text = yytext();

                for (int i = 0; i < text.length(); i++) {
                    char cur = text.charAt(i);

                    if (cur == '\n' || cur == '\r') {
                        curIndent = 0;
                    } else {
                        if (cur == ' ' || cur == '\t') {
                            curIndent++;
                        } else {
                            if (curIndent < yycolumn - 1) {
                                size -= (curIndent + 1);
                                break;
                            }
                        }
                    }

                    size++;
                }

                yypushback(yylength() - size);
                yybegin(YYINITIAL);
            }
        }));
    }

    protected static void setState(Lexer baseLexer, int state) {
        ((FlexAdapter) baseLexer).getFlex().yybegin(state);
    }

    @Override
    protected void lookAhead(Lexer baseLexer) {
        final IElementType type = baseLexer.getTokenType();
        advanceAs(baseLexer, type);
    }
}
