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
    public static final TextAttributesKey COMMAND_NAME = createTextAttributesKey("CONKITTY_COMMAND_NAME", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey TEMPLATE_NAME = createTextAttributesKey("CONKITTY_TEMPLATE_NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey TAG = createTextAttributesKey("CONKITTY_TAG", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey VARIABLE_NAME = createTextAttributesKey("CONKITTY_VARIABLE", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey STRING = createTextAttributesKey("CONKITTY_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey JAVASCRIPT = createTextAttributesKey("CONKITTY_JAVASCRIPT", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("CONKITTY_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey COMMA = createTextAttributesKey("CONKITTY_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey BRACKET = createTextAttributesKey("CONKITTY_BRACKET", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey PSEUDO = createTextAttributesKey("CONKITTY_PSEUDO", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    public static final TextAttributesKey ASSIGN = createTextAttributesKey("CONKITTY_ASSIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey INCLUDE = createTextAttributesKey("CONKITTY_INCLUDE", DefaultLanguageHighlighterColors.METADATA);

    private static final TextAttributesKey[] COMMAND_NAMES = new TextAttributesKey[]{COMMAND_NAME};
    private static final TextAttributesKey[] TEMPLATE_NAMES = new TextAttributesKey[]{TEMPLATE_NAME};
    private static final TextAttributesKey[] TAGS = new TextAttributesKey[]{TAG};
    private static final TextAttributesKey[] VARIABLE_NAMES = new TextAttributesKey[]{VARIABLE_NAME};
    private static final TextAttributesKey[] STRINGS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] JAVASCRIPTS = new TextAttributesKey[]{JAVASCRIPT};
    private static final TextAttributesKey[] COMMENTS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] COMMAS = new TextAttributesKey[]{COMMA};
    private static final TextAttributesKey[] BRACKETS = new TextAttributesKey[]{BRACKET};
    private static final TextAttributesKey[] PSEUDOS = new TextAttributesKey[]{PSEUDO};
    private static final TextAttributesKey[] ASSIGNS = new TextAttributesKey[]{ASSIGN};
    private static final TextAttributesKey[] INCLUDES = new TextAttributesKey[]{INCLUDE};
    private static final TextAttributesKey[] EMPTY = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ConkittyLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ConkittyTypes.TEMPLATE_NAME)) {
            return TEMPLATE_NAMES;
        } else if (tokenType.equals(ConkittyTypes.COMMAND_NAME) ||
                   tokenType.equals(ConkittyTypes.NODE_APPENDER)) {
            return COMMAND_NAMES;
        } else if (tokenType.equals(ConkittyTypes.VARIABLE)) {
            return VARIABLE_NAMES;
        } else if (tokenType.equals(ConkittyTypes.JAVASCRIPT)) {
            return JAVASCRIPTS;
        } else if (tokenType.equals(ConkittyTypes.COMMENT)) {
            return COMMENTS;
        } else if (tokenType.equals(ConkittyTypes.STRING)) {
            return STRINGS;
        } else if (tokenType.equals(ConkittyTypes.CSS_TAG) ||
                   tokenType.equals(ConkittyTypes.CSS_CLASS) ||
                   tokenType.equals(ConkittyTypes.CSS_ID) ||
                   tokenType.equals(ConkittyTypes.ATTR))
        {
            return TAGS;
        } else if (tokenType.equals(ConkittyTypes.COMMA)) {
            return COMMAS;
        } else if (tokenType.equals(ConkittyTypes.LBRACKET) ||
                   tokenType.equals(ConkittyTypes.RBRACKET) ||
                   tokenType.equals(ConkittyTypes.LSBRACKET) ||
                   tokenType.equals(ConkittyTypes.RSBRACKET) ||
                   tokenType.equals(ConkittyTypes.LCBRACKET) ||
                   tokenType.equals(ConkittyTypes.RCBRACKET)) {
            return BRACKETS;
        } else if (tokenType.equals(ConkittyTypes.CSS_IF)) {
            return PSEUDOS;
        } else if (tokenType.equals(ConkittyTypes.ASSIGN)) {
            return ASSIGNS;
        } else if (tokenType.equals(ConkittyTypes.INCLUDE)) {
            return INCLUDES;
        } else {
            return EMPTY;
        }
    }
}
