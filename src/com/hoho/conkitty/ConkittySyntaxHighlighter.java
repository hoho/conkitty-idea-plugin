package com.hoho.conkitty;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.hoho.conkitty.psi.ConkittyTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;


public class ConkittySyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("CONKITTY_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey TEMPLATE_NAME = createTextAttributesKey("CONKITTY_TEMPLATE_NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey TAG = createTextAttributesKey("CONKITTY_TAG", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey VARIABLE_NAME = createTextAttributesKey("CONKITTY_VARIABLE", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey STRING = createTextAttributesKey("CONKITTY_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("CONKITTY_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("CONKITTY_BAD_CHARACTER", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE);

    private static final TextAttributesKey[] KEYWORDS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] TEMPLATE_NAMES = new TextAttributesKey[]{TEMPLATE_NAME};
    private static final TextAttributesKey[] TAGS = new TextAttributesKey[]{TAG};
    private static final TextAttributesKey[] VARIABLE_NAMES = new TextAttributesKey[]{VARIABLE_NAME};
    private static final TextAttributesKey[] STRINGS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] COMMENTS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] BAD_CHARACTERS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] EMPTY = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ConkittyLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ConkittyTypes.NAME)) {
            return TEMPLATE_NAMES;
        } else if (tokenType.equals(ConkittyTypes.KEYWORD)) {
            return KEYWORDS;
        } else if (tokenType.equals(ConkittyTypes.IDENTIFIER)) {
            return VARIABLE_NAMES;
        } else if (tokenType.equals(ConkittyTypes.COMMENT)) {
            return COMMENTS;
        } else if (tokenType.equals(ConkittyTypes.STRING)) {
            return STRINGS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHARACTERS;
        } else {
            return EMPTY;
        }
    }
}
